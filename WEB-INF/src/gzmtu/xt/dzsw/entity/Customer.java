package gzmtu.xt.dzsw.entity;
public class Customer{
    private String account;
    private String pwd;
    private String phone;   
    private String address;	
    public Customer(){}	
    public String getAccount() {return account;}
    public void setAccount(String account) {
        this.account=account;
    }
    public String getPwd() {return pwd;}
    public void setPwd(String pwd) {
        this.pwd=pwd;
    }
    public String getPhone() {return phone;}
	public void setPhone(String phone) {
        this.phone=phone;
    }
	public String getAddress() {return address;}
	public void setAddress(String address) {
        this.address=address;
    }	
}
