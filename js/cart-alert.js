function popBox() {
    var cookies=document.cookie;
    if (cookies.length>0 ){       
    var startPos=cookies.indexOf('account=');
    if(startPos!=-1){
        
        var popBox = document.getElementById("popBox");
        var popLayer = document.getElementById("popLayer");
        popBox.style.display = "block";
        popLayer.style.display = "block";

    }else{
        var warn = document.getElementById("warn");
        var popLayer = document.getElementById("popLayer");
        popBox.style.display = "block";
        popLayer.style.display = "block";
    }
};

/*点击关闭按钮*/
function toshop(type) {
    window.open('http://localhost:8080/angelshop/listClothesByType.do?type='+type);
}
function toorder(){
    window.open('http://localhost:8080/angelshop/order.do');
}