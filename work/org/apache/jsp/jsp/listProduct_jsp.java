/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2020-11-05 04:56:03 UTC
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
import gzmtu.xt.dzsw.entity.Product;

public final class listProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("gzmtu.xt.dzsw.entity.Product");
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
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <link href=\"css/global.css\"  rel=\"stylesheet\">  \r\n");
      out.write("   <link href=\"css/bookList.css\"  rel=\"stylesheet\">\r\n");
      out.write("   <script src=\"scripts/checkAccount.js\"></script> \r\n");
      out.write("   <title>SHOPBODY</title>   \r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <header>\r\n");
      out.write("    <div id=\"action\">\r\n");
      out.write("\t    <a href=\"login.html\">登录</a>|\r\n");
      out.write("        <a href=\"register.html\">注册</a>|\t \r\n");
      out.write("        <a href=\"listCart.do\">我的购物车</a>|\r\n");
      out.write("        <a href=\"listOrder.do\">我的订单</a>\r\n");
      out.write("    </div>\r\n");
      out.write("   </header>   \r\n");
      out.write("   <nav>\r\n");
      out.write("   \t<ul>\r\n");
      out.write("      <li><a href=\"selectAll.do\" class=\"active\">每日推荐</a></li>\r\n");
      out.write("      <li><a href=\"selectByDate.do\">上新</a></li>\r\n");
      out.write("      <li><a href=\"selectBySale\">销量</a></li>\r\n");
      out.write("      <li><a href=\"selectByPrice.do\">价格</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("     <form  id=\"search\" action=\"searchBooks.do\" method=\"get\">   \r\n");
      out.write("\t    <input type=\"search\" name=\"value\" size=\"30\" required>\r\n");
      out.write("\t    <select name=\"category\">\r\n");
      out.write("\t      <option value=\"pName\" selected>宝贝</option>\t\t  \r\n");
      out.write("        <option value=\"type\">类型</option>\r\n");
      out.write("        <option value=\"brand\">品牌</option>\r\n");
      out.write("\t   </select>\r\n");
      out.write("\t   <input type=\"submit\" value=\"搜索\">\t  \r\n");
      out.write("\t  </form>\r\n");
      out.write("   </nav>\r\n");
      out.write("\r\n");
      out.write("   <aside>\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li>上装\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=毛衣\">毛衣</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=卫衣\">卫衣</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=衬衫\">衬衫</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=T恤\">T恤</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=马甲\">马甲</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=雪纺衫\">雪纺衫</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>外套\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=短外套\">短外套</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=棉衣棉服\">棉衣棉服</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=毛呢大衣\">毛呢大衣</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=羽绒服\">羽绒服</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=风衣\">风衣</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=皮草\">皮草</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=皮衣\">皮衣</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>裤装\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=休闲裤\">休闲裤</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=牛仔裤\">牛仔裤</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=打底裤\">打底裤</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=羽绒裤\">羽绒裤</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>裙装\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=连衣裙\">连衣裙</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=半身裙\">半身裙</a></li>\r\n");
      out.write("            <li><a href=\"listProduct.do?type=旗袍\">旗袍</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("   </aside>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("\t  ");

	   int rows=(int)request.getAttribute("rows");
	   if(rows==0){
	  
      out.write("\r\n");
      out.write("      <p class='info'>没有找到相关的商品信息</p>\r\n");
      out.write("\t  ");

	   }else{
	    int curPage=(int)request.getAttribute("page");	   
	    int pageSize=(int)request.getAttribute("pageSize");
	    int pages=rows%pageSize==0?rows/pageSize:rows/pageSize+1;
      
      out.write("\t  \r\n");
      out.write("\t  <p class='info'>共");
      out.print(rows);
      out.write("条记录,每页显示");
      out.print(pageSize);
      out.write('条');
      out.write(',');
      out.write('共');
      out.print(pages);
      out.write("页,当前为第");
      out.print(curPage);
      out.write("页</p>\r\n");
      out.write("      ");

	    List<Product> productList=(ArrayList<Product>)request.getAttribute("productList");
	    for(Product product:productList){
	  
      out.write("\r\n");
      out.write("\t   <div class='product-list'>\r\n");
      out.write("         <a href=\"getProductById.do?pid=");
      out.print(product.getPid());
      out.write("\"><img src=\"");
      out.print(product.getCover());
      out.write("\"></a>\r\n");
      out.write("\t     <p><a class=\"product-name\" href=\"getProductById.do?pid=");
      out.print(product.getPid());
      out.write('"');
      out.write('>');
      out.print(product.getPName());
      out.write("</a><br>\r\n");
      out.write("\t       <span class=\"site-price\">¥");
      out.print(product.getSitePrice());
      out.write("</span>&nbsp;&nbsp;<del>¥");
      out.print(product.getPrice());
      out.write("</del><span class='discount'>(");
      out.print(product.getDiscount());
      out.write(")</span><br> \r\n");
      out.write("           <span>[");
      out.print(product.getBrand());
      out.write("&nbsp;&nbsp;");
      out.print(product.getSales());
      out.write("&nbsp;&nbsp;");
      out.print(product.getType());
      out.write("]</span><br>\r\n");
      out.write("           <span>");
      out.print(product.getSimplifyContent());
      out.write("</span><br> \r\n");
      out.write("          <a class='cart' href=\"\">加入购物车</a>\t\t \r\n");
      out.write("        </p>    \r\n");
      out.write("       </div>\r\n");
      out.write("\t ");

		}
	    String type=(String)request.getAttribute("type");
	    String previous=curPage<=1?"&nbsp;&nbsp;":"<a href='listProductByType.do?type="+type+"&page="+(curPage-1)+"'><</a>";
       String next=curPage>=pages?"&nbsp;&nbsp;":"<a href='listProductByType.do?type="+type+"&page="+(curPage+1)+"'>></a>";
	 
      out.write("\r\n");
      out.write("\t <p class=\"page-nav\">");
      out.print(previous);
      out.write("&nbsp;&nbsp;");
      out.print(curPage);
      out.write("&nbsp;&nbsp;");
      out.print(next);
      out.write("</p>\r\n");
      out.write("\t <form action=\"listProductByType.do\"  method='get'>\r\n");
      out.write("\t    <label>共");
      out.print(pages);
      out.write("页,到第</label>\r\n");
      out.write("\t\t<input type='hidden' name='type' value='");
      out.print(type);
      out.write("'>\r\n");
      out.write("\t\t<input type='text' name='page' size='6'>\t\t\r\n");
      out.write("\t\t<label>页&nbsp;&nbsp;</label>\r\n");
      out.write("\t\t<input type='submit'  value= '前往' >\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");

	  }
	 
      out.write("\r\n");
      out.write("    </main> \r\n");
      out.write("    <footer>\t  \r\n");
      out.write("      <a href=\"index.html\">首页</a>|\r\n");
      out.write("      <a href=\"#\">帮助</a>|\r\n");
      out.write("      <a href=\"#\">我的帐户</a>|\r\n");
      out.write("      <a href=\"#\">我的购物车</a>|\r\n");
      out.write("      <a href=\"#\">广告服务</a>|\r\n");
      out.write("      <a href=\"#\">合作伙伴</a><br>\r\n");
      out.write("      <span>Copyright &#169;SHOPBODY版权所有</span>\r\n");
      out.write("   </footer>    \r\n");
      out.write("  </body>\r\n");
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
