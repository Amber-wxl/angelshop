/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2021-01-09 07:28:47 UTC
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
import gzmtu.xt.dzsw.entity.*;

public final class updateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("gzmtu.xt.dzsw.entity");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
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
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>商品管理-ANGELSHOP</title>\r\n");
      out.write("    <link rel=\"icon\" href=\"logo.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/manage.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/updateProduct.css\">\r\n");
      out.write("    <script src=\"js/checkAdmin.js\"></script>\r\n");
      out.write("    <script src=\"js/setReturnUrl.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/selected.js\"></script>\r\n");
      out.write("    <script src=\"js/aside.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("    img{\r\n");
      out.write("        width:100px;\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("     <header>\r\n");
      out.write("        <img src=\"./images/logo.png\" alt=\"\">\r\n");
      out.write("        <span></span>\r\n");
      out.write("        <i>后台管理系统</i>\r\n");
      out.write("    </header>\r\n");
      out.write("    <aside>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>商品管理<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div >\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class=\"active\"><a href=\"manageProductList.do\"> 商品列表</a></li>\r\n");
      out.write("                        <li><a href=\"addProduct.html\" target=\"_blank\">添加商品</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>订单管理<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div class=\"hide\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li ><a href=\"manageOrderList.do\"> 订单列表</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>用户管理<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div class=\"hide\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"manageCustomerList.do\"> 用户列表</a></li>\r\n");
      out.write("                        <li><a href=\"manageUserList.do\" >管理员列表</a></li>\r\n");
      out.write("                        <li><a href=\"addAdmin.html\" target=\"_blank\">管理员注册</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("    </aside>\r\n");
      out.write("    <main>\r\n");
      out.write("    ");

     Clothes clothes=(Clothes)request.getAttribute("clothes");
    
      out.write("\r\n");
      out.write("        <h3>商品信息</h3>\r\n");
      out.write("        <form action=\"updateProduct.do\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <label>货&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：");
      out.print(clothes.getClotheID());
      out.write("</label><input type=\"hidden\" name=\"clotheID\" value=\"");
      out.print(clothes.getClotheID());
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>商品名称：</label><input type=\"text\" size=\"80\" name=\"clotheName\" value=\"");
      out.print(clothes.getClotheName());
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>发货地点：</label>\r\n");
      out.write("            <select name=\"origin\" id=\"origin\" data-origin=\"");
      out.print(clothes.getOrigin());
      out.write("\">\r\n");
      out.write("               <option value=\"广东广州\">广东-广州</option>\r\n");
      out.write("               <option value=\"江苏苏州\">江苏-苏州</option>\r\n");
      out.write("               <option value=\"浙江温州\">浙江-温州</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>风&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>\r\n");
      out.write("            <select name=\"style\" id=\"style\" data-style=\"");
      out.print(clothes.getStyle());
      out.write("\">\r\n");
      out.write("                <option value=\"公主\">公主</option>\r\n");
      out.write("                <option value=\"礼服\">礼服</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>\r\n");
      out.write("            <select name=\"color\" id=\"color\" data-color=\"");
      out.print(clothes.getColor());
      out.write("\">\r\n");
      out.write("                <option value=\"粉色\">粉色</option>\r\n");
      out.write("                <option value=\"蓝色\">蓝色</option>\r\n");
      out.write("                <option value=\"金色\">金色</option>\r\n");
      out.write("                <option value=\"红色\">红色</option>\r\n");
      out.write("                <option value=\"白色\">白色</option>\r\n");
      out.write("                <option value=\"灰色\">灰色</option>\r\n");
      out.write("                <option value=\"黑白\">黑白</option>\r\n");
      out.write("                <option value=\"香槟色\">香槟色</option>\r\n");
      out.write("                <option value=\"金黄色\">金黄色</option>\r\n");
      out.write("                <option value=\"渐变色\">渐变色</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>发货时间：</label>\r\n");
      out.write("            <select name=\"deliveryTime\" id=\"deliveryTime\" data-deliveryTime=\"");
      out.print(clothes.getDeliveryTime());
      out.write("\">\r\n");
      out.write("                <option value=\"当天发货\" selected>当天发货</option>\r\n");
      out.write("                <option value=\"7天内发货\">7天内发货</option>\r\n");
      out.write("                <option value=\"15天内发货\">7天内发货</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>\r\n");
      out.write("            <input type=\"text\" name=\"price\" value=\"");
      out.print(clothes.getPrice());
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>折&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扣：</label>\r\n");
      out.write("            <input type=\"text\" name=\"discount\" value=\"");
      out.print(clothes.getDiscount());
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>封面图片：</label>\r\n");
      out.write("            <img src=\"");
      out.print(clothes.getCover());
      out.write("\">\r\n");
      out.write("            <input type=\"file\" name=\"cover\" >\r\n");
      out.write("\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>所属类目</label>\r\n");
      out.write("            <select name=\"type\" id=\"type\" data-type=\"");
      out.print(clothes.getType());
      out.write("\">\r\n");
      out.write("                <option value=\"长款服装\" selected='selected'>长款服装</option>\r\n");
      out.write("                <option value=\"短款服装\">短款服装</option>\r\n");
      out.write("                <option value=\"汉服旗袍\">汉服旗袍</option>\r\n");
      out.write("                <option value=\"皇冠\">皇冠</option>\r\n");
      out.write("                <option value=\"发箍\">发箍</option>\r\n");
      out.write("                <option value=\"礼帽\">礼帽</option>\r\n");
      out.write("                <option value=\"裙撑\">裙撑</option>\r\n");
      out.write("                <option value=\"披肩\">披肩</option>\r\n");
      out.write("                <option value=\"权杖\">权杖</option>\r\n");
      out.write("                <option value=\"耳环\">耳环</option>\r\n");
      out.write("                <option value=\"颈链\">颈链</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <br>\r\n");
      out.write("            <label>详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：</label>\r\n");
      out.write("            <textarea  cols=\"80\" rows=\"5\" name=\"content\">");
      out.print(clothes.getContent());
      out.write("</textarea>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"hidden\" name=\"returnUrl\">\r\n");
      out.write("            <input type=\"submit\" value=\"提交\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </main>\r\n");
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
