<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,java.time.LocalDateTime,gzmtu.xt.dzsw.entity.Order"%>

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
	  List<Order> orderList=(ArrayList<Order>)request.getAttribute("orderlist");
		if(orderList.isEmpty()){
      out.println("<p>没有订单！</p><a href='listCart.do'>去购物车结算>></a>");
		}else{
		%>
    <p class="prompt">订单信息</p>
      <table id='cart'>
        <tr class='thead'>
          <th width='20%'>订单号</th>
          <th width='20%'>实付款</th>
          <th width='10%'>支付方式</th>
          <th width='10%'>发货方式</th>
          <th width='20%'>下单时间</th>
          <th width='20%'>订单状态</th>

        </tr>
    <%
	    String orderID;
	    double total=0;
		String deliverWay;
		String paymentWay;
		LocalDateTime orderTime;
        String orderState;
		for(Order order:orderList){
		    orderID=order.getOrderID();	
            total=order.getTotal();
            deliverWay=order.getDeliverWay();
            paymentWay=order.getPaymentWay();
            orderTime=order.getOrderTime();
            orderState=order.getOrderState();			  		 
	%>
        <tr>
          <td><a href="getOrder.do?orderID=<%=orderID%>"><%=orderID%></a></td>
          <td>￥<%=total%></td>
          <td><%=deliverWay%></td>
          <td><%=paymentWay%></td>
          <td><%=orderTime%></td>
          <td><%=orderState%></td>
        </tr>
    <%
		}
	%>
    </table>
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