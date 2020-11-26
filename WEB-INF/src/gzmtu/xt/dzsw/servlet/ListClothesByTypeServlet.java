package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.dao.impl.ClothesDaoImpl;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/listClothesByType.do")

public class ListClothesByTypeServlet extends HttpServlet{    
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	 request.setCharacterEncoding("utf-8");	
	 String type=request.getParameter("type");
	 IClothesDao dao=new ClothesDaoImpl();	
	 int rows=dao.getRowsByType(type);
	 if(rows!=0){
	   String pageArg=request.getParameter("page");
       int page=pageArg==null?1:Integer.parseInt(pageArg);
	   int pageSize=8;	    
	   List<Clothes> clothesList=dao.getClothesByType(type,pageSize,page);
	   request.setAttribute("type",type);
	   request.setAttribute("pageSize",pageSize);
	   request.setAttribute("page",page);
	   request.setAttribute("clothesList",clothesList);
	 }
	 request.setAttribute("rows",rows);	  	  
     getServletContext().getRequestDispatcher("/jsp/listClothesByType.jsp").forward(request,response);
   } 
 }