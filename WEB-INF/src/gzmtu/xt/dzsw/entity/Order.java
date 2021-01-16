//orders表对应的javabean
package gzmtu.xt.dzsw.entity;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.entity.Suborder;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Order{
    private String orderID;//订单号
    private String account;//用户ID依赖于customer表
	private double total;//总金额
	private String paymentWay;//支付方式
	private String deliverWay;//发货方式
	private LocalDateTime orderTime;//下单时间
	private String orderState;//订单状态
	private Customer customer;//外键依赖
    private ArrayList<Suborder> suborderList;//子订单
    public Order(){}//无参构造方法
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