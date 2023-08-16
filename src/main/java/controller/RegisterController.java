package controller;

import java.io.IOException;

import dao.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterController() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getSession(true).invalidate();
	HttpSession session = request.getSession(true);
	String action = request.getParameter("action");
	
	if (action == null) {
	    request.getRequestDispatcher("web/WEB-INF/index.jsp").forward(request, response);
	} else if (action.equals("register")) {
	    session.removeAttribute("userMail");
	    session.removeAttribute("name");
	    session.removeAttribute("address");
	    session.removeAttribute("phone");
	    request.getRequestDispatcher("web/WEB-INF/register.jsp").forward(request, response);
	}
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("web/WEB-INF/index.jsp").forward(request, response);
	    } else if (action.equals("doReg")) {
		AccountDao accDao = new AccountDao();
		request.getSession(true).invalidate();
		// make sure that email is valid
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		// collect data form a login here
		String userMail = request.getParameter("userMail");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneN = request.getParameter("phone");
		HttpSession session = request.getSession(true);
		if (!password.matches(regex) || !userMail.matches(regexMail)) {
		    session.setAttribute("userMail", userMail);
		    session.setAttribute("name", name);
		    session.setAttribute("address", address);
		    session.setAttribute("phone", phoneN);
		    session.setAttribute("error", "Email or Password invalid systax !");
		    response.sendRedirect("web/WEB-INF/register.jsp");
		}else if (accDao.checkExitMail(userMail)) {
		    session.setAttribute("userMail", userMail);
		    session.setAttribute("name", name);
		    session.setAttribute("address", address);
		    session.setAttribute("phone", phoneN);
		    session.setAttribute("error", "UserName/Email already exists !");
		    response.sendRedirect("web/WEB-INF/register.jsp");
		}else {
		    accDao.insertAccount(userMail, password, name, address, phoneN);
		    // set session
		    session.setAttribute("username", userMail);
		    session.removeAttribute("userMail");
		    session.removeAttribute("name");
		    session.removeAttribute("address");
		    session.removeAttribute("phone");
		    response.sendRedirect("web/WEB-INF/login.jsp");
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
