package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Order;
import gzmtu.xt.dzsw.dao.IOrderDao;
import gzmtu.xt.dzsw.dao.impl.OrderDaoImpl;
import gzmtu.xt.dzsw.utils.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/deleteOrder.do")

public class DeleteOrderServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
	    String orderID=request.getParameter("orderID");
	    IOrderDao dao=new OrderDaoImpl();//创建dao对象
	    boolean result=dao.deleteOrder(orderID);	//调用deleteOrder(orderID)方法	  
		response.sendRedirect(request.getHeader("Referer"));
    } 
}
