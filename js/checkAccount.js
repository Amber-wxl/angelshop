window.addEventListener('load', checkAccount); //页面加载完时执行
function checkAccount() {
    var cookies = document.cookie;
    if (cookies.length > 0) {
        var startPos = cookies.indexOf('account=');
        if (startPos != -1) {
            var endPos = cookies.indexOf(';', startPos);
            if (endPos == -1) {
                endPos = cookies.length;
            }
            var account = cookies.substring(startPos + 'account='.length, endPos);
            var span = document.getElementsByTagName('nav')[0].getElementsByTagName('span')[0];
            span.innerHTML = "Hi!&nbsp;" + account + "&nbsp;&nbsp;<button type='button' onclick='logout();'><span class='iconfont exit'>&#xe6cb;</button>";
        }
    }
}

function logout() {
    document.cookie = "account=; expires=Thu, 01 Jan 1970 00:00:00 GMT;path=/angelshop";
    document.cookie = "pwd=; expires=Thu, 01 Jan 1970 00:00:00 GMT;path=/angelshop";
    //  alert(event.target.parentNode.parentNode.tagName)
    //  event.target.parentElement.innerHTML="<a href='login.html'>登录</a>|<a href='register.html'>注册</a>";
    event.target.parentNode.parentNode.innerHTML = "<a href='login.html'>登录</a>|<a href='register.html'>注册</a>";

}