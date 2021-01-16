//cart表对应的javabean
package gzmtu.xt.dzsw.entity;
import java.time.LocalDateTime;
public class Cart{
    private int cartID;//购物车ID
    private int clotheID;  //产品ID 
    private String account;//用户ID
	private int quantity;	//数量
	private LocalDateTime createTime; //创建时间 
	private LocalDateTime updateTime; //更新时间
    private Clothes clothe;//外键依赖
    public Cart(){}	//无参构造方法
    // 为每个属性都设计set、get方法
	public int getCartID(){return cartID;}
	public void setCartID(int cartID){this.cartID=cartID;}
    public int getClotheID() {return clotheID;}
    public void setClotheID(int clotheID) {this.clotheID=clotheID;}
    public String getAccount(){return account;}
	public void setAccount(String account){this.account=account;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity=quantity;}
    public LocalDateTime getCreateTime() {return createTime;}
	public void setCreateTime(LocalDateTime createTime) {this.createTime=createTime;}
    public LocalDateTime getUpdateTime() {return updateTime;}
	public void setUpdateTime(LocalDateTime updateTime) {this.updateTime=updateTime;}
    // cart表里应包含clothes对象，方便获取到clothes对象的相关属性
    public Clothes getClothe(){return clothe;}
    public void  setClothe(Clothes clothe){this.clothe=clothe;}
}
