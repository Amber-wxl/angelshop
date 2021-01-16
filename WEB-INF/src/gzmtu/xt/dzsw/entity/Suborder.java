//suborders表对应的javabean
package  gzmtu.xt.dzsw.entity;
import  gzmtu.xt.dzsw.entity.Clothes;
public class Suborder{
    private int suborderID;//子订单ID
    private int clotheID;//产品ID
    private int count;  //数量	
	private String orderID;//关联订单ID
    private Clothes clothe;//外键依赖
    public Suborder(){}	//无参构造方法
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