$(function () {
    if(getCookie('stuID')){
    $.ajax({
        url:"http://localhost:9090/homeInfo",
        method:"get",
        dataType: "json",
        success:function (result) {
            // var stuNum=result.stuNum;
            // var surveyNum=result.surveyNum;
            // var dormitory=result.dormitory;
            // var information=result.information;
            $("#stuNum").text(result.stuNum);
            $("#surveyNum").text(result.surveyNum);
            $("#dormitory").text(result.dormitory);
            $("#information").text(result.information);
        }

    })}else {
        window.location.href="http://localhost:9090/login.html";
        alert("请先登录");
    }
})