<%@page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <!--设置网页编码方式-->
    <link href="css/common.css" rel="stylesheet">
    <!--应用样式文件-->
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/aside.js"></script>
    <script src="js/checkAccount.js"></script>
    <!-- 通过js函数检查是否有cookie存在 -->
    <title>订单生成结果-ANGELSHOP</title>
    <!--设置网页标题-->
    <link rel="icon" href="logo.png">
    <!--设置网页小图标-->
    <base target="_blank">
    <!--所有的超链接都在一个新的页面打开-->
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
            </span> |
            <a href="listClothes.do">首页</a> |
            <a href="listCart.do">我的购物车</a> |
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

    <main>
    <%
	    String orderID=(String)request.getAttribute("orderID");
		if(orderID!=null){				
	 %>	  
	 <p>尊敬的用户您好,感谢你提交订单,您的订单编号为<a href="getOrder.do?orderID=<%=orderID%>"><%=orderID%></a>,我们将及时为您处理!</p>
	 <%
		}else{
	 %>
	 <p>尊敬的用户,对不起，生成订单失败，请重试</p>
	 <%
     }
     %>	
    </main>

    <!-- 设置页面尾部 -->
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