package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Order;
import gzmtu.xt.dzsw.dao.IOrderDao;
import gzmtu.xt.dzsw.dao.impl.OrderDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
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
	  IOrderDao dao=new OrderDaoImpl();
	  List<Order> orderlist=dao.getOrdersByAccount(account);	      
	  request.setAttribute("orderlist",orderlist);
	  getServletContext().getRequestDispatcher("/jsp/listOrder.jsp").forward(request,response);
	}   
 }
