/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2021-01-09 06:52:21 UTC
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

public final class listClothesByType_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("   <meta charset=\"utf-8\">\r\n");
      out.write("   <link href=\"css/clotheList.css\"  rel=\"stylesheet\">\r\n");
      out.write("   <script src=\"js/checkAccount.js\"></script> \r\n");
      out.write("   <script src=\"js/cart.js\"></script>\r\n");
      out.write("   <script src=\"js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/aside.js\"></script>\r\n");
      out.write("   <title>商品分类显示-ANGELSHOP</title>\r\n");
      out.write("   <link rel=\"icon\" href=\"logo.png\">\r\n");
      out.write("   <base target=\"_blank\">   \r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("   <!--头部背景图由css样式控制-->\r\n");
      out.write("   <header>\r\n");
      out.write("  </header>\r\n");
      out.write("  <nav>\r\n");
      out.write("    <!--登录注册等操作选项-->\r\n");
      out.write("    <div class=\"action\">\r\n");
      out.write("    <span>\r\n");
      out.write("      <a href=\"login.html\">登录</a>\r\n");
      out.write("      |\r\n");
      out.write("      <a href=\"register.html\">注册</a>\r\n");
      out.write("    </span>\r\n");
      out.write("      |\r\n");
      out.write("      <a href=\"listClothes.do\">首页</a>\r\n");
      out.write("      |\r\n");
      out.write("      <a href=\"listCart.do\">我的购物车</a>\r\n");
      out.write("      |\r\n");
      out.write("      <a href=\"listOrder.do\">我的订单</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- 搜索框提交表单 -->\r\n");
      out.write("    <div class=\"search\">\r\n");
      out.write("      <form action=\"searchClothes.do\" method=\"get\">  \r\n");
      out.write("        <input type=\"search\" name=\"value\" size=\"30\" required>\r\n");
      out.write("        <button type=\"submit\" class=\"iconfont\">&#xe60e;</button>\r\n");
      out.write("        <select name=\"category\">\r\n");
      out.write("          <option value=\"clotheName\" selected>宝贝</option>\r\n");
      out.write("          <option value=\"style\">风格</option>\r\n");
      out.write("          <option value=\"color\">颜色</option>\r\n");
      out.write("        </select>\t  \r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write(" </nav>\r\n");
      out.write("  <aside>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>发&nbsp;&nbsp;饰<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=皇冠\">皇冠</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=发箍\">发箍</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=礼帽\">礼帽</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>服&nbsp;&nbsp;装<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=长款服装\">长款服装</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=短款服装\">短款服装</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=汉服旗袍\">汉服旗袍</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <span>配&nbsp;&nbsp;饰<span class=\"iconfont xiala\">&#xe662;</span></span>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=裙撑\">裙撑</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=披肩\">披肩</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=权杖\">权杖</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=耳环\">耳环</a></li>\r\n");
      out.write("                        <li><a href=\"listClothesByType.do?type=颈链\">颈链</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </aside>\r\n");
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
      out.write("\t  <p class='info'>找到");
      out.print(rows);
      out.write("条记录,共");
      out.print(pages);
      out.write("页,当前为第");
      out.print(curPage);
      out.write("页</p>\r\n");
      out.write("\t  <div class=\"clothes\">\r\n");
      out.write("      ");

	    List<Clothes> clothesList=(ArrayList<Clothes>)request.getAttribute("clothesList");
	    for(Clothes clothes:clothesList){
	  
      out.write("\r\n");
      out.write("\t    <div class='clothes-list'>\r\n");
      out.write("        <a href=\"getClothesById.do?clotheID=");
      out.print(clothes.getClotheID());
      out.write("\"><img src=\"");
      out.print(clothes.getCover());
      out.write("\"></a>\r\n");
      out.write("\t      <p>\r\n");
      out.write("          <span class=\"site-price\">¥");
      out.print(clothes.getSitePrice());
      out.write("</span>&nbsp;&nbsp;<del>¥");
      out.print(clothes.getPrice());
      out.write("</del><span class=\"origin\">");
      out.print(clothes.getOrigin());
      out.write("</span> <br>\r\n");
      out.write("          <a class=\"clothes-name\" href=\"getClothesById.do?clotheID=");
      out.print(clothes.getClotheID());
      out.write('"');
      out.write('>');
      out.print(clothes.getSimplifyName());
      out.write("</a><br>\r\n");
      out.write("        </p>\r\n");
      out.write("        <div class=\"style\">\r\n");
      out.write("           <span>");
      out.print(clothes.getStyle());
      out.write("&nbsp;|</span>\r\n");
      out.write("           <span>");
      out.print(clothes.getColor());
      out.write("&nbsp;|</span>\r\n");
      out.write("           <span>");
      out.print(clothes.getType());
      out.write("|</span>\r\n");
      out.write("           <span>");
      out.print(clothes.getDeliveryTime());
      out.write("</span>\t \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"button\">\r\n");
      out.write("          <a class=\"bt-buy\" href=\"checkout.do?clotheID=");
      out.print(clothes.getClotheID());
      out.write("\">立即购买</a>\r\n");
      out.write("          <a class='bt-cart iconfont' href=\"javascript:void(0);\" target=\"_self\" onclick=\"addToCart(");
      out.print(clothes.getClotheID());
      out.write(',');
      out.write('\'');
      out.print(clothes.getClotheName());
      out.write("')\">&#xe674;&nbsp;加入购物车</a>  \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\t ");

		}
		
      out.write("\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t\t");

	    String type=(String)request.getAttribute("type");
	    String previous=curPage<=1?"&nbsp;&nbsp;":"<a href='listClothesByType.do?type="+type+"&page="+(curPage-1)+"'><</a>";
       String next=curPage>=pages?"&nbsp;&nbsp;":"<a href='listClothesByType.do?type="+type+"&page="+(curPage+1)+"'>></a>";
	  
      out.write("\r\n");
      out.write("\t <p class=\"page-nav\">");
      out.print(previous);
      out.write("&nbsp;&nbsp;");
      out.print(curPage);
      out.write("&nbsp;&nbsp;");
      out.print(next);
      out.write("</p>\r\n");
      out.write("\t <form action=\"listClothesByType.do\"  method='get'>\r\n");
      out.write("\t    <label>共");
      out.print(pages);
      out.write("页,到第</label>\r\n");
      out.write("\t\t<input type='hidden' name='type' value='");
      out.print(type);
      out.write("'>\r\n");
      out.write("\t\t<input type='text' name='page' size='1'>\t\t\r\n");
      out.write("\t\t<label>页&nbsp;&nbsp;</label>\r\n");
      out.write("\t\t<input type='submit'  value= '前往' ><span class=\"iconfont\">&#xe61b;</span>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");

	  }
	
      out.write("\r\n");
      out.write("    </main> \r\n");
      out.write("    <footer>\t  \r\n");
      out.write("      <a href=\"listClothes.do\">首页</a>|\r\n");
      out.write("      <a href=\"#\">帮助</a>|\r\n");
      out.write("      <a href=\"#\">我的帐户</a>|\r\n");
      out.write("      <a href=\"#\">我的购物车</a>|\r\n");
      out.write("      <a href=\"#\">广告服务</a>|\r\n");
      out.write("      <a href=\"#\">合作伙伴</a><br>\r\n");
      out.write("      <span>Copyright &#169;ANGELSHOP版权所有</span>\r\n");
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
