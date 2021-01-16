<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Customer"%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>用户管理</title>
        <link rel="icon" href="logo.png">
        <link rel="stylesheet" href="css/manage.css">
        <link rel="stylesheet" href="css/manageProductList.css">
        <script src="js/checkAdmin.js"></script>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/aside.js"></script>
        <style>
            main table{
                position: relative;
                left: 18%;
                top: 40px;
            }
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
                            <li><a href="manageProductList.do"> 商品列表</a></li>
                            <li><a href="addProduct.html" target="_blank">添加商品</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <span>订单管理<span class="iconfont xiala">&#xe662;</span></span>
                    <div class="hide">
                        <ul>
                            <li><a href="manageOrderList.do"> 订单列表</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <span>用户管理<span class="iconfont xiala">&#xe662;</span></span>
                    <div>
                        <ul>
                            <li class="active"><a href="manageCustomerList.do"> 用户列表</a></li>
                            <li><a href="manageUserList.do">管理员列表</a></li>
                            <li><a href="" target="_blank">管理员注册</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </aside>
        <main>
            <table>
                <tr>
                    <td width="20%">用户ID</td>
                    <td width="20%">联系方式</td>
                    <td width="40%">收货地址</td>
                    <td width="20%">操作</td>
                </tr>
            <%
                List<Customer> customerList=(ArrayList<Customer>)request.getAttribute("customerlist");
	            for(Customer customer:customerList){
            %>
                <tr>
                    <td><%=customer.getAccount()%></td>
                    <td><%=customer.getPhone()%></td>
                    <td><%=customer.getAddress()%></td>
                    <td><a href="deleteCustomer.do?account=<%=customer.getAccount()%>" onclick='return confirm("确定删除该用户？");'>注销<span class="iconfont icon">&#xe69b;</span></a></td>
                </tr>
            <%
                }
            %>
        </table>
        </main>
    </body>
</html>