package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;

public class AccountDao {
    public AccountDao() {};
    
    public Account getAccount(String userName, String password) {
	String query = "SELECT * FROM Account WHERE user_mail = ? AND password = ?;";
	Account acc = new Account();
	try {
	    Connection conn = new DBContext().getConnection();
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setString(1, userName);
	    ps.setString(2, password);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		acc.setUsr(rs.getString(1));
		acc.setPwd(rs.getString(2));
		acc.setRote(rs.getInt(3));
		acc.setName(rs.getString(4));
		acc.setAddress(rs.getString(5));
		acc.setPhone(rs.getString(6));
	    }
	    conn.close();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return acc;
    }
    
    public void insertAccount(String userMail, String password, String name, String address, String phone) {
	String insertSql = "INSERT INTO Account\r\n"
		+ "(user_mail, password, account_role, user_name, user_address, user_phone)\r\n"
		+ "VALUES(?, ?, ?, ?, ?, ?)"; 
	try {
	    Connection conn = new DBContext().getConnection();
	    PreparedStatement ps = conn.prepareStatement(insertSql);
	    ps.setString(1, userMail);
	    ps.setString(2, password);
	    ps.setInt(3, 0);
	    ps.setString(4, name);
	    ps.setString(5, address);
	    ps.setString(6, phone);
	    ps.executeUpdate();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    public boolean checkExitMail(String userMail) {
	List<Account> listAcc = listAccount(0);
	    for (Account acc : listAcc) {
		if (acc.getUsr().equals(userMail)) {
		    return true;
		}
	    }
	return false;
    }
    
    public List<Account> listAccount(int role) {
	String queryAcc = "SELECT * FROM Account";
	String queryStaff = "SELECT * FROM Account WHERE account_role = ?"; 
	List<Account> listAcc = new ArrayList<>();
	try {
	    Connection conn = new DBContext().getConnection();
	    PreparedStatement ps;
	    if (role == 1) {
		ps = conn.prepareStatement(queryStaff);
		ps.setInt(1, role);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		    Account acc = new Account();
		    acc.setUsr(rs.getString(1));
		    acc.setPwd(rs.getString(2));
		    acc.setRote(rs.getInt(3));
		    acc.setName(rs.getString(4));
		    acc.setAddress(rs.getString(5));
		    acc.setPhone(rs.getString(6));
		    listAcc.add(acc);
		}
	    }else {
		ps = conn.prepareStatement(queryAcc);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		    Account acc = new Account();
		    acc.setUsr(rs.getString(1));
		    acc.setPwd(rs.getString(2));
		    acc.setRote(rs.getInt(3));
		    acc.setName(rs.getString(4));
		    acc.setAddress(rs.getString(5));
		    acc.setPhone(rs.getString(6));
		    listAcc.add(acc);
		}
		
	    }
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return listAcc;
    }

}
