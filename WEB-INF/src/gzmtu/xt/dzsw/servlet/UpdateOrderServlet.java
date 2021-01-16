//实现加入购物车功能的servlet
package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Order;
import gzmtu.xt.dzsw.dao.IOrderDao;
import gzmtu.xt.dzsw.dao.impl.OrderDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.time.LocalDateTime;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
@WebServlet(urlPatterns="/updateOrder.do")

public class UpdateOrderServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
        String returnUrl=request.getParameter("returnUrl");
        String orderID=request.getParameter("orderID");
        String paymentWay=request.getParameter("paymentWay");
        String deliverWay=request.getParameter("deliverWay");
        String orderState=request.getParameter("orderState");
        Order order=new Order();
        order.setOrderID(orderID);
        order.setPaymentWay(paymentWay);
        order.setDeliverWay(deliverWay);
        order.setOrderState(orderState);
        IOrderDao dao=new OrderDaoImpl();//创建dao对象
        boolean result=dao.updateOrder(order);//调用updateOrder(order)方法
        request.setAttribute("result",result);
        response.sendRedirect(returnUrl);   
    } 
}
