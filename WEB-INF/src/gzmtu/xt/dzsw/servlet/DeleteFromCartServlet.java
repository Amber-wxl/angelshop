package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Cart;
import gzmtu.xt.dzsw.dao.ICartDao;
import gzmtu.xt.dzsw.dao.impl.CartDaoImpl;
import gzmtu.xt.dzsw.utils.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/deleteFromCart.do")

public class DeleteFromCartServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml");
        String account=CookieUtil.getAccount(request);
	    int clotheID=Integer.parseInt(request.getParameter("clotheID"));
	    Cart cart=new Cart();
	    cart.setAccount(account);
	    cart.setClotheID(clotheID);
	    ICartDao dao=new CartDaoImpl();//创建dao对象
	    boolean result=dao.deleteFromCart(cart);//调用deleteFromCart(cart)方法		  
	    String responseText=result?"success":"failure";	  
        PrintWriter out=response.getWriter();
	    out.print(responseText);
	    out.close();
    } 
}
