package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.dao.impl.ClothesDaoImpl;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/listClothes.do")

public class ListClothesServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");	
	    IClothesDao dao=new ClothesDaoImpl();	//创建dao对象
	    int rows=dao.getRowsAll();  //获取记录的总数
	    if(rows!=0){
		    String pageArg=request.getParameter("page");
		    int page=pageArg==null?1:Integer.parseInt(pageArg);
		    int pageSize=8;	    //每页显示8条记录
		    List<Clothes> clothesList=dao.getClothesAll(pageSize,page);
		    request.setAttribute("pageSize",pageSize);
		    request.setAttribute("page",page);
		    request.setAttribute("clothesList",clothesList);
	    }
		request.setAttribute("rows",rows);	  
		// 将结果请求转发给jsp
	    getServletContext().getRequestDispatcher("/jsp/listClothesAll.jsp").forward(request,response);
    } 
 }
