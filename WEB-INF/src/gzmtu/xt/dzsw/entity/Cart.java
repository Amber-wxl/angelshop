//cart表对应的javabean
package gzmtu.xt.dzsw.entity;
import java.time.LocalDateTime;
public class Cart{
    private int cartID;
    private int clotheID;   
    private String account;
	private int quantity;	
	private LocalDateTime createTime;  
	private LocalDateTime updateTime; 
    private Clothes clothe;
	public Cart(){}	
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
    public Clothes getClothe(){return clothe;}
    public void  setClothe(Clothes clothe){this.clothe=clothe;}
  }
