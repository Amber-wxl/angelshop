package gzmtu.xt.dzsw.servlet;
import  gzmtu.xt.dzsw.entity.Customer;
import  gzmtu.xt.dzsw.dao.ICustomerDao;
import  gzmtu.xt.dzsw.dao.impl.CustomerDaoImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/register.do")
public class RegisterServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)  throws ServletException,java.io.IOException{
		request.setCharacterEncoding("utf-8");	  
		// 获取用户输入的数据
	    String returnUrl=request.getParameter("returnUrl");
	    String account=request.getParameter("account");
	    String pwd=request.getParameter("pwd");
	    String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		// 创建一个空的customer对象，将获取到数据赋值到相应的属性
	    Customer customer=new Customer();
	    customer.setAccount(account);
	    customer.setPwd(pwd);
	    customer.setPhone(phone);
        customer.setAddress(address);	
	    ICustomerDao dao=new CustomerDaoImpl();//创建dao对象
	    boolean result=dao.register(customer);//调用register(customer)方法
	    if(result==false){ returnUrl=request.getHeader("Referer"); }//注册失败，则返回url
	    else{	//注册成功则创建cookie
            Cookie accountCookie=new Cookie("account",account);
			accountCookie.setPath("/angelshop");
			accountCookie.setMaxAge(-1);			  
			Cookie pwdCookie=new Cookie("pwd",pwd);
	        pwdCookie.setPath("/angelshop"); 
            pwdCookie.setMaxAge(-1); 
			response.addCookie(accountCookie);
            response.addCookie(pwdCookie); 
	    }
	    response.sendRedirect(returnUrl);
    }
}
