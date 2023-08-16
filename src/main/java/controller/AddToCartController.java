package controller;

import java.io.IOException;

import dao.ListProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class AddToCartController
 */
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    try {
		HttpSession session = request.getSession(true);
		String idd = request.getParameter("id");
		String action = request.getParameter("action");
		if(action != null && action.equalsIgnoreCase("add")) {
		    if (session.getAttribute("cart") == null) {	
			session.setAttribute("cart", new Cart());
		    }
		    int id = Integer.parseInt(idd);
		    Product p = new ListProductDao().getProduct(""+ id);
		    Cart c = (Cart) session.getAttribute("cart");
		    c.add(new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getSrc(),p.getType(),p.getBrand(),1));
		}else if (action != null && action.equalsIgnoreCase("delete")) {
		    int id = Integer.parseInt(idd);
		    Cart c = (Cart) session.getAttribute("cart");
		    c.remove(id);
		}else if (action != null && action.equalsIgnoreCase("quantity")) {
		    int id = Integer.parseInt(idd);
		    int quantity = Integer.parseInt(request.getParameter("quantity"));
		    Cart c = (Cart) session.getAttribute("cart");
		    c.setQuantity(id, quantity);
		}
		response.sendRedirect("web/WEB-INF/cart.jsp");
	    } catch (Exception e) {
		response.getWriter().println(e);
	    }
	    
	}
}
