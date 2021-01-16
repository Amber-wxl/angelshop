package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Admin;
import gzmtu.xt.dzsw.dao.IAdminDao;
import gzmtu.xt.dzsw.dao.impl.AdminDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/manageUserList.do")

public class ManageUserListServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{	  
	  request.setCharacterEncoding("utf-8");
	  IAdminDao dao=new AdminDaoImpl();//创建dao对象
	  List<Admin> adminlist=dao.getAdmin();	//调用getAdmin() 方法
	  request.setAttribute("adminlist",adminlist);
	  getServletContext().getRequestDispatcher("/jsp/manageUserList.jsp").forward(request,response);
	}   
}
