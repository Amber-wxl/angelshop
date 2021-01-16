<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Cart,gzmtu.xt.dzsw.entity.Clothes"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!--设置网页编码方式-->
    <link href="css/cart.css" rel="stylesheet">
    <!--应用样式文件-->
    <script src="js/checkAccount.js"></script>
    <script src="js/cart.js"></script>
    <%-- 引入js文件 --%>
    <title>购物车-ANGELSHOP</title>
    <!--设置网页标题-->
    <link rel="icon" href="logo.png">
    <!--设置网页小图标-->
</head>
<body>
 <!--头部背景图由css样式控制-->
    <header>
    </header>
    <nav>
        <!--登录注册等操作选项-->
        <div class="action">
          <span><a href="login.html" target="_blank">登录</a>|<a href="register.html" target="_blank">注册</a></span>|
          <a href="listClothes.do">首页</a>|
          <a href="listCart.do" target="_blank">我的购物车</a>|
          <a href="listOrder.do" target="_blank">我的订单</a>
        </div>

        <!-- 搜索框提交表单 -->
        <div class="search">
          <form action="searchClothes.do" method="get">
            <input type="search" name="value" size="30" required>
            <button type="submit" class="iconfont">&#xe6bf;</button>
            <select name="category">
              <option value="clotheName" selected>宝贝</option>
              <option value="style">风格</option>
              <option value="color">颜色</option>
            </select>
          </form>
        </div>
    </nav>
  
  <main>
  <%
	  List<Cart> cartList=(ArrayList<Cart>)request.getAttribute("cartList");
		if(cartList.isEmpty()){
      out.println("<div class='emptyCart'><img src='images/cart.png'/></div><p>购物车空空如也</p><a href='listClothes.do'>去选购>></a>");
		}else{
	%>
    <p class="prompt">你购物车中的购物情况如下</p>
    <form action="checkout.do" method="get">
      <table id='cart'>
        <tr class='thead'>
          <th width='5%'></th>
          <th width='10%'>商品</th>
          <th width='30%'>标题</th>
          <th width='20%'>单价</th>
          <th width='15%'>数量</th>
          <th width='10%'>小计</th>
          <th width='10%'>操作</th>
        </tr>
    <%
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
        subtotal=Double.parseDouble(String.format("%.2f",sitePrice*quantity));
			  count=count+quantity;
		    total=Double.parseDouble(String.format("%.2f",total+subtotal));			 
	  %>
        <tr>
          <td><input type="checkbox" class="select-product" name="clotheID" value="<%=clotheID%>" checked>
          <td><a href="getClothesById.do?clotheID=<%=clotheID%>"><img src='<%=cover%>' width='80' height='100'></a></td>
          <td><a href="getClothesById.do?clotheID=<%=clotheID%>"><%=clotheName%></a></td>
          <td>￥<%=sitePrice%></td>
          <td width='50'>
            <button class="down" type="button" clotheid="<%=clotheID%>">-</button>
            <input class="edit-quantity" type="text" id="<%=clotheID%>" value="<%=quantity%>" data-prevalue="<%=quantity%>" data-siteprice="<%=sitePrice%>" size="5">
            <button class="up" type="button" clotheid="<%=clotheID%>">+</button>
          </td>
          <td class="subtotal" id="<%=(clotheID+"total")%>"><%=subtotal%></td>
          <td><button class="remove" type='button' clotheid="<%=clotheID%>">删除</button></td>
        </tr>
    <%
		  }
	  %>
    </table>
    <p class='checkoutInfo' colspan="7">
      <span id='count'><%=count%></span>件宝贝应付总额(不含运费)：<span class='total' id='total'><%=total%></span>
      <input class="checkout" type="submit"  value="结&nbsp;&nbsp;算">
    </p>
    </form>
    <%
      }
    %>
  </main>

  <footer>
    <a href="listClothes.do">首页</a>|
    <a href="#">帮助</a>|
    <a href="#">我的帐户</a>|
    <a href="#">我的购物车</a>|
    <a href="#">广告服务</a>|
    <a href="#">合作伙伴</a><br>
    <span>Copyright &#169;ANGELSHOP版权所有</span>
  </footer>
</body>

</html>