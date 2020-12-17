package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Cart;
import gzmtu.xt.dzsw.dao.ICartDao;
import gzmtu.xt.dzsw.dao.impl.CartDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.time.LocalDateTime;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/updateCart.do")

public class UpdateCartServlet extends HttpServlet{    
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	  request.setCharacterEncoding("utf-8");
	  response.setContentType("text/xml");
	  String account=CookieUtil.getAccount(request);	  
	  int clotheID=Integer.parseInt(request.getParameter("clotheID"));
	  int quantity=Integer.parseInt(request.getParameter("quantity"));
	  LocalDateTime updateTime=LocalDateTime.now();
	  Cart cart=new Cart();
	  cart.setAccount(account);
	  cart.setClotheID(clotheID);
	  cart.setQuantity(quantity);
	  cart.setUpdateTime(updateTime);
	  ICartDao dao=new CartDaoImpl();
	  boolean result=dao.updateCart(cart);		  
	  String responseText=result?"success":"failure";	  
      PrintWriter out=response.getWriter();
	  out.print(responseText);
	  out.close();
   } 
 }