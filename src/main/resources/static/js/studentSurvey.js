$(function () {
    if (getCookie('stuID')) {
        var id = location.href.substr(location.href.indexOf("#") + 1);

        $.ajax({
            type: "GET",//请求方式
            url: "http://localhost:9090/survey/" + id,//地址，就是json文件的请求路径
            dataType: "json",//数据类型可以为 text xml json  script  jsonp
            success: function (result) {//返回的参数就是 action里面所有的有get和set方法的参数
                switch (result.gupTime) {
                    case 1:
                        $("#gupTime").html("晚上10点以前");
                        break;
                    case 2:
                        $("#gupTime").html("晚上10-11点");
                        break;
                    case 3:
                        $("#gupTime").html("晚上11-12点");
                        break;
                    case 4:
                        $("#gupTime").html("晚上12-凌晨1点");
                        break;
                    case 5:
                        $("#gupTime").html("凌晨1点以后");
                        break;
                }
                ;
                switch (result.slpTime) {
                    case 1:
                        $("#slpTime").html("早上7点以前");
                        break;
                    case 2:
                        $("#slpTime").html("早上7-8点");
                        break;
                    case 3:
                        $("#slpTime").html("早上8-9点");
                        break;
                    case 4:
                        $("#slpTime").html("早上9点以后");
                        break;
                }
                ;
                switch (result.slpNoisy) {
                    case 1:
                        $("#slpNoisy").html("是");
                        break;
                    case 2:
                        $("#slpNoisy").html("否");
                        break;
                }
                ;
                switch (result.slpHabits) {
                    case 1:
                        $("#slpHabits").html("浅眠");
                        break;
                    case 2:
                        $("#slpHabits").html("熟睡");
                        break;
                }
                ;
                switch (result.clean) {
                    case 1:
                        $("#clean").html("非常脏才打扫");
                        break;
                    case 2:
                        $("#clean").html("定期打扫");
                        break;
                    case 3:
                        $("#clean").html("脏了就扫");
                        break;
                }
                ;
                switch (result.games) {
                    case 1:
                        $("#games").html("玩");
                        break;
                    case 2:
                        $("#games").html("不玩");
                        break;
                }
                ;
                switch (result.atmos) {
                    case 1:
                        $("#atmos").html("安静");
                        break;
                    case 2:
                        $("#atmos").html("无所谓");
                        break;
                    case 3:
                        $("#atmos").html("吵闹");
                        break;
                }
                ;
                switch (result.characters) {
                    case 1:
                        $("#characters").html("外向");
                        break;
                    case 2:
                        $("#characters").html("内向");
                        break;
                }
                ;

            }
        });
    } else {

        window.location.href = "http://localhost:9090/login.html";
        alert("请先登录");

    }

});

