package controller;

import java.io.IOException;
import java.util.List;

import dao.ListProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 * Servlet implementation class PagingController
 */
public class PagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    response.setContentType("text/html;charset=UTF-8");
	    String index = request.getParameter("index");
	    if(index == null ) {
		index = "1";
	    }
	    int indexPage = Integer.parseInt(index);
	    int endPage = ListProductDao.getNumberPage();
	    List<Product> list = ListProductDao.getRecords(indexPage);
	    
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("indexPage", indexPage);
	    request.setAttribute("listP", list);
	    request.getRequestDispatcher("web/WEB-INF/home.jsp").forward(request, response);
	}

}
