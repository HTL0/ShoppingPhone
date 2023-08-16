package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.product.SearchController;
import dao.ListProductDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 * Servlet implementation class SearchController2
 */
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchController2() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");
	    try (PrintWriter out = response.getWriter()){
		String searchString = request.getParameter("search");
		String index = request.getParameter("index");
		if(index == null ) {
			index = "1";
		    }
		int indexPage = Integer.parseInt(index);
		int endPage = ListProductDao.getNumberPage(searchString);
		List<Product> ls = new ListProductDao().search(searchString,indexPage);
		if (ls.size() == 0) {
		    request.setAttribute("messeger", "Oop! No results found!");
		}
		request.setAttribute("searchKey", searchString);
		request.setAttribute("endSearchPage", endPage);
		request.setAttribute("indexSearchPage", indexPage);
		request.setAttribute("products", ls);
		RequestDispatcher rd = request.getRequestDispatcher("web/WEB-INF/home.jsp");
		rd.forward(request, response);
	    } catch (Exception ex) {
		Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null , ex);
	    } 
	}

}
