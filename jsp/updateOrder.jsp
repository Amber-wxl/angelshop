<%@page contentType="text/html;charset=utf-8"%>
<%@page import="gzmtu.xt.dzsw.entity.*,java.time.LocalDateTime,java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单管理-ANGELSHOP</title>
    <link rel="icon" href="logo.png">
    <link rel="stylesheet" href="css/manage.css">
    <link rel="stylesheet" href="css/updateOrder.css">
    <script src="js/checkAdmin.js"></script>
    <script src="js/setReturnUrl.js"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/selected.js"></script>
    <script src="js/aside.js"></script>
    <style>
    img{width:100px;}
    </style>
    
</head>

<body>

    <header>
        <img src="./images/logo.png" alt="">
        <span></span>
        <i>后台管理系统</i>
    </header>
    <aside>
        <ul>
            <li>
                <span>商品管理<span class="iconfont xiala">&#xe662;</span></span>
                <div class="hide">
                    <ul>
                        <li ><a href="manageProductList.do"> 商品列表</a></li>
                        <li><a href="addProduct.html" target="_blank">添加商品</a></li>
                    </ul>
                </div>
            </li>

            <li>
                <span>订单管理<span class="iconfont xiala">&#xe662;</span></span>
                <div >
                    <ul>
                        <li class="active"><a href="manageOrderList.do"> 订单列表</a></li>
                    </ul>
                </div>
            </li>

            <li>
                <span>用户管理<span class="iconfont xiala">&#xe662;</span></span>
                <div class="hide">
                    <ul>
                        <li><a href="manageCustomerList.do"> 用户列表</a></li>
                        <li><a href="manageUserList.do" >管理员列表</a></li>
                        <li><a href="" target="_blank">管理员注册</a></li>
                    </ul>
                </div>
            </li>

    </ul>
    </aside>
    <main>
    <%
	    Order order=(Order)request.getAttribute("order");       
        String orderID=order.getOrderID();
		LocalDateTime orderTime=order.getOrderTime();
		String paymentWay=order.getPaymentWay();
        String deliverWay=order.getDeliverWay();
		double total=order.getTotal();
        String orderState=order.getOrderState();
		Customer customer=order.getCustomer();
		String account=customer.getAccount();
		String address=customer.getAddress();
		String phone=customer.getPhone();		
	%>
    <form action="updateOrder.do" method="post">
        <label>订单号：<%=orderID%></label><input type="hidden" value="<%=orderID%>" name="orderID">
        <label>用户ID：<%=account%></label>
        <label>下单时间：<%=orderTime%></label>
        <br>
        <label>付款方式：</label>
        <select name="paymentWay" id="paymentWay" data-paymentWay="<%=paymentWay%>">
               <option value="网上支付">网上支付</option>
               <option value="货到付款-现金">货到付款-现金</option>
               <option value="货到付款-POS机刷卡">货到付款-POS机刷卡</option>
               <option value="银行转账">银行转账</option>
        </select>

        <label>送货方式：</label>
        <select name="deliverWay" id="deliverWay" data-deliverWay="<%=deliverWay%>">
               <option value="普通快递">普通快递</option>
               <option value="特快专递">特快专递</option>
        </select>

        <label>订单状态：</label>
        <select name="orderState" id="orderState" data-orderState="<%=orderState%>">
               <option value="待审核">待审核</option>
               <option value="待发货">待发货</option>
               <option value="待收货">待收货</option>
               <option value="待评价">待评价</option>
               <option value="已完成">已完成</option>
        </select>
       

        <h4>商品清单：</h4>
        <table>
        <th>
        <td width="50%">商品标题</td>
        <td width="10%">单价</td>
        <td width="10%">数量</td>
        <td width="10%">折扣</td>
        <td width="10%">小计</td>
        </th>
    
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
    <tr>
    <td><img src='<%=cover%>'></td>
    <td><%=clotheName%></td>
    <td>￥<%=price%></td>
    <td><%=count%></td>
    <td><%=discount%></td>
    <td><%=subtotal%></td>
    </tr>

        
	<%
    }
    %>
    <tr>
        
        <td colspan="6">订单总金额:<%=total%></td>
    </tr>
    </table>
    <input type="hidden" name="returnUrl">
    <input type="submit" value="提交">
    </form>	 
    </main>
    

</body>

</html>