package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Customer;
import gzmtu.xt.dzsw.dao.ICustomerDao;
import gzmtu.xt.dzsw.dao.impl.CustomerDaoImpl;
import gzmtu.xt.dzsw.utils.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/deleteCustomer.do")

public class DeleteCustomerServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
	    String account=request.getParameter("account");
	    ICustomerDao dao=new CustomerDaoImpl();//创建dao对象
	    boolean result=dao.deleteCustomer(account);//调用deleteCustomer(account)	  
		response.sendRedirect(request.getHeader("Referer"));
    } 
}
