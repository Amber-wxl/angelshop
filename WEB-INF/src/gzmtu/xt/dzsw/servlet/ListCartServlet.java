package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Cart;
import gzmtu.xt.dzsw.dao.ICartDao;
import gzmtu.xt.dzsw.dao.impl.CartDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/listCart.do")

public class ListCartServlet extends HttpServlet{    
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	   request.setCharacterEncoding("utf-8");	
	   String account=CookieUtil.getAccount(request);
	   ICartDao dao=new CartDaoImpl();	    
	   List<Cart> cartList=dao.getCartsByAccount(account);
	   request.setAttribute("cartList",cartList);
      getServletContext().getRequestDispatcher("/jsp/listCart.jsp").forward(request,response);
   } 
 }