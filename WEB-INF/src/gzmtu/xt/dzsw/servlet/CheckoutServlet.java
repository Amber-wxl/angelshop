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
@WebServlet(urlPatterns="/checkout.do")

public class CheckoutServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");	
	    String account=CookieUtil.getAccount(request);
	    String[] clotheIDs=request.getParameterValues("clotheID");//将clotheID作为数组元素添加到clotheIDs数组里
	    ICartDao dao=new CartDaoImpl();	    //创建dao对象
	    List<Cart> cartList=dao.getCartsByAccountAndClotheIDs(account,clotheIDs);//调用getCartsByAccountAndClotheIDs(account,clotheIDs)方法
	    request.setAttribute("cartList",cartList);
        getServletContext().getRequestDispatcher("/jsp/checkout.jsp").forward(request,response);
    } 
}