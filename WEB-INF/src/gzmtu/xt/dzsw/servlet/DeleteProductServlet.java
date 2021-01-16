package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.dao.impl.ClothesDaoImpl;
import gzmtu.xt.dzsw.utils.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/deleteProduct.do")

public class DeleteProductServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
	    int clotheID=Integer.parseInt(request.getParameter("clotheID"));
	    IClothesDao dao=new ClothesDaoImpl();//创建dao对象
	    boolean result=dao.deleteClothes(clotheID);	//调用deleteClothes(clotheID)方法	  
		response.sendRedirect(request.getHeader("Referer"));
    } 
}
