package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.dao.IOrderDao;
import gzmtu.xt.dzsw.dao.impl.OrderDaoImpl;
import gzmtu.xt.dzsw.entity.Order;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/getOrderById.do")

public class GetOrderByOrderIDServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{	  
	    request.setCharacterEncoding("utf-8");
	    String orderID=request.getParameter("orderID");
	    IOrderDao dao=new OrderDaoImpl();//创建dao对象
	    Order order=dao.getOrderByOrderID(orderID);//调用getOrderByOrderID(orderID)方法
	    request.setAttribute("order",order);
	    getServletContext().getRequestDispatcher("/jsp/getOrder.jsp").forward(request,response);
	}   
}