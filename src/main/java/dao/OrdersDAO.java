package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
    public OrdersDAO() {

    }

    // insert information of order to data source, that including list of
    // products in cart (c) and information of buyer in Orders o
    public void insertOrder(Orders o, Cart c) throws Exception {
	String insertOrder = "INSERT INTO Orders\r\n"
		+ "(user_mail,order_status,order_discount_code,order_address)\r\n" 
		+ "VALUES\r\n"
		+ "(?,?,?,?)";
	String insertOrderDetail = "INSERT INTO Orders_detail VALUES(?,?,?,?)";
	try {
		Connection conn = new DBContext().getConnection();
		String columNames[] = new String[] {"order_id"};
		PreparedStatement psOrder = conn.prepareStatement(insertOrder, columNames);	
		psOrder.setString(1, o.getUserMail());
		psOrder.setInt(2, o.getStatus());
		psOrder.setString(3, o.getDiscount());
		psOrder.setString(4, o.getAddress());
	    
	    if (psOrder.executeUpdate() > 0) {
		ResultSet generatedKeys = psOrder.getGeneratedKeys();
		if(generatedKeys.next()) {
		    o.setOrderId(generatedKeys.getInt(1));
		}
	    }
	    
	    
	    PreparedStatement psOrderDetail = conn.prepareStatement(insertOrderDetail);
	    List<Product> list = c.getItems();
	    for (Product product : list) {
		psOrderDetail.setInt(1, o.getOrderId());
		psOrderDetail.setInt(2, product.getId());
		psOrderDetail.setInt(3, product.getNumber());
		psOrderDetail.setInt(4, Math.round(product.getPrice()));
		psOrderDetail.executeUpdate();
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }
}
