package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.dao.impl.ClothesDaoImpl;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/manageProductList.do")

public class ManageProductListServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
	    request.setCharacterEncoding("utf-8");	
	    IClothesDao dao=new ClothesDaoImpl();	//创建dao对象
	    int rows=dao.getRowsAll();
	    if(rows!=0){
		    String pageArg=request.getParameter("page");
		    int page=pageArg==null?1:Integer.parseInt(pageArg);
		    int pageSize=10;	    //每页显示10行
		    List<Clothes> clothesList=dao.getClothesAll(pageSize,page);
		    request.setAttribute("pageSize",pageSize);
		    request.setAttribute("page",page);
		    request.setAttribute("clothesList",clothesList);
	    }
	    request.setAttribute("rows",rows);	  
	    getServletContext().getRequestDispatcher("/jsp/manageProductList.jsp").forward(request,response);
    } 
}
