//clothes表对应的javabean
package gzmtu.xt.dzsw.entity;
public class Clothes{
    private int clotheID;//产品ID
    private String clotheName;//产品标题
    private String origin;//发货地
    private String style;//风格
    private String color;//颜色
    private String deliveryTime;//发货时间   
    private double price;//价格
    private double discount;//折扣
    private String cover;//图片途径
    private String type;//类目
    private String content;//详情
	public Clothes(){}// 无参构造方法
	// 为每一个属性都写一对get、set方法
    public int getClotheID() {return clotheID;}
	public void setClotheID(int clotheID) {this.clotheID = clotheID;}
	public String getClotheName() {return clotheName;}
	public void setClotheName(String clotheName) {this.clotheName = clotheName;}	
	public String getOrigin() {return origin;}
	public void setOrigin(String origin) {this.origin = origin;}	
	public String getStyle() {return  style;}
	public void setStyle(String style){this.style=style;}	
	public String getColor() {return  color;}
	public void setColor(String color){this.color=color;}	
	public String getDeliveryTime() {return deliveryTime;}  
	public void setDeliveryTime(String deliveryTime ) {this.deliveryTime = deliveryTime;}	
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public double getDiscount() {return discount;}
    public void setDiscount(double discount){this.discount=discount;}
	public String getCover() {return cover;}
	public void setCover(String cover) {this.cover = cover;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}  
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	//SitePrice、SimplifyName是在原有的属性上进行一些计算得出的属性
	public double getSitePrice() {return Double.parseDouble(String.format("%.2f",price*discount));}
	// 这个属性是防止标题太长在产品列表页展示的效果不好，所以在此将标题第27个字符之后的字符用……代替
	public String getSimplifyName(){return clotheName.length()<=27?clotheName:clotheName.substring(0,27)+"...";}	
}
