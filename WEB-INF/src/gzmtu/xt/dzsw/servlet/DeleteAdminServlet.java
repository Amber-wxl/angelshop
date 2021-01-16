package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Admin;
import gzmtu.xt.dzsw.dao.IAdminDao;
import gzmtu.xt.dzsw.dao.impl.AdminDaoImpl;
import gzmtu.xt.dzsw.utils.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/deleteAdmin.do")

public class DeleteAdminServlet extends HttpServlet{    
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
      request.setCharacterEncoding("utf-8");
	  String account=request.getParameter("adminID");
	  Admin admin=new Admin();
	  IAdminDao dao=new AdminDaoImpl();
	  boolean result=dao.deleteAdmin(account);		  
	  response.sendRedirect(request.getHeader("Referer"));
   } 
 }
