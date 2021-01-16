package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.dao.impl.ClothesDaoImpl;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/productDetail.do")

public class ProductDetailServlet extends HttpServlet{    
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	  request.setCharacterEncoding("utf-8");
	  int clotheID=Integer.parseInt(request.getParameter("clotheID"));
	  IClothesDao dao=new ClothesDaoImpl();
	  Clothes clothes=dao.getClothesByID(clotheID);	
	  request.setAttribute("clothes",clothes);	 
      getServletContext().getRequestDispatcher("/jsp/updateProduct.jsp").forward(request,response);
   } 
 }