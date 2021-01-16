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
@WebServlet(urlPatterns="/manageOrderList.do")
public class ManageOrderListServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{	  
	    request.setCharacterEncoding("utf-8");
        String account=CookieUtil.getAccount(request);
	    IOrderDao dao=new OrderDaoImpl();//创建dao对象
	    List<Order> orderlist=dao.getOrder();//调用 getOrder()方法  
	    request.setAttribute("orderlist",orderlist);
	    getServletContext().getRequestDispatcher("/jsp/manageOrderList.jsp").forward(request,response);
	}   
}
