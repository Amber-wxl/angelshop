package gzmtu.xt.dzsw.servlet;
import  gzmtu.xt.dzsw.entity.Admin;
import  gzmtu.xt.dzsw.dao.IAdminDao;
import  gzmtu.xt.dzsw.dao.impl.AdminDaoImpl;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/adminRegister.do")

public class AdminRegisterServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)  throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");	  
	    String adminID=request.getParameter("adminID");
	    String pwd=request.getParameter("pwd");
	    Admin admin=new Admin();
	    admin.setAdminID(adminID);
	    admin.setPwd(pwd);
	    IAdminDao dao=new AdminDaoImpl();//创建dao对象
        boolean result=dao.register(admin);//调用register(admin)方法
        if(result){
            response.sendRedirect("/angelshop/manageUserList.do"); 
        }else{
            System.out.println("注册失败");
        }
    }
}
