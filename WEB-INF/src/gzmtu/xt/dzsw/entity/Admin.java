//admin表对应的javabean
package gzmtu.xt.dzsw.entity;
public class Admin{
    private String adminID;//管理员账号
    private String pwd;//密码
    public Admin(){}//无参构造方法	
    public String getAdminID() {return adminID;}
    public void setAdminID(String adminID) {this.adminID=adminID;}
    public String getPwd() {return pwd;}
    public void setPwd(String pwd) {this.pwd=pwd;}   
}
