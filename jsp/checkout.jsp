<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Cart,gzmtu.xt.dzsw.entity.Clothes"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <!--设置网页编码方式-->
    <link href="css/common.css" rel="stylesheet">
    <link href="css/checkout.css" rel="stylesheet">
    <!--应用样式文件-->
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/aside.js"></script>
    <script src="js/checkAccount.js"></script>
    <!-- 通过js函数检查是否有cookie存在 -->
    <title>提交订单-ANGELSHOP</title>
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
    <form action="createOrder.do" method="get">
	        <label class="deliverWay">送货方式</label><br>
	        <input type="radio" name="deliverWay" value="普通快递" checked><label>普通快递送货上门</label><br>
	        <input type="radio" name="deliverWay" value="特快专递"><label>特快专递（凭身份证签收，请实名下单）（不支持货到付款）</label><br><br>
	        <label class="paymentWay">支付方式</label><br>
	        <input type="radio" name="paymentWay" value="网上支付" checked><label>网上支付</label><br>
	        <input type="radio" name="paymentWay" value="货到付款-现金"><label>货到付款-现金</label><br>
	        <input type="radio" name="paymentWay" value="货到付款-POS机刷卡"><label>货到付款-POS机刷卡</label><br>
	        <input type="radio" name="paymentWay" value="银行转帐"><label>银行转帐</label><br><br>	     
	        
	    <%	
		 List<Cart> cartList=(ArrayList<Cart>)request.getAttribute("cartList");
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
			 String clotheIDAndCount=clotheID+":"+quantity;
             subtotal=Double.parseDouble(String.format("%.2f",sitePrice*quantity));
			 count=count+quantity;
			 total=Double.parseDouble(String.format("%.2f",total+subtotal));			 
	 %>
     <div class="order-submit">
     <input  type="hidden" name="clotheIDAndCount" value="<%= clotheIDAndCount%>" >
     <span><a href="getClothesById.do?clotheID=<%=clotheID%>"><img src='<%=cover%>'></a></span>
     <span><a href="getClothesById.do?clotheID=<%=clotheID%>"><%=clotheName%></a></span>
      <span>￥<%=sitePrice%></span>
     <span>×<%=quantity%></span>
     <span>小计：<%=subtotal%></span>
	 <%
		 }
    %>
    </div>
   <p>
	<span id='count'><%=count%></span>件商品应付总额(不含运费)：<span class='total' id ='total'><%=total%></span>
    </p>
	 
	 <input type="hidden" name="total" value="<%=total%>">
	 <input type="submit" value="提交订单">
	 </form>
    </main>

    
</body>

</html>