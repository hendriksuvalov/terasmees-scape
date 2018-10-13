$(document).ready(function () {
    $(".front-page-link").mouseover(function(){
        $(this).css("padding", "1.2em 0.2em")
    })
});

$(document).ready(function () {
    $(".front-page-link").mouseout(function(){
        $(this).css("padding", "1em 0")
    })
});