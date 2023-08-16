package model;

import java.util.Date;
import java.util.List;

public class Orders {
    private int orderId;
    private float price; //Total amount of order
    private int status;
    private Date orderDate;
    private String address; //buyer's address;
    private String phoneNumber;
    private List<ProductOrders> lp;
    private String userMail;// buyer's email
    private Date receiveDate;
    private String discount;
    
    public Orders() {
	
    }
    
    public Orders(int orderId, float price, int status, Date orderDate, String address, String phoneNumber, List<ProductOrders> lp, String userMail, Date receiveDate) {
	this.orderId = orderId;
	this.price = price;
	this.status = status;
	this.orderDate = orderDate;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.lp = lp;
	this.userMail = userMail;
	this.receiveDate = receiveDate;
    }
    
    public Orders(String userMail, int status,  String discount, String address,String phoneNumber, Date receiveDate) {
	this.userMail = userMail;
	this.status = status;
	this.discount = discount;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.receiveDate = receiveDate;
    }
    
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<ProductOrders> getLp() {
        return lp;
    }
    public void setLp(List<ProductOrders> lp) {
        this.lp = lp;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public Date getReceiveDate() {
        return receiveDate;
    }
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }
    public String getDiscount() {
        return discount;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    
}
