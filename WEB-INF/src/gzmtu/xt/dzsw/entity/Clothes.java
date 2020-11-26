package gzmtu.xt.dzsw.entity;
public class Clothes{
    private int clotheID;
    private String clotheName;
    private String origin;
    private String style;
    private String color;
    private String deliveryTime;   
    private double price;
    private double discount;
    private String cover;
    private String type;
    private String content;

    public Clothes(){ }
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
	public double getSitePrice() {return Double.parseDouble(String.format("%.2f",price*discount));}
	public String getSimplifyName(){return clotheName.length()<=27?clotheName:clotheName.substring(0,27)+"...";}	
}
