<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.Clothes"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理</title>
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
                <div>
                    <ul>
                        <li class="active"><a href="manageProductList.do"> 商品列表</a></li>
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
                <div class="hide">
                    <ul>
                        <li><a href="manageUserList.do"> 用户列表</a></li>
                        <li><a href="" >管理员列表</a></li>
                        <li><a href="" target="_blank">管理员注册</a></li>
                    </ul>
                </div>
            </li>

    </ul>
    </aside>
    <main>
        <table>
            <tr>
                <td width="10%">货号</td>
                <td width="20%">名称</td>
                <td width="15%">主图</td>
                <td width="10%">所属类目</td>
                <td width="10%">价格</td>
                <td width="10%">折扣</td>
                <td colspan="2" width="15%">操作</td>
            </tr>
            <%
                List<Clothes> clothesList=(ArrayList<Clothes>)request.getAttribute("clothesList");
	            for(Clothes clothes:clothesList){
            %>
            <tr>
                <td><a href="productDetail.do?clotheID=<%=clothes.getClotheID()%>"><%=clothes.getClotheID()%><a></td>
                <td><%=clothes.getClotheName()%></td>
                <td><img src='<%=clothes.getCover()%>'></td>
                <td><%=clothes.getType()%></td>
                <td><%=clothes.getPrice()%></td>
                <td><%=clothes.getDiscount()%></td>
                <td><a href="productDetail.do?clotheID=<%=clothes.getClotheID()%>">修改<span class="iconfont icon">&#xe607;</span></a></td>
                <td><a href="deleteProduct.do?clotheID=<%=clothes.getClotheID()%>" onclick='return confirm("确定删除?");'>删除<span class="iconfont icon">&#xe69b;</span></a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            int rows=(int)request.getAttribute("rows");
	        int curPage=(int)request.getAttribute("page");	   
	        int pageSize=(int)request.getAttribute("pageSize");
	        int pages=rows%pageSize==0?rows/pageSize:rows/pageSize+1;
	        String previous=curPage<=1?"&nbsp;&nbsp;":"<a href='manageProductList.do?page="+(curPage-1)+"'><</a>";
            String next=curPage>=pages?"&nbsp;&nbsp;":"<a href='manageProductList.do?page="+(curPage+1)+"'>></a>";
        %>
        <div class="page">
            
            <form action="manageProductList.do" method='get'>
                <label class="page-nav"><%=previous%>&nbsp;&nbsp;<%=curPage%>&nbsp;&nbsp;<%=next%></label>
                <label>共<%=pages%>页,到第</label>
                <input type='text' name='page' size='1'>
                <label>页&nbsp;&nbsp;</label>
                <input type='submit' value='前往'><span class="iconfont">&#xe61b;</span>
      </form>
      </div>
    </main>
    

</body>

</html>