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
	    IClothesDao dao=new ClothesDaoImpl();	//创建dao对象
	    int rows=dao.getRowsByType(type);      //获取总记录数
	    if(rows!=0){//记录不为空
	        String pageArg=request.getParameter("page");//获取page值
            int page=pageArg==null?1:Integer.parseInt(pageArg);//page值为空则当前页面为第一页
	        int pageSize=8;	    //每页显示8条记录
	        List<Clothes> clothesList=dao.getClothesByType(type,pageSize,page);//执行getClothesByType(type,pageSize,page)方法
	        request.setAttribute("type",type);
	        request.setAttribute("pageSize",pageSize);
	        request.setAttribute("page",page);
	        request.setAttribute("clothesList",clothesList);
	    }
		request.setAttribute("rows",rows);	 
		//将结果请求转发到jsp   
        getServletContext().getRequestDispatcher("/jsp/listClothesByType.jsp").forward(request,response);
    } 
 }