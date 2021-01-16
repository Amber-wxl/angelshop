window.addEventListener('load', checkAdmin); //页面加载完时执行
function checkAdmin() {
    var cookies = document.cookie;
    if (cookies.length > 0) {
        var startPos = cookies.indexOf('adminID=');
        if (startPos != -1) {
            var endPos = cookies.indexOf(';', startPos);
            if (endPos == -1) {
                endPos = cookies.length;
            }
            var adminID = cookies.substring(startPos + 8, endPos);
            var span = document.getElementsByTagName("header")[0].getElementsByTagName("span")[0];
            span.innerHTML = adminID + "&nbsp;&nbsp;管理员，您好~";
        } else {
            location.href = 'http://localhost:8080/angelshop/manage.html';
        }
    } else {
        location.href = 'http://localhost:8080/angelshop/manage.html';
    }
}