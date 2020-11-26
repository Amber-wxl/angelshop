<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Cart,gzmtu.xt.dzsw.entity.Clothes"%>

<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <link href="css/cart.css" rel="stylesheet">
  <script src="js/checkAccount.js"></script>
  <script src="js/cart.js"></script>
  <title>ANGELSHOP</title>
  <link rel="icon" href="logo.png">
  <!--设置网页小图标-->
  <base target="_blank">
</head>

<body>
  <!--头部背景图由css样式控制-->
  <header>
  </header>
  <nav>
    <!--登录注册等操作选项-->
    <div class="action">
      <span>
        <a href="login.html">登录</a>
        |
        <a href="register.html">注册</a>
      </span>
      |
      <a href="index.html">首页</a>
      |
      <a href="listCart.do">我的购物车</a>
      |
      <a href="listOrder.do">我的订单</a>
    </div>

    <!-- 搜索框提交表单 -->
    <div class="search">
      <form action="searchClothes.do" method="get">
        <input type="search" name="value" size="30" required>
        <button type="submit" class="iconfont">&#xe60e;</button>
        <select name="category">
          <option value="clotheName" selected>宝贝</option>
          <option value="style">风格</option>
          <option value="color">颜色</option>
        </select>
      </form>
    </div>
  </nav>
  <!-- 设置页面的侧栏，实现分类展示 -->
  <aside>
    <ul>
      <li>发饰
        <ul>
          <li><a href="listClothesByType.do?type=皇冠">皇冠</a></li>
          <li><a href="listClothesByType.do?type=发箍">发箍</a></li>
          <li><a href="listClothesByType.do?type=礼帽">礼帽</a></li>
        </ul>
      </li>
      <li>服装
        <ul>
          <li><a href="listClothesByType.do?type=长款服装">长款服装</a></li>
          <li><a href="listClothesByType.do?type=短款服装">短款服装</a></li>
          <li><a href="listClothesByType.do?type=汉服旗袍">汉服旗袍</a></li>
        </ul>
      </li>
      <li>配饰
        <ul>
          <li><a href="listClothesByType.do?type=裙撑">裙撑</a></li>
          <li><a href="listClothesByType.do?type=披肩">披肩</a></li>
          <li><a href="listClothesByType.do?type=权杖">权杖</a></li>
          <li><a href="listClothesByType.do?type=耳环">耳环</a></li>
          <li><a href="listClothesByType.do?type=颈链">颈链</a></li>

        </ul>
      </li>
    </ul>
  </aside>
  <main>
    <p class="prompt">你购物车中的购物情况如下</p>
    <form action="/checkout.do" method="post">
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
	     List<Cart> cartList=(ArrayList<Cart>)request.getAttribute("cartList");	
		   int clotheID;
		   String cover;
		   String clotheName;
       double sitePrice;
		   int quantity;
		   Clothes clothe;
		   for(Cart cart:cartList){
		   clotheID=cart.getClotheID();	
			 clothe=cart.getClothe();
			 clotheName=clothe.getClotheName();
			 cover=clothe.getCover();
			 sitePrice=clothe.getSitePrice();
			 quantity=cart.getQuantity();
			 count=count+quantity;
			 total=total+sitePrice*quantity;			 
	 %>
        <tr>
          <td><input type="checkbox" name="clotheID" value="<%=clotheID%>" checked>
          <td>
            <a href="getClothesById.do?clotheID=<%=clotheID%>">
              <img src='<%=cover%>' width='80' height='100'>
            </a>
          </td>
          <td><a href="getClothesById.do?clotheID=<%=clotheID%>"><%=clotheName%></a></td>
          <td>￥<%=sitePrice%></td>
          <td width='100'>
            <button class="down" type="button">-</button>
            <input class="changeQuantity" type="text" name="<%=clotheID%>" value="<%=quantity%>" size="6">
            <button class="up" type="button">+</button>
          </td>
          <td class="subtotal"><%=quantity*sitePrice%></td>
          <td><a class="delete" href="removeFromCart.do?clotheID=<%=clotheID%>" target="_self"
              onclick='return confirm("你确认要从购物车中删除该宝贝吗?");'>删除</a></td>
        </tr>
        <%
		 }
	   total=Double.parseDouble(String.format("%.2f",total));
	 %>
      </table>
      <p class='checkoutInfo'>
        <span id='count'><%=count%></span>件宝贝应付总额(不含运费)：<span class='total' id='total'><%=total%></span>
        <input class="checkout" type="submit" name="checkout" value="结&nbsp;&nbsp;算">
      </p>
    </form>
  </main>

  <footer>
    <a href="index.html">首页</a>|
    <a href="#">帮助</a>|
    <a href="#">我的帐户</a>|
    <a href="#">我的购物车</a>|
    <a href="#">广告服务</a>|
    <a href="#">合作伙伴</a><br>
    <span>Copyright &#169;ANGELSHOP版权所有</span>
  </footer>
</body>

</html>