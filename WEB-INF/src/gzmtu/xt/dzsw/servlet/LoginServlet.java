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
	  String returnUrl=request.getParameter("returnUrl");
	  String account=request.getParameter("account");
	  String pwd=request.getParameter("pwd");	  
      ICustomerDao dao=new CustomerDaoImpl();
	  boolean result=dao.login(account,pwd);	 	
	  if(result==false){		     
		   returnUrl=request.getHeader("Referrer");
	  }else{	
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
