package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ListProductDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListController() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	response.setContentType("text/html; charset=UTF-8");
	try (PrintWriter out = response.getWriter()){
	    List<Product> ls = new ListProductDao().search("", -1);
	    request.setAttribute("listP", ls);
	    RequestDispatcher rd = request.getRequestDispatcher("web/admin/list.jsp");
	    rd.forward(request, response);
	} catch (Exception ex) {
	    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
