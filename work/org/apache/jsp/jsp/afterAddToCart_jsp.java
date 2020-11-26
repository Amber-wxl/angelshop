/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2020-11-20 14:20:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class afterAddToCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <link href=\"css/afterAdddToCart.css\"    rel=\"stylesheet\"> \r\n");
      out.write("   <script src=\"js/checkAccount.js\"></script> \r\n");
      out.write("   <script src=\"js/cart.js\"></script>\r\n");
      out.write("   <title>ANGELSHOP</title>   \r\n");
      out.write("   <link rel=\"icon\" href=\"logo.png\"> <!--设置网页小图标-->\r\n");
      out.write("   <base target=\"_blank\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <!--头部背景图由css样式控制-->\r\n");
      out.write("    <header>\r\n");
      out.write("    </header>\r\n");
      out.write("    <nav>\r\n");
      out.write("      <!--登录注册等操作选项-->\r\n");
      out.write("      <div class=\"action\">\r\n");
      out.write("      <span>\r\n");
      out.write("        <a href=\"login.html\">登录</a>\r\n");
      out.write("        |\r\n");
      out.write("        <a href=\"register.html\">注册</a>\r\n");
      out.write("      </span>\r\n");
      out.write("        |\r\n");
      out.write("        <a href=\"index.html\">首页</a>\r\n");
      out.write("        |\r\n");
      out.write("        <a href=\"listCart.do\">我的购物车</a>\r\n");
      out.write("        |\r\n");
      out.write("        <a href=\"listOrder.do\">我的订单</a>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <!-- 搜索框提交表单 -->\r\n");
      out.write("      <div class=\"search\">\r\n");
      out.write("        <form action=\"searchClothes.do\" method=\"get\">  \r\n");
      out.write("          <input type=\"search\" name=\"value\" size=\"30\" required>\r\n");
      out.write("          <button type=\"submit\" class=\"iconfont\">&#xe60e;</button>\r\n");
      out.write("\t        <select name=\"category\">\r\n");
      out.write("\t          <option value=\"clotheName\" selected>宝贝</option>\r\n");
      out.write("            <option value=\"style\">风格</option>\r\n");
      out.write("            <option value=\"color\">颜色</option>\r\n");
      out.write("\t        </select>\t  \r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("   </nav>\r\n");
      out.write("   <!-- 设置页面的侧栏，实现分类展示 -->\r\n");
      out.write("   <aside>\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li>发饰\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=皇冠\">皇冠</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=发箍\">发箍</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=礼帽\">礼帽</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>服装\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=长款服装\">长款服装</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=短款服装\">短款服装</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=汉服旗袍\">汉服旗袍</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>配饰\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=裙撑\">裙撑</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=披肩\">披肩</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=权杖\">权杖</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=耳环\">耳环</a></li>\r\n");
      out.write("            <li><a href=\"listClothesByType.do?type=颈链\">颈链</a></li>\r\n");
      out.write("\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </aside>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("        ");

        boolean result=(boolean)request.getAttribute("result");
        if(result){	
            int clotheID=(int)request.getAttribute("clotheID");
            String clotheName=(String)request.getAttribute("clotheName");
             
      out.write("\t  \r\n");
      out.write("               <p>商品<a href=\"getClothesById.do?clotheID=");
      out.print(clotheID);
      out.write('"');
      out.write('>');
      out.print(clotheName);
      out.write("</a>已成功加入购物车！<br><br>\r\n");
      out.write("               <a href='order.do' class='list-cart'>去购物车结算></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您还可以<a  class='continue-buy' href='javascript:location.href=document.referrer;'>继续购物></a></p>\r\n");
      out.write("             ");

                 }else{
             
      out.write("\r\n");
      out.write("             <p>加入购物车失败</p>\r\n");
      out.write("             ");

                }
             
      out.write("\t\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("    <!-- 设置页面尾部 -->\r\n");
      out.write("    <footer>\t  \r\n");
      out.write("      <a href=\"index.html\">首页</a>|\r\n");
      out.write("      <a href=\"#\">帮助</a>|\r\n");
      out.write("      <a href=\"#\">我的帐户</a>|\r\n");
      out.write("      <a href=\"#\">我的购物车</a>|\r\n");
      out.write("      <a href=\"#\">广告服务</a>|\r\n");
      out.write("      <a href=\"#\">合作伙伴</a><br>\r\n");
      out.write("      <span>Copyright &#169;ANGELSHOP版权所有</span>\r\n");
      out.write("   </footer>       \r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
