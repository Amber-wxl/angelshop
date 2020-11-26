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
	  String returnUrl=request.getParameter("returnUrl");
	  String account=request.getParameter("account");
	  String pwd=request.getParameter("pwd");
	  String phone=request.getParameter("phone");
	  String address=request.getParameter("address");
	  Customer customer=new Customer();
	  customer.setAccount(account);
	  customer.setPwd(pwd);
	  customer.setPhone(phone);
      customer.setAddress(address);	
	  ICustomerDao dao=new CustomerDaoImpl();
	  boolean result=dao.register(customer);	  
	  if(result==false){			  
			  /*request.setAttribute("returnUrl",returnUrl);			 
			  getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);*/
			  returnUrl=request.getHeader("Referer");
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
