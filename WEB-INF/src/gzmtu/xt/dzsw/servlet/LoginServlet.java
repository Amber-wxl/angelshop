package gzmtu.xt.dzsw.servlet;
import  gzmtu.xt.dzsw.entity.Customer;
import  gzmtu.xt.dzsw.dao.ICustomerDao;
import  gzmtu.xt.dzsw.dao.impl.CustomerDaoImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)  throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");
	    String returnUrl=request.getParameter("returnUrl");  //获取前端name="returnUrl"标签的value值
	    String account=request.getParameter("account");  //获取前端name="account"标签的value值
	    String pwd=request.getParameter("pwd");  //获取前端name="pwd"标签的value值  
        ICustomerDao dao=new CustomerDaoImpl();  //创建dao对象
	    boolean result=dao.login(account,pwd);  //调用login(account,pwd)方法
	    if(result==false){ returnUrl=request.getHeader("Referrer"); }//如果返回的result值是false色登录失败，则returnUrl等于当前页面的url
	    else{	//登录成功，则创建cookie
	        Cookie accountCookie=new Cookie("account",account);	
		    accountCookie.setPath("/angelshop");
		    accountCookie.setMaxAge(-1);			 
			Cookie pwdCookie=new Cookie("pwd",pwd); 
	        pwdCookie.setPath("/angelshop"); 
            pwdCookie.setMaxAge(-1);
            response.addCookie(accountCookie);	      
            response.addCookie(pwdCookie);	   
        }
	    response.sendRedirect(returnUrl);	//服务器响应对象发送到returnUrl
    }
}
