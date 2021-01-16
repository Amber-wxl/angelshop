$(document).ready(function() {
    $(function() {
        $('aside>ul>li').click(function() {
            $(this).children('div').show(600).parent().siblings('li').children('div').hide(600);
        });
    });
})