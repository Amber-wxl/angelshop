package gzmtu.xt.dzsw.servlet;
import  gzmtu.xt.dzsw.utils.CookieUtil;
import  gzmtu.xt.dzsw.dao.IOrderDao;
import  gzmtu.xt.dzsw.dao.impl.OrderDaoImpl;
import  gzmtu.xt.dzsw.entity.Order;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/listOrder.do")
public class ListOrderServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{	  
	    request.setCharacterEncoding("utf-8");
	    String account=CookieUtil.getAccount(request);
	    IOrderDao dao=new OrderDaoImpl();//创建dao对象
	    List<Order> orderList=dao.getOrdersByAccount(account);//调用getOrdersByAccount(account)
	    request.setAttribute("orderList",orderList);	 
        getServletContext().getRequestDispatcher("/jsp/listOrder.jsp").forward(request,response);	 
    }  
}