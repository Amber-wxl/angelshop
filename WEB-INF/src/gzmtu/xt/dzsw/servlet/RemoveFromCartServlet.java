package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Cart;
import gzmtu.xt.dzsw.dao.ICartDao;
import gzmtu.xt.dzsw.dao.impl.CartDaoImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/removeFromCart.do")

public class RemoveFromCartServlet extends HttpServlet{    
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
      request.setCharacterEncoding("utf-8");
      int clotheID=Integer.parseInt(request.getParameter("clotheID"));
	  ICartDao dao=new CartDaoImpl();
	  boolean result=dao.removeFromCart(clotheID);	
      response.sendRedirect("listCart.do");
   } 
 }