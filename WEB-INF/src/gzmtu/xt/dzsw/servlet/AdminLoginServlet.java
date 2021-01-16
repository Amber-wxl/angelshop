package gzmtu.xt.dzsw.servlet;
import  gzmtu.xt.dzsw.entity.Admin;
import  gzmtu.xt.dzsw.dao.IAdminDao;
import  gzmtu.xt.dzsw.dao.impl.AdminDaoImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/adminLogin.do")

public class AdminLoginServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");
	    String adminID=request.getParameter("adminID");
	    String pwd=request.getParameter("pwd");	  
        IAdminDao dao=new AdminDaoImpl();
	    boolean result=dao.login(adminID,pwd);	 	
	    if(result==true){		     	
	        Cookie adminIDCookie=new Cookie("adminID",adminID);	
			adminIDCookie.setPath("/angelshop");
			adminIDCookie.setMaxAge(-1);			 
			Cookie adminpwdCookie=new Cookie("adminpwd",pwd); 
	        adminpwdCookie.setPath("/angelshop"); 
            adminpwdCookie.setMaxAge(-1);
            response.addCookie(adminIDCookie);	      
			response.addCookie(adminpwdCookie);	 
			response.sendRedirect("/angelshop/manageProductList.do");  
        }else{
			PrintWriter out=response.getWriter();
			out.write("<p>登陆失败，请联系管理员</p>");
		}
	}
        
}
