/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2021-01-09 04:18:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import gzmtu.xt.dzsw.entity.Cart;
import gzmtu.xt.dzsw.entity.Clothes;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("gzmtu.xt.dzsw.entity.Clothes");
    _jspx_imports_classes.add("gzmtu.xt.dzsw.entity.Cart");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <!--设置网页编码方式-->\r\n");
      out.write("    <link href=\"css/common.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/checkout.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--应用样式文件-->\r\n");
      out.write("    <script src=\"js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/aside.js\"></script>\r\n");
      out.write("    <script src=\"js/checkAccount.js\"></script>\r\n");
      out.write("    <!-- 通过js函数检查是否有cookie存在 -->\r\n");
      out.write("    <title>提交订单-ANGELSHOP</title>\r\n");
      out.write("    <!--设置网页标题-->\r\n");
      out.write("    <link rel=\"icon\" href=\"logo.png\">\r\n");
      out.write("    <!--设置网页小图标-->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <!--头部背景图由css样式控制-->\r\n");
      out.write("    <header>\r\n");
      out.write("    </header>\r\n");
      out.write("    <nav>\r\n");
      out.write("        <!--登录注册等操作选项-->\r\n");
      out.write("        <div class=\"action\">\r\n");
      out.write("            <span><a href=\"login.html\" target=\"_blank\">登录</a>|<a href=\"register.html\" target=\"_blank\">注册</a></span>|\r\n");
      out.write("            <a href=\"listClothes.do\">首页</a>|\r\n");
      out.write("            <a href=\"listCart.do\" target=\"_blank\">我的购物车</a>|\r\n");
      out.write("            <a href=\"listOrder.do\" target=\"_blank\">我的订单</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 搜索框提交表单 -->\r\n");
      out.write("        <div class=\"search\">\r\n");
      out.write("            <form action=\"searchClothes.do\" method=\"get\">\r\n");
      out.write("                <input type=\"search\" name=\"value\" size=\"30\" required>\r\n");
      out.write("                <button type=\"submit\" class=\"iconfont\">&#xe6bf;</button>\r\n");
      out.write("                <select name=\"category\">\r\n");
      out.write("                    <option value=\"clotheName\" selected>宝贝</option>\r\n");
      out.write("                    <option value=\"style\">风格</option>\r\n");
      out.write("                    <option value=\"color\">颜色</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("    <form action=\"createOrder.do\" method=\"get\">\r\n");
      out.write("\t        <label class=\"deliverWay\">送货方式</label><br>\r\n");
      out.write("\t        <input type=\"radio\" name=\"deliverWay\" value=\"普通快递\" checked><label>普通快递送货上门</label><br>\r\n");
      out.write("\t        <input type=\"radio\" name=\"deliverWay\" value=\"特快专递\"><label>特快专递（凭身份证签收，请实名下单）（不支持货到付款）</label><br><br>\r\n");
      out.write("\t        <label class=\"paymentWay\">支付方式</label><br>\r\n");
      out.write("\t        <input type=\"radio\" name=\"paymentWay\" value=\"网上支付\" checked><label>网上支付</label><br>\r\n");
      out.write("\t        <input type=\"radio\" name=\"paymentWay\" value=\"货到付款-现金\"><label>货到付款-现金</label><br>\r\n");
      out.write("\t        <input type=\"radio\" name=\"paymentWay\" value=\"货到付款-POS机刷卡\"><label>货到付款-POS机刷卡</label><br>\r\n");
      out.write("\t        <input type=\"radio\" name=\"paymentWay\" value=\"银行转帐\"><label>银行转帐</label><br><br>\t     \r\n");
      out.write("\t        \r\n");
      out.write("\t    ");
	
		 List<Cart> cartList=(ArrayList<Cart>)request.getAttribute("cartList");
	     int count=0;
	     double total=0;	   
		 int clotheID;
		 String cover;
		 String clotheName;
         double sitePrice;
		 int quantity;
		 double subtotal;
		 Clothes clothe;
		 for(Cart cart:cartList){
		     clotheID=cart.getClotheID();	
			 clothe=cart.getClothe();
			 clotheName=clothe.getClotheName();
			 cover=clothe.getCover();
			 sitePrice=clothe.getSitePrice();
			 quantity=cart.getQuantity();
			 String clotheIDAndCount=clotheID+":"+quantity;
             subtotal=Double.parseDouble(String.format("%.2f",sitePrice*quantity));
			 count=count+quantity;
			 total=Double.parseDouble(String.format("%.2f",total+subtotal));			 
	 
      out.write("\r\n");
      out.write("     <div class=\"order-submit\">\r\n");
      out.write("     <input  type=\"hidden\" name=\"clotheIDAndCount\" value=\"");
      out.print( clotheIDAndCount);
      out.write("\" >\r\n");
      out.write("     <span><a href=\"getClothesById.do?clotheID=");
      out.print(clotheID);
      out.write("\"><img src='");
      out.print(cover);
      out.write("'></a></span>\r\n");
      out.write("     <span><a href=\"getClothesById.do?clotheID=");
      out.print(clotheID);
      out.write('"');
      out.write('>');
      out.print(clotheName);
      out.write("</a></span>\r\n");
      out.write("      <span>￥");
      out.print(sitePrice);
      out.write("</span>\r\n");
      out.write("     <span>×");
      out.print(quantity);
      out.write("</span>\r\n");
      out.write("     <span>小计：");
      out.print(subtotal);
      out.write("</span>\r\n");
      out.write("     </div>\r\n");
      out.write("\t ");

		 }
    
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("   <p>\r\n");
      out.write("\t<span id='count'>");
      out.print(count);
      out.write("</span>件商品应付总额(不含运费)：<span class='total' id ='total'>");
      out.print(total);
      out.write("</span>\r\n");
      out.write("    </p>\r\n");
      out.write("\t \r\n");
      out.write("\t <input type=\"hidden\" name=\"total\" value=\"");
      out.print(total);
      out.write("\">\r\n");
      out.write("\t <input type=\"submit\" value=\"提交订单\">\r\n");
      out.write("\t </form>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
