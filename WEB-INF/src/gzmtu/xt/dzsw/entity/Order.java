package gzmtu.xt.dzsw.entity;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.entity.Suborder;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Order{
    private String orderID;
    private String account;      
	private double total;
	private String paymentWay;
	private String deliverWay;	
	private LocalDateTime orderTime;
	private String orderState;	
	private Customer customer;
    private ArrayList<Suborder> suborderList;
    
    public Order(){}	

    public String getOrderID() {return orderID;}
    public void setOrderID(String orderID){this.orderID=orderID;}
    
    public String getAccount() {return account;}
    public void setAccount(String account) {this.account=account;}  
      
    public double getTotal() {return total;}
	public void setTotal(double total) {this.total=total;}
    
    public String getPaymentWay() {return paymentWay;}
	public void setPaymentWay(String paymentWay) {this.paymentWay=paymentWay;}
    
    public String getDeliverWay() {return deliverWay;}
	public void setDeliverWay(String deliverWay) {this.deliverWay=deliverWay;}	
    
    public LocalDateTime getOrderTime() {return orderTime;}
	public void setOrderTime(LocalDateTime orderTime) {this.orderTime=orderTime;}	
    
    public String getOrderState() {return orderState;}
	public void setOrderState(String orderState) {this.orderState=orderState;}
    
    public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer=customer;}
    
    public ArrayList<Suborder> getSuborderList() {return suborderList;}
	public void setSuborderList(ArrayList<Suborder> suborderList)	{this.suborderList=suborderList;}	
}