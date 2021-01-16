package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.dao.ICustomerDao;
import gzmtu.xt.dzsw.dao.impl.CustomerDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/manageCustomerList.do")
public class ManageCustomerListServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{	  
	    request.setCharacterEncoding("utf-8");
	    ICustomerDao dao=new CustomerDaoImpl();//创建dao对象
	    List<Customer> customerlist=dao.getCustomer();//调用 getCustomer()方法   
	    request.setAttribute("customerlist",customerlist);
	    getServletContext().getRequestDispatcher("/jsp/manageCustomerList.jsp").forward(request,response);
	}   
 }
