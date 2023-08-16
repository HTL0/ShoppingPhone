package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action == null) {
			request.getRequestDispatcher("web/WEB-INF/home.jsp").forward(request, response);
		}else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute("user");
				session.removeAttribute("username");
				session.removeAttribute("name");
				session.removeAttribute("email");
				session.removeAttribute("address");
				session.setAttribute("login", false);
				
				request.getRequestDispatcher("web/WEB-INF/index.jsp").forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
