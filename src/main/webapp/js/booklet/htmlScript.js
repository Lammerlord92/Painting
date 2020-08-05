$(document).ready(function(){
    $("#book").booklet({
        width:1000, 
        height:750,
        closed:1,
        covers:1,
        hoverWidth:75,
    });   
    $("#prev").click(function () {
        $("#book").booklet("prev");
     });   
     $("#next").click(function () {
         $("#book").booklet("next");
     });   
     $("#searchButton").click(function () {
         $("#book").booklet("gotopage",$("#searchPage").val());
     });  
})