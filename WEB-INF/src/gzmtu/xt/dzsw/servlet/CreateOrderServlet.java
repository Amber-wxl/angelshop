package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.dao.IOrderDao;
import gzmtu.xt.dzsw.dao.impl.OrderDaoImpl;
import gzmtu.xt.dzsw.entity.Order;
import gzmtu.xt.dzsw.entity.Suborder;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.util.Random;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/createOrder.do")
public class CreateOrderServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{	  
	    request.setCharacterEncoding("utf-8");
	    String account=CookieUtil.getAccount(request);  
	    String deliverWay=request.getParameter("deliverWay");
	    String paymentWay=request.getParameter("paymentWay");
	    double total=Double.parseDouble(request.getParameter("total"));	
        LocalDateTime now = LocalDateTime.now(); 	
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddhhmmss");
        Random rd=new Random(System.currentTimeMillis());
	    int num=100+rd.nextInt(900);
	    String orderID= dtf.format(now)+String.valueOf(num); 	 
        Order order=new Order();
	    order.setOrderID(orderID);
	    order.setAccount(account);     
	    order.setTotal(total);
	    order.setPaymentWay(paymentWay);
	    order.setDeliverWay(deliverWay);      
        order.setOrderTime(now);     
	    ArrayList<Suborder> suborderList=new ArrayList<Suborder>();
	    Suborder suborder;
	    String[] clotheIDAndCounts=request.getParameterValues("clotheIDAndCount");
	    String[] strTemps;
	    for(String clotheIDAndCount:clotheIDAndCounts){
		    strTemps=clotheIDAndCount.split(":");
		    suborder=new Suborder();
		    suborder.setClotheID(Integer.parseInt(strTemps[0]));
		    suborder.setCount(Integer.parseInt(strTemps[1]));
		    suborder.setOrderID(orderID);
            suborderList.add(suborder);		
	    }
	    order.setSuborderList(suborderList);
	    IOrderDao dao=new OrderDaoImpl();
	    boolean result=dao.createOrder(order);
	    if(result){	
	        request.setAttribute("orderID",orderID);       
	    }
	    getServletContext().getRequestDispatcher("/jsp/createOrder.jsp").forward(request,response);
  }   
}