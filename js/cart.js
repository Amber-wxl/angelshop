function addToCart(clotheID, clotheName) {
    var cookies = document.cookie;
    if (cookies.length > 0) {
        var startPos = cookies.indexOf('account=');
        if (startPos != -1) {
            window.open('http://localhost:8080/angelshop/addToCart.do?clotheID=' + clotheID + '&clotheName=' + clotheName);
        }
    } else {
        location.href = "http://localhost:8080/angelshop/login.html";
    }
}

function listCart() {
    var cookies = document.cookie;
    if (cookies.length > 0) {
        var startPos = cookies.indexOf('account=');
        if (startPos != -1) {
            window.open('http://localhost:8080/angelshop/listCart.do');
        }
    } else {
        location.href = "http://localhost:8080/angelshop/login.html";
    }
}
var xmlHttp;
var countSpan;
var totalSpan;
window.addEventListener('load', init);

function init() {
    countSpan = document.getElementById("count");
    totalSpan = document.getElementById("total");
    // 遍历class="remove"的元素，并添加click事件，当发生click事件时，执行removeFromCart函数
    var removeButtons = document.getElementsByClassName("remove");
    for (let i = 0; i < removeButtons.length; i++) {
        removeButtons[i].addEventListener('click', removeFromCart);
    }
    // 遍历class="select-product"的元素，并添加click事件，当发生click事件时，执行toggleSelect函数
    var checkButtons = document.getElementsByClassName("select-product");
    for (let i = 0; i < checkButtons.length; i++) {
        checkButtons[i].addEventListener('click', toggleSelect);
    }
    // 遍历class="down"的元素，并添加事件，当发生click事件时，执行downQuantity函数;
    // 当发生mouseover事件时，执行setQuantityBeforeMouseover函数；
    // 当发生mouseout事件时，执行updateCartAfterMouseout函数
    var downButtons = document.getElementsByClassName("down");
    for (let i = 0; i < downButtons.length; i++) {
        downButtons[i].addEventListener('click', downQuantity);
        downButtons[i].addEventListener('mouseover', setQuantityBeforeMouseover);
        downButtons[i].addEventListener('mouseout', updateCartAfterMouseout);
    }
    // 遍历class="edit-quantity"的元素，并添加事件，当发生change事件时，执行updateCart函数;
    var editQuantityTexts = document.getElementsByClassName("edit-quantity");
    for (let i = 0; i < editQuantityTexts.length; i++) {
        editQuantityTexts[i].addEventListener('change', updateCart);
    }
    // 遍历class="up"的元素，并添加事件，当发生click事件时，执行upQuantity函数;
    // 当发生mouseover事件时，执行setQuantityBeforeMouseover函数；
    // 当发生mouseout事件时，执行updateCartAfterMouseout函数
    var upButtons = document.getElementsByClassName("up");
    for (let i = 0; i < upButtons.length; i++) {
        upButtons[i].addEventListener('click', upQuantity);
        upButtons[i].addEventListener('mouseover', setQuantityBeforeMouseover);
        upButtons[i].addEventListener('mouseout', updateCartAfterMouseout);
    }
}
//当用户点击"删除"按钮时，弹出警告框
function removeFromCart() {
    if (!confirm("您确定要删除商品吗？")) {
        //取消则退出该操作
        return;
    }
    var clotheID = this.getAttribute("clotheid");
    var url = "/angelshop/deleteFromCart.do?clotheID=" + clotheID;
    //创建XMLHttpRequest对象
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url);
    xmlHttp.onreadystatechange = function() {
        remove(clotheID);
    }
    xmlHttp.send(null);
}
//从购物车中删除
function remove(clotheID) {
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status = 200) {
            if (xmlHttp.responseText == 'success') {
                //当服务器响应的值为success
                var quantityText = document.getElementById(clotheID);
                var quantity = quantityText.value;
                var siteprice = quantityText.dataset.siteprice;
                quantityText.parentElement.parentElement.remove();
                var subtotal = quantity * siteprice;
                updateCount(-quantity); //更新count值
                updateTotal(-subtotal); //更新total值
            } else {
                alert("从购物车中删除商品失败");
            }
        }
    }
}
//更新count值
function updateCount(quantity) {
    count.textContent = parseInt(count.textContent) + parseInt(quantity);
}
//更新total值
function updateTotal(subtotal) {
    total.textContent = (parseFloat(total.textContent) + parseFloat(subtotal)).toFixed(2);
}
//切换复选框状态
function toggleSelect() {
    var clotheID = event.target.value;
    var quantityText = document.getElementById(clotheID);
    var quantity = quantityText.value;
    var siteprice = quantityText.dataset.siteprice;
    var subtotal = (quantity * siteprice).toFixed(2);
    var subtotalTd = document.getElementById(clotheID + 'total');
    if (event.target.checked == false) {
        subtotalTd.textContent = 0.00;
        updateCount(-quantity);
        updateTotal(-subtotal);
    } else {
        subtotalTd.textContent = subtotal;
        updateCount(quantity);
        updateTotal(subtotal);
    }
}
//减少数量
function downQuantity() {
    var clotheID = this.getAttribute("clotheid");
    var quantityText = document.getElementById(clotheID);
    if (quantityText.value == 1) {
        //当数量为1时，再执行该函数则应该删除商品
        if (!confirm("您确定要删除商品吗？")) {
            //取消则退出该操作
            exit;
        } else {
            var url = "/angelshop/deleteFromCart.do?clotheID=" + clotheID;
            xmlHttp = new XMLHttpRequest();
            xmlHttp.open("GET", url);
            xmlHttp.onreadystatechange = function() {
                remove(clotheID);
            }
            xmlHttp.send(null);
        }
    } else {
        quantityText.value = quantityText.value - 1;
        quantityText.dataset.prevalue = quantityText.dataset.prevalue - 1;
        var siteprice = quantityText.dataset.siteprice;
        var subtotalTd = document.getElementById(clotheID + 'total');
        subtotalTd.textContent = (subtotalTd.textContent - siteprice).toFixed(2);
        updateCount(-1);
        updateTotal(-siteprice);
    }
}
//当鼠标在数量区域时，将countBeforeUpdate属性设置为修改数量之前的数量
function setQuantityBeforeMouseover() {
    var clotheID = this.getAttribute("clotheid");
    var quantityText = document.getElementById(clotheID);
    quantityText.dataset.countBeforeUpdate = quantityText.value;
}
//当鼠标移出数量区域时，将quantity值设置为当前文本框的值
function updateCartAfterMouseout() {
    var clotheID = this.getAttribute("clotheid");
    var quantityText = document.getElementById(clotheID);
    var quantity = quantityText.value
    if (quantity == quantityText.dataset.countBeforeUpdate) {
        return;
    }
    var url = "/angelshop/updateCart.do?clotheID=" + clotheID + "&quantity=" + quantity;
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url);
    xmlHttp.onreadystatechange = function() {}
    xmlHttp.send(null);
}
//更新数量
function updateCart() {
    var quantityText = event.target;
    var clotheID = quantityText.id;
    var quantity = quantityText.value
    var url = "/angelshop/updateCart.do?clotheID=" + clotheID + "&quantity=" + quantity;
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url);
    xmlHttp.onreadystatechange = function() { refreshCart(clotheID); }
    xmlHttp.send(null);
}
//更新购物车
function refreshCart(clotheID) {
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status = 200) {
            if (xmlHttp.responseText == 'success') {
                var quantityText = document.getElementById(clotheID);
                var incrementCount = quantityText.value - quantityText.dataset.prevalue;
                var incrementSubtotal = incrementCount * quantityText.dataset.siteprice;
                quantityText.dataset.prevalue = quantityText.value;
                var subtotalTd = document.getElementById(clotheID + 'total');
                subtotalTd.textContent = (quantityText.value * quantityText.dataset.siteprice).toFixed(2);
                updateCount(incrementCount);
                updateTotal(incrementSubtotal);
            } else {
                alert("更新数量失败");
            }
        }
    }
}
//增加数量
function upQuantity() {
    var clotheID = this.getAttribute("clotheid");
    var quantityText = document.getElementById(clotheID);
    quantityText.value = parseInt(quantityText.value) + 1;
    quantityText.dataset.prevalue = quantityText.dataset.prevalue + 1;
    var siteprice = quantityText.dataset.siteprice;
    var subtotalTd = document.getElementById(clotheID + 'total');
    subtotalTd.textContent = (parseFloat(subtotalTd.textContent) + parseFloat(siteprice)).toFixed(2);
    updateCount(1);
    updateTotal(siteprice);
}