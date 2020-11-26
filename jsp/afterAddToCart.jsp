<%@page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html>
  <head>
   <meta charset="utf-8">
   <link href="css/afterAdddToCart.css"    rel="stylesheet"> 
   <script src="js/checkAccount.js"></script> 
   <script src="js/cart.js"></script>
   <title>ANGELSHOP</title>   
   <link rel="icon" href="logo.png"> <!--设置网页小图标-->
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
        <%
        boolean result=(boolean)request.getAttribute("result");
        if(result){	
            int clotheID=(int)request.getAttribute("clotheID");
            String clotheName=(String)request.getAttribute("clotheName");
             %>	  
               <p>商品<a href="getClothesById.do?clotheID=<%=clotheID%>"><%=clotheName%></a>已成功加入购物车！<br><br>
               <a href='order.do' class='list-cart'>去购物车结算></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您还可以<a  class='continue-buy' href='javascript:location.href=document.referrer;'>继续购物></a></p>
             <%
                 }else{
             %>
             <p>加入购物车失败</p>
             <%
                }
             %>	
    </main>

            
    <!-- 设置页面尾部 -->
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





























