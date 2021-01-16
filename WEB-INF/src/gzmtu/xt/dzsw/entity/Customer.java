//customer表对应的javabean
package gzmtu.xt.dzsw.entity;
public class Customer{
    private String account;//用户ID
    private String pwd;//密码
    private String phone;   //联系方式
    private String address;	//地址
    public Customer(){}	//无参构造方法
    public String getAccount() {return account;}
    public void setAccount(String account) {this.account=account;}  
    public String getPwd() {return pwd;}
    public void setPwd(String pwd) {this.pwd=pwd;}  
    public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone=phone;} 
    public String getAddress() {return address;}
	public void setAddress(String address) { this.address=address;}	
}
