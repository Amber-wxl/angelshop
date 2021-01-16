<%@page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.List,java.util.ArrayList,gzmtu.xt.dzsw.entity.*"%>  
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理-ANGELSHOP</title>
    <link rel="icon" href="logo.png">
    <link rel="stylesheet" href="css/manage.css">
    <link rel="stylesheet" href="css/updateProduct.css">
    <script src="js/checkAdmin.js"></script>
    <script src="js/setReturnUrl.js"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/selected.js"></script>
    <script src="js/aside.js"></script>
    <style>
    img{
        width:100px;
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
                <div >
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
                        <li ><a href="manageOrderList.do"> 订单列表</a></li>
                    </ul>
                </div>
            </li>

            <li>
                <span>用户管理<span class="iconfont xiala">&#xe662;</span></span>
                <div class="hide">
                    <ul>
                        <li><a href="manageCustomerList.do"> 用户列表</a></li>
                        <li><a href="manageUserList.do" >管理员列表</a></li>
                        <li><a href="addAdmin.html" target="_blank">管理员注册</a></li>
                    </ul>
                </div>
            </li>

    </ul>
    </aside>
    <main>
    <%
     Clothes clothes=(Clothes)request.getAttribute("clothes");
    %>
        <h3>商品信息</h3>
        <form action="updateProduct.do" method="post" enctype="multipart/form-data">
            <label>货&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<%=clothes.getClotheID()%></label><input type="hidden" name="clotheID" value="<%=clothes.getClotheID()%>">
            <br>
            <label>商品名称：</label><input type="text" size="80" name="clotheName" value="<%=clothes.getClotheName()%>">
            <br>
            <label>发货地点：</label>
            <select name="origin" id="origin" data-origin="<%=clothes.getOrigin()%>">
               <option value="广东广州">广东-广州</option>
               <option value="江苏苏州">江苏-苏州</option>
               <option value="浙江温州">浙江-温州</option>
            </select>
            <br>
            <label>风&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>
            <select name="style" id="style" data-style="<%=clothes.getStyle()%>">
                <option value="公主">公主</option>
                <option value="礼服">礼服</option>
            </select>
            <br>
            <label>颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
            <select name="color" id="color" data-color="<%=clothes.getColor()%>">
                <option value="粉色">粉色</option>
                <option value="蓝色">蓝色</option>
                <option value="金色">金色</option>
                <option value="红色">红色</option>
                <option value="白色">白色</option>
                <option value="灰色">灰色</option>
                <option value="黑白">黑白</option>
                <option value="香槟色">香槟色</option>
                <option value="金黄色">金黄色</option>
                <option value="渐变色">渐变色</option>
            </select>
            <br>
            <label>发货时间：</label>
            <select name="deliveryTime" id="deliveryTime" data-deliveryTime="<%=clothes.getDeliveryTime()%>">
                <option value="当天发货" selected>当天发货</option>
                <option value="7天内发货">7天内发货</option>
                <option value="15天内发货">7天内发货</option>
            </select>
            <br>
            <label>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>
            <input type="text" name="price" value="<%=clothes.getPrice()%>">
            <br>
            <label>折&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扣：</label>
            <input type="text" name="discount" value="<%=clothes.getDiscount()%>">
            <br>
            <label>封面图片：</label>
            <img src="<%=clothes.getCover()%>">
            <input type="file" name="cover" >

            <br>
            <label>所属类目</label>
            <select name="type" id="type" data-type="<%=clothes.getType()%>">
                <option value="长款服装" selected='selected'>长款服装</option>
                <option value="短款服装">短款服装</option>
                <option value="汉服旗袍">汉服旗袍</option>
                <option value="皇冠">皇冠</option>
                <option value="发箍">发箍</option>
                <option value="礼帽">礼帽</option>
                <option value="裙撑">裙撑</option>
                <option value="披肩">披肩</option>
                <option value="权杖">权杖</option>
                <option value="耳环">耳环</option>
                <option value="颈链">颈链</option>
            </select>
            <br>
            <label>详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：</label>
            <textarea  cols="80" rows="5" name="content"><%=clothes.getContent()%></textarea>
            <br>
            <input type="hidden" name="returnUrl">
            <input type="submit" value="提交">
        </form>
    </main>
</body>

</html>