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
@WebServlet(urlPatterns="/updateProduct.do")
@MultipartConfig(location="d:\\angelshop\\images",maxFileSize=8*1024*1024)

public class UpdateProductServlet extends HttpServlet{    
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,java.io.IOException{
        request.setCharacterEncoding("utf-8");
        String returnUrl=request.getParameter("returnUrl");
        int clotheID=Integer.parseInt(request.getParameter("clotheID"));
        String clotheName=request.getParameter("clotheName");
        String origin=request.getParameter("origin");
        String style=request.getParameter("style");
        String color=request.getParameter("color");
        String deliveryTime=request.getParameter("deliveryTime");
        double price=Double.parseDouble(request.getParameter("price"));
        double discount=Double.parseDouble(request.getParameter("discount"));
        Part part = request.getPart("cover"); //获取文件对象
        String fileName=part.getSubmittedFileName();
        String cover=fileName;
        if(fileName==null||part.getSize()==0){//如果文件名为空或者文件大小为0，则没有上传文件
            IClothesDao d=new ClothesDaoImpl();
            Clothes c=d.getClothesByID(clotheID);
            cover=c.getCover();//将原来的cover值赋值给cover变量
        }else{
            part.write(fileName);
            cover="images/"+fileName;
        }
        String type=request.getParameter("type");
        String content=request.getParameter("content");
        Clothes clothe=new Clothes();
        clothe.setClotheID(clotheID);
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
        boolean result=dao.updateclothes(clothe);//调用updateclothes(clothe)方法
        request.setAttribute("result",result);
        response.sendRedirect(returnUrl);     
    } 
}
