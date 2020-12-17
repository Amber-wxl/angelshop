<%@page contentType="text/html;charset=utf-8"%>
<%@page import="gzmtu.xt.dzsw.entity.*,java.time.LocalDateTime,java.util.ArrayList"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <!--设置网页编码方式-->
    <link href="css/common.css" rel="stylesheet">
    <link href="css/getOrder.css" rel="stylesheet">
    <!--应用样式文件-->
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/aside.js"></script>
    <script src="js/checkAccount.js"></script>
    <!-- 通过js函数检查是否有cookie存在 -->
    <title>订单详情-ANGELSHOP</title>
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
	    Order order=(Order)request.getAttribute("order");       
        String orderID=order.getOrderID();
		LocalDateTime orderTime=order.getOrderTime();
		String paymentWay=order.getPaymentWay();
        String deliverWay=order.getDeliverWay();
		double total=order.getTotal();
		Customer customer=order.getCustomer();
		String account=customer.getAccount();
		String address=customer.getAddress();
		String phone=customer.getPhone();		
	%>
    <div class="order-detail">
    <div class="message">
    <span>订单号：<%=orderID%></span>
    <span>收&nbsp;&nbsp;货&nbsp;&nbsp;人：<%=account%></span>
    <span>下单时间：<%=orderTime%></span>
    <span>付款方式：<%=paymentWay%></span>
    <span>送货方式：<%=deliverWay%></span>
    <span>商品清单：</span>
    </div>
    <%
        ArrayList<Suborder> suborderList=order.getSuborderList();
		Clothes clothe;
		int clotheID;
		String cover;
		String clotheName;
		double price;
		double discount;		
		int count;
		double subtotal;
		for(Suborder suborder:suborderList){
			count=suborder.getCount();
			clothe=suborder.getClothe();
			clotheID=clothe.getClotheID();
			cover=clothe.getCover();
			clotheName=clothe.getClotheName();
			price=clothe.getPrice();
			discount=clothe.getDiscount();				
            subtotal=Double.parseDouble(String.format("%.2f",clothe.getSitePrice()*count));
    %>
    <div class="product-list">
        <a href='getClothesById.do?clotheID=<%=clotheID%>'><img src='<%=cover%>'></a>
        <span> <a href='getClothesById.do?clotheID=<%=clotheID%>'><%=clotheName%></a></span>
        <span>￥<%=price%></span>
        <span>×<%=count%></span>
        <span>实付款：<%=subtotal%></span>
        <span><a href='addToCart.do?clotheID=<%=clotheID%>&clotheName=<%=clotheName%>'>再次购买>></a></span>
        </div> 
	<%
    }
    %>
    <p>
        订单总金额:<%=total%>
    </p>	  
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