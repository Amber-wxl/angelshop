<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.*"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!--设置网页编码方式-->
    <link href="css/common.css" rel="stylesheet">
    <link href="css/listOrder.css" rel="stylesheet">
    <!--应用样式文件-->
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/aside.js"></script>
    <script src="js/checkAccount.js"></script>
    <!-- 通过js函数检查是否有cookie存在 -->
    <title>用户订单-ANGELSHOP</title>
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
	    List<Order> orderList=(ArrayList<Order>)request.getAttribute("orderList");
		List<Suborder> suborderList;
		String orderID;
		Clothes clothe;
		StringBuilder  sb;
		for(Order order:orderList){
			orderID=order.getOrderID();
			suborderList=order.getSuborderList();
			sb=new StringBuilder();
			for(Suborder suborder:suborderList){
			clothe=suborder.getClothe();
            sb.append("<div class='suborder'><a href='getClothe.do?clotheID=").append(clothe.getClotheID()).append("'><img src='").append(clothe.getCover()).append("'></a>").append("<span>").append(clothe.getClotheName()).append("</span><span>￥").append(clothe.getPrice()).append("</span><span>×").append(suborder.getCount()).append("</span></div>");
		}
	%>
     <div class="order-box">
     <span class="orderID">订单号：</span><a href="getOrderById.do?orderID=<%=orderID%>"><%=orderID%></a>
     <span class="orderState"><%=order.getOrderState()%></span>
     <%=sb%>
     <span class="total">实付款：<%=order.getTotal()%></span>
     <span class="paymentway">付款方式：<%=order.getPaymentWay()%></span>
     <span class="deliveryway">发货方式：<%=order.getDeliverWay()%></span>
     <span class="ordertime">下单时间：<%=order.getOrderTime()%></span>
     </div>  
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