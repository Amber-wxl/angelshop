/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2021-01-09 07:16:48 UTC
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
import gzmtu.xt.dzsw.entity.Clothes;

public final class manageProductList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>商品管理</title>\r\n");
      out.write("    <link rel=\"icon\" href=\"logo.png\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/manage.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/manageProductList.css\">\r\n");
      out.write("    <script src=\"js/checkAdmin.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/aside.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <header>\r\n");
      out.write("        <img src=\"./images/logo.png\" alt=\"\">\r\n");
      out.write("        <span></span>\r\n");
      out.write("        <i>后台管理系统</i>\r\n");
      out.write("    </header>\r\n");
      out.write("    <aside>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>商品管理<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div>\r\n");
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
      out.write("                        <li><a href=\"manageOrderList.do\"> 订单列表</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>用户管理<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div class=\"hide\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"manageUserList.do\"> 用户列表</a></li>\r\n");
      out.write("                        <li><a href=\"\" >管理员列表</a></li>\r\n");
      out.write("                        <li><a href=\"\" target=\"_blank\">管理员注册</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("    </aside>\r\n");
      out.write("    <main>\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td width=\"10%\">货号</td>\r\n");
      out.write("                <td width=\"20%\">名称</td>\r\n");
      out.write("                <td width=\"15%\">主图</td>\r\n");
      out.write("                <td width=\"10%\">所属类目</td>\r\n");
      out.write("                <td width=\"10%\">价格</td>\r\n");
      out.write("                <td width=\"10%\">折扣</td>\r\n");
      out.write("                <td colspan=\"2\" width=\"15%\">操作</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                List<Clothes> clothesList=(ArrayList<Clothes>)request.getAttribute("clothesList");
	            for(Clothes clothes:clothesList){
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><a href=\"productDetail.do?clotheID=");
      out.print(clothes.getClotheID());
      out.write('"');
      out.write('>');
      out.print(clothes.getClotheID());
      out.write("<a></td>\r\n");
      out.write("                <td>");
      out.print(clothes.getClotheName());
      out.write("</td>\r\n");
      out.write("                <td><img src='");
      out.print(clothes.getCover());
      out.write("'></td>\r\n");
      out.write("                <td>");
      out.print(clothes.getType());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(clothes.getPrice());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(clothes.getDiscount());
      out.write("</td>\r\n");
      out.write("                <td><a href=\"productDetail.do?clotheID=");
      out.print(clothes.getClotheID());
      out.write("\">修改<span class=\"iconfont icon\">&#xe607;</span></a></td>\r\n");
      out.write("                <td><a href=\"deleteProduct.do?clotheID=");
      out.print(clothes.getClotheID());
      out.write("\" onclick='return confirm(\"确定删除?\");'>删除<span class=\"iconfont icon\">&#xe69b;</span></a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        ");

            int rows=(int)request.getAttribute("rows");
	        int curPage=(int)request.getAttribute("page");	   
	        int pageSize=(int)request.getAttribute("pageSize");
	        int pages=rows%pageSize==0?rows/pageSize:rows/pageSize+1;
	        String previous=curPage<=1?"&nbsp;&nbsp;":"<a href='manageProductList.do?page="+(curPage-1)+"'><</a>";
            String next=curPage>=pages?"&nbsp;&nbsp;":"<a href='manageProductList.do?page="+(curPage+1)+"'>></a>";
        
      out.write("\r\n");
      out.write("        <div class=\"page\">\r\n");
      out.write("            \r\n");
      out.write("            <form action=\"manageProductList.do\" method='get'>\r\n");
      out.write("                <label class=\"page-nav\">");
      out.print(previous);
      out.write("&nbsp;&nbsp;");
      out.print(curPage);
      out.write("&nbsp;&nbsp;");
      out.print(next);
      out.write("</label>\r\n");
      out.write("                <label>共");
      out.print(pages);
      out.write("页,到第</label>\r\n");
      out.write("                <input type='text' name='page' size='1'>\r\n");
      out.write("                <label>页&nbsp;&nbsp;</label>\r\n");
      out.write("                <input type='submit' value='前往'><span class=\"iconfont\">&#xe61b;</span>\r\n");
      out.write("      </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </main>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
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
