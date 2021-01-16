<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Admin"%>
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
                left: 7%;
                top: 40px;
                width: 80%;
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
                            <li><a href="manageCustomerList.do"> 用户列表</a></li>
                            <li class="active"><a href="manageUserList.do">管理员列表</a></li>
                            <li><a href="addAdmin.html" target="_blank">管理员注册</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </aside>
        <main>
            <table>
                <tr>
                    <td width="70%">管理员账号</td>
                    <td width="40%">操作</td>
                </tr>
            <%
                List<Admin> adminList=(ArrayList<Admin>)request.getAttribute("adminlist");
	            for(Admin admin:adminList){
            %>
                <tr>
                    <td><%=admin.getAdminID()%></td>
                    <td><a href="deleteAdmin.do?adminID=<%=admin.getAdminID()%>" onclick='return confirm("确定删除该管理员？");'>注销<span class="iconfont icon">&#xe69b;</span></a></td>
                </tr>
            <%
                }
            %>
        </table>
        </main>
        
    </body>
</html>