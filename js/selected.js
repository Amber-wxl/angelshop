$(document).ready(function() {
    var origin = $("#origin").data("origin");
    for (var i = 0; i <= $("#origin option").length; i++) {
        if ($("#origin option:nth-of-type(" + i + ")").text() == origin) {
            $("#origin option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});
$(document).ready(function() {
    var style = $("#style").data("style");
    for (var i = 0; i <= $("#style option").length; i++) {
        if ($("#style option:nth-of-type(" + i + ")").text() == style) {
            $("#style option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});
$(document).ready(function() {
    var color = $("#color").data("color");
    for (var i = 0; i <= $("#color option").length; i++) {
        if ($("#color option:nth-of-type(" + i + ")").text() == color) {
            $("#color option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});
$(document).ready(function() {
    var deliveryTime = $("#deliveryTime").data("deliverytime");
    for (var i = 0; i <= $("#deliveryTime option").length; i++) {
        if ($("#deliveryTime option:nth-of-type(" + i + ")").text() == deliveryTime) {
            $("#deliveryTime option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});

$(document).ready(function() {
    var type = $("#type").data("type");
    for (var i = 0; i <= $("#type option").length; i++) {
        if ($("#type option:nth-of-type(" + i + ")").text() == type) {
            $("#type option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});

$(document).ready(function() {
    var paymentWay = $("#paymentWay").data("paymentway");
    for (var i = 0; i <= $("#paymentWay option").length; i++) {
        if ($("#paymentWay option:nth-of-type(" + i + ")").text() == paymentWay) {
            $("#paymentWay option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});

$(document).ready(function() {
    var deliverWay = $("#deliverWay").data("deliverway");
    for (var i = 0; i <= $("#deliverWay option").length; i++) {
        if ($("#deliverWay option:nth-of-type(" + i + ")").text() == deliverWay) {
            $("#deliverWay option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});


$(document).ready(function() {
    var orderState = $("#orderState").data("orderstate");
    for (var i = 0; i <= $("#orderState option").length; i++) {
        if ($("#orderState option:nth-of-type(" + i + ")").text() == orderState) {
            $("#orderState option:nth-of-type(" + i + ")").attr('selected', 'selected');
        }
    }
});