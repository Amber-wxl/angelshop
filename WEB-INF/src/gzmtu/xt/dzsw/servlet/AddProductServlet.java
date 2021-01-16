//实现加入购物车功能的servlet
package gzmtu.xt.dzsw.servlet;
import gzmtu.xt.dzsw.entity.Clothes;
import gzmtu.xt.dzsw.dao.IClothesDao;
import gzmtu.xt.dzsw.dao.impl.ClothesDaoImpl;
import gzmtu.xt.dzsw.utils.CookieUtil;
import java.time.LocalDateTime;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
@WebServlet(urlPatterns="/addProduct.do")
@MultipartConfig(location="d:\\angelshop\\images",maxFileSize=8*1024*1024)

public class AddProductServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
        String returnUrl=request.getParameter("returnUrl");
        String clotheName=request.getParameter("clotheName");
        String origin=request.getParameter("origin");
        String style=request.getParameter("style");
        String color=request.getParameter("color");
        String deliveryTime=request.getParameter("deliveryTime");
        double price=Double.parseDouble(request.getParameter("price"));
        double discount=Double.parseDouble(request.getParameter("discount"));
        Part part = request.getPart("cover"); //获取文件对象
        String fileName=part.getSubmittedFileName();//获取文件名
        String cover="images/"+fileName;//拼接字符串作为cover属性值
        part.write(fileName); //将上传的文件内容写入指定的磁盘位置 
        String type=request.getParameter("type");
        String content=request.getParameter("content");
        Clothes clothe=new Clothes();
        clothe.setClotheName(clotheName);
        clothe.setOrigin(origin);
        clothe.setStyle(style);
        clothe.setColor(color);
        clothe.setDeliveryTime(deliveryTime);
        clothe.setPrice(price);
        clothe.setDiscount(discount);
        clothe.setCover(cover);
        clothe.setType(type);
        clothe.setContent(content);
        IClothesDao dao=new ClothesDaoImpl();//创建dao对象
        boolean result=dao.addClothes(clothe);//调用addClothes(clothe)方法
        request.setAttribute("result",result);
        response.sendRedirect(returnUrl); 
    } 
}
