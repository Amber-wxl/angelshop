<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Order"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单管理</title>
    <link rel="icon" href="logo.png">
    <link rel="stylesheet" href="css/manage.css">
    <link rel="stylesheet" href="css/manageProductList.css">
    <script src="js/checkAdmin.js"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/aside.js"></script>
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
        <table>
            <tr>
                <td width="10%">订单号</td>
                <td width="10%">用户ID</td>
                <td width="10%">付款金额</td>
                <td width="10%">支付方式</td>
                <td width="10%">发货方式</td>
                <td width="20%">下单时间</td>
                <td width="10%">订单状态</td>
                <td colspan='2' width="10%">操作</td>
            </tr>
            <%
                List<Order> orderList=(ArrayList<Order>)request.getAttribute("orderlist");
	            for(Order order:orderList){
            %>
            <tr>
                <td><a href="orderDetail.do?orderID=<%=order.getOrderID()%>"><%=order.getOrderID()%></a></td>
                <td><%=order.getAccount()%></td>
                <td><%=order.getTotal()%></td>
                <td><%=order.getPaymentWay()%></td>
                <td><%=order.getDeliverWay()%></td>
                <td><%=order.getOrderTime()%></td>
                <td><%=order.getOrderState()%></td>
                <td><a href="orderDetail.do?orderID=<%=order.getOrderID()%>">修改<span class="iconfont icon">&#xe607;</span></a></td>
                <td><a href="deleteOrder.do?orderID=<%=order.getOrderID()%>" onclick='return confirm("确定删除");'>删除<span class="iconfont icon">&#xe69b;</span></a></td>
            </tr>
            <%
                }
            %>
        </table>
    </main>
</body>

</html>