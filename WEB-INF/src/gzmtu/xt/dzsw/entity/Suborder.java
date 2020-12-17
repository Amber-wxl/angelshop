package  gzmtu.xt.dzsw.entity;
import  gzmtu.xt.dzsw.entity.Clothes;
public class Suborder{
    private int suborderID;
    private int clotheID;
    private int count;  	
	private String orderID;
    private Clothes clothe;

    public Suborder(){}	

    public int getSuborderID() {return suborderID;}
    public void setSuborderID(int suborderID) {this.suborderID=suborderID;}
    
    public int getClotheID() {return clotheID;}
    public void setClotheID(int clotheID) {this.clotheID=clotheID;}
    
    public int getCount() {return count;}
	public void setCount(int count) {this.count=count;}	
    
    public String getOrderID() {return orderID;}
	public void setOrderID(String orderID) {this.orderID=orderID;}	
    
    public Clothes getClothe() {return clothe;}
	public void setClothe(Clothes clothe) {this.clothe=clothe;}
}