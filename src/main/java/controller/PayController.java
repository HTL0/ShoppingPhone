package controller;

import java.io.IOException;

import dao.OrdersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayController
 */
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PayController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    try {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("cart") == null) {
		    request.getRequestDispatcher("AddToCartController").forward(request,response);
		}else {
		    Cart c = (Cart) session.getAttribute("cart");
		    if (c.getItems().size()==0) {
			request.getRequestDispatcher("AddToCartController").forward(request,response);
		    }
		    OrdersDAO dao = new OrdersDAO();
		    String username = request.getParameter("email");
		    String discount = request.getParameter("discount");
		    String address = request.getParameter("address");
		    Orders order = new Orders(username, 2 , discount, address, "", null);
		    dao.insertOrder(order, c);
		    session.setAttribute("cart", null);
		    request.setAttribute("completed", 1);
		    request.getRequestDispatcher("web/WEB-INF/cart.jsp").forward(request,response);
		}
		
		
	    } catch (Exception e) {
		response.getWriter().println(e);
		e.printStackTrace();
	    }
	    
	}

}
