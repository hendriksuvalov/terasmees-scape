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

$(window).load(function() {
    $("#iframe").prepend(function(index){
        $(this).attr('src') = "https://www.youtube.com/embed/N-16vyMIRk8"
    })
})