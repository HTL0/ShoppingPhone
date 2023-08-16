package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDao {
    public ListProductDao() {
	
    }
    
    
    //return the list of products by product name
    public List<Product> search(String characters, int index) throws Exception{
	List<Product> list = new ArrayList<>();
	String query1 = "SELECT * FROM Products where product_name like ? \r\n"
		+ "ORDER BY product_id \r\n"
		+ "OFFSET ? ROWS \r\n"
		+ "FETCH FIRST 6 ROWS ONLY; ";
	String query2 = "SELECT * FROM Products where product_name like ? \r\n"
		+ "ORDER BY product_id \r\n";
	try {
	    Connection con = new DBContext().getConnection();
	    PreparedStatement ps;
	    if (index == -1) {
		ps = con.prepareStatement(query2);
	    }else {
		ps = con.prepareStatement(query1);
		ps.setInt(2, (index - 1) * 6);
	    }
	    ps.setString(1, "%" + characters + "%");
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		Product p = new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setDescription(rs.getString(3));
		p.setPrice(rs.getFloat(4));
		p.setSrc(rs.getString(5));
		p.setType(rs.getString(6));
		p.setBrand(rs.getString(7));
		list.add(p);
	    }
	    con.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
	return list;
    }
    
    
    //get the product
    public Product getProduct(String characters) throws Exception{
	Product p = new Product();
	String query = "SELECT * FROM Products WHERE product_id = ?";
	try {
	    Connection con = new DBContext().getConnection();
	    PreparedStatement ps = con.prepareStatement(query);
	    ps.setString(1, characters);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setDescription(rs.getString(3));
		p.setPrice(rs.getFloat(4));
		p.setSrc(rs.getString(5));
		p.setType(rs.getString(6));
		p.setBrand(rs.getString(7));		
	    }
	    con.close();
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return p;
    }
    
    //get products list for pagination
    public static List<Product> getRecords(int index) {
	List<Product> list = new ArrayList<Product>();
	DBContext db = new DBContext();
	String query = "SELECT * FROM Products \r\n"
		+ "ORDER BY product_id \r\n"
		+ "OFFSET ? ROWS \r\n"
		+ "FETCH FIRST 6 ROWS ONLY; ";
	try {
	    Connection con = db.getConnection();
	    PreparedStatement ps = con.prepareStatement(query);
	    ps.setInt(1, (index - 1) * 6);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		Product p = new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setDescription(rs.getString(3));
		p.setPrice(rs.getFloat(4));
		p.setSrc(rs.getString(5));
		p.setType(rs.getString(6));
		p.setBrand(rs.getString(7));
		list.add(p);
	    }
	    con.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
	return list;
    }
    
    //for pagination
    public static int getNumberPage() {
	String query = "select count (*) from Products";
	try {
	    Connection con = new DBContext().getConnection();
	    PreparedStatement ps = con.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		int total = rs.getInt(1);
		int countPage = 0;
		countPage = total / 6;
		if (total % 6 != 0) {
		    countPage++;
		}
		return countPage;
	    }
	    con.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
	return 0;
    }
    
  //for pagination in search.jsp
    public static int getNumberPage(String searchString) {
	String query = "select count(*) from Products where product_name like ?";
	try {
	    Connection con = new DBContext().getConnection();
	    PreparedStatement ps = con.prepareStatement(query);
	    ps.setString(1, "%" + searchString + "%");
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		int total = rs.getInt(1);
		int countPage = 0;
		countPage = total/6;
		if (total%6 != 0) {
		    countPage ++;
		}
		return countPage;
	    }
	    con.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
	
	return 0;
    }
}
