package controller;

import java.io.IOException;

import dao.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/*@WebServlet(urlPatterns = { "/login" })*/
/**
 * Servlet implementation class login
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	request.getSession(true).invalidate();
	HttpSession session = request.getSession(true);
	String action = request.getParameter("action");
	
	if (action == null) {
	    request.getRequestDispatcher("web/WEB-INF/index.jsp").forward(request, response);
	} else if (action.equals("login")) {
		//get cookies
		Cookie[] cookies = request.getCookies();
		String usernameC = "", passwordC = "", rememberC="";
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("cookUName")) {
					usernameC = cookie.getValue();
				}
				if(cookie.getName().equals("cookPass")) {
					passwordC = cookie.getValue();
				}
				if(cookie.getName().equals("cookRemember")) {
					rememberC = cookie.getValue();
				}
			}
			session.setAttribute("username", usernameC);
			session.setAttribute("password", passwordC);
			session.setAttribute("remember", rememberC);
			session.setAttribute("error", "");
			request.getRequestDispatcher("web/WEB-INF/login.jsp").forward(request, response);
		}else {
			
			session.setAttribute("username", "");
			session.setAttribute("password", "");
			session.setAttribute("error", "");
			
			request.getRequestDispatcher("web/WEB-INF/login.jsp").forward(request, response);
		}
	}
	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
	processRequest(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("utf-8"); // vietnamese
	try {
	    String action = request.getParameter("action");
	    if (action == null) {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	    } else if (action.equals("dologin")) {
		request.getSession(true).invalidate();
		// make sure that email is valid
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		// collect data form a login here
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		if (!password.matches(regex) || !user.matches(regexMail)) {
		    session.setAttribute("error", "invalid systax");
		    response.sendRedirect("web/WEB-INF/login.jsp");
		}else {
//		    Account acc = new Account();
//		    acc.setName(user);
//		    acc.setPwd(password);
//		    // read information of account in wed.xml
//		    String uid = getServletContext().getInitParameter("username");
//		    String pwd = getServletContext().getInitParameter("password");
//		    // check account - use validate code in assignment 1 to valid user
//		    if (user != null && acc.getPwd().equals(pwd) && acc.getName().equalsIgnoreCase(uid)) {
		    
		    Account acc = new AccountDao().getAccount(user, password);
		    if(acc.getUsr() != null) {
		    	if (request.getParameter("remember") != null) {
					String remember = request.getParameter("remember");
					
					//set cookie
					Cookie cookUName = new Cookie("cookUName", user);
					Cookie cookPass = new Cookie("cookPass", password);
					Cookie cookRemember = new Cookie("cookRemember", remember);
					cookUName.setMaxAge(60*60*24*3); // 3 days
					cookPass.setMaxAge(60*60*24*3);
					cookRemember.setMaxAge(60*60*24*3);
					response.addCookie(cookUName);
					response.addCookie(cookPass);
					response.addCookie(cookRemember);
				}
		    	
			// set session
			session.setAttribute("user", acc);
			session.setAttribute("username", acc.getUsr().substring(0, user.indexOf('@')));
			session.setAttribute("name", acc.getName());
			session.setAttribute("email", acc.getUsr());
			session.setAttribute("address", acc.getAddress());
			session.setAttribute("login", true);
			// login is valid, now redirect to index page of admin
			if (acc.getRote() == 1) {
			    response.sendRedirect("web/admin/index.jsp");	
			    			    
			}else {
			    response.sendRedirect("web/WEB-INF/index.jsp");
			}
			
		    } else {
			session.setAttribute("error", "wrong username or password");
			response.sendRedirect("web/WEB-INF/login.jsp");
		    }
		}
	    }

	} catch (NullPointerException e) {
	    RequestDispatcher rd = request.getRequestDispatcher("web/WEB-INF/login.jsp");
	    rd.forward(request, response);
	} catch (Exception e) {
	    response.getWriter().println(e);
	}

    }

}
