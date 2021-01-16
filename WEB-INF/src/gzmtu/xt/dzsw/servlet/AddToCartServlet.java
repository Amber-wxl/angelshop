//实现加入购物车功能的servlet
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
@WebServlet(urlPatterns="/addToCart.do")

public class AddToCartServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");
	    String account=CookieUtil.getAccount(request);//获取用户ID
	    int clotheID=Integer.parseInt(request.getParameter("clotheID"));//需要加入的产品clotheID
	    String clotheName=request.getParameter("clotheName");//需要加入的产品clotheName
	    LocalDateTime time=LocalDateTime.now();
	    Cart cart=new Cart();//创建cart对象，将获取到数据赋值给cart对象相应的属性
	    cart.setAccount(account);
	    cart.setClotheID(clotheID);
	    cart.setCreateTime(time);
	    cart.setUpdateTime(time);
	    ICartDao dao=new CartDaoImpl();//创建dao对象
	    boolean result=dao.addToCart(cart);	//调用addToCart(cart)方法
	    request.setAttribute("result",result);
	    if(result){
		    request.setAttribute("clotheID",clotheID);
		    request.setAttribute("clotheName",clotheName);
	    }
        getServletContext().getRequestDispatcher("/jsp/afterAddToCart.jsp").forward(request,response);
   } 
}
