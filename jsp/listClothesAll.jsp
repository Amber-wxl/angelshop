<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Clothes"%>

<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <%-- <link href="css/common.css"  rel="stylesheet">   --%>
  <link href="css/listClothesAll.css" rel="stylesheet">
  <script src="js/checkAccount.js"></script>
  <script src="js/cart.js"></script>
  <title>ANGELSHOP</title>
  <link rel="icon" href="logo.png">
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
    <div class="clothes">
      <%
	    List<Clothes> clothesList=(ArrayList<Clothes>)request.getAttribute("clothesList");
	    for(Clothes clothes:clothesList){
	  %>
      <div class='clothes-list'>
        <a href="getClothesById.do?clotheID=<%=clothes.getClotheID()%>"><img src="<%=clothes.getCover()%>"></a>
        <p>
          <span
            class="site-price">¥<%=clothes.getSitePrice()%></span>&nbsp;&nbsp;<del>¥<%=clothes.getPrice()%></del><span
            class="origin"><%=clothes.getOrigin()%></span> <br>
          <a class="clothes-name"
            href="getClothesById.do?clotheID=<%=clothes.getClotheID()%>"><%=clothes.getSimplifyName()%></a><br>
        </p>
        <div class="style">
          <span><%=clothes.getStyle()%>&nbsp;|</span>
          <span><%=clothes.getColor()%>&nbsp;|</span>
          <span><%=clothes.getType()%>|</span>
          <span><%=clothes.getDeliveryTime()%></span>
        </div>
        <div class="button">
          <a class="bt-buy" href="">立即购买</a>
          <a class='bt-cart iconfont' href="javascript:void(0);"
            onclick="addToCart(<%=clothes.getClotheID()%>,'<%=clothes.getClotheName()%>')">&#xe674;&nbsp;加入购物车</a>
        </div>
        <!-- <a class='cart' href="javascript:void(0);" onclick="addToCart(<%=clothes.getClotheID()%>,'<%=clothes.getClotheName()%>')"><span class="iconfont cartlogo">&#xe674;</span></a>  -->
      </div>
      <%}%>
	</div>
		<%
      int rows=(int)request.getAttribute("rows");
	    int curPage=(int)request.getAttribute("page");	   
	    int pageSize=(int)request.getAttribute("pageSize");
	    int pages=rows%pageSize==0?rows/pageSize:rows/pageSize+1;
	    String previous=curPage<=1?"&nbsp;&nbsp;":"<a href='listClothes.do?page="+(curPage-1)+"'><</a>";
      String next=curPage>=pages?"&nbsp;&nbsp;":"<a href='listClothes.do?page="+(curPage+1)+"'>></a>";
    %>

      <p class="page-nav"><%=previous%>&nbsp;&nbsp;<%=curPage%>&nbsp;&nbsp;<%=next%></p>
      <form action="listClothes.do" method='get'>
        <label>共<%=pages%>页,到第</label>
        <input type='text' name='page' size='1'>
        <label>页&nbsp;&nbsp;</label>
        <input type='submit' value='前往'><span class="iconfont">&#xe6b7;</span>
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