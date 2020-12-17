$(document).ready(function() {
    $(".type01").click(function() {
        $(".type01").animate({
            height: "150px"
        })
        $(".type01 li").css("display", "block")
    })
    $(".type01").mouseleave(function() {
        $(".type01").animate({
            height: "30px"
        }, "slow")
        $(".type01 li").css("display", "none")
    })

    $(".type02").click(function() {
        $(".type02").animate({
            height: "150px"
        })
        $(".type02 li").css("display", "block")
    })
    $(".type02").mouseleave(function() {
        $(".type02").animate({
            height: "30px"
        }, "slow")
        $(".type02 li").css("display", "none")
    })

    $(".type03").click(function() {
        $(".type03").animate({
            height: "200px"
        })
        $(".type03 li").css("display", "block")
    })
    $(".type03").mouseleave(function() {
        $(".type03").animate({
            height: "30px"
        }, "slow")
        $(".type03 li").css("display", "none")
    })

})