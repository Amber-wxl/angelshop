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
	    String account=CookieUtil.getAccount(request);  //获取用户ID
	    String deliverWay=request.getParameter("deliverWay");//获取发货方式
	    String paymentWay=request.getParameter("paymentWay");//获取支付方式
	    double total=Double.parseDouble(request.getParameter("total"));	//获取总金额
        LocalDateTime now = LocalDateTime.now(); 	//时间为当前时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddhhmmss");//将获取到时间进行格式化
        Random rd=new Random(System.currentTimeMillis());
	    int num=100+rd.nextInt(900);
	    String orderID= dtf.format(now)+String.valueOf(num); 	 
        Order order=new Order();//创建Order对象
	    order.setOrderID(orderID);
	    order.setAccount(account);     
	    order.setTotal(total);
	    order.setPaymentWay(paymentWay);
	    order.setDeliverWay(deliverWay);      
        order.setOrderTime(now);     
	    ArrayList<Suborder> suborderList=new ArrayList<Suborder>();//创建对象数组
	    Suborder suborder;
	    String[] clotheIDAndCounts=request.getParameterValues("clotheIDAndCount");
	    String[] strTemps;
	    for(String clotheIDAndCount:clotheIDAndCounts){//遍历clotheIDAndCounts
		    strTemps=clotheIDAndCount.split(":");//以冒号分割字符串
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