$(function () {
   if(getCookie('stuID')){

   }else{


    window.location.href="http://localhost:9090/login.html";}
    alert("请先登录");
});

function CheckNull() {
    var num = 0;
    $("input[type$='radio']").each(function (n) {
        if ($(this).val() == "") {
            num++;
        }
    });
    if (num > 0) {
        return true;
    }
    else {
        return false;
    }
};


var saveSurvey=function () {
    var slpTime=$('input[name="slpTime"]:checked').val();
    var gupTime=$('input[name="gupTime"]:checked').val();
    var slpNoisy=$('input[name="slpNoisy"]:checked').val();
    var slpHabits=$('input[name="slpHabits"]:checked').val();
    var clean=$('input[name="clean"]:checked').val();
    var games=$('input[name="games"]:checked').val();
    var atmos=$('input[name="atmos"]:checked').val();
    var characters=$('input[name="characters"]:checked').val()

    var id = getCookie('stuID');


    //判断信息是否完整填写，完整则执行ajax
    if(check()==true) {


        $.ajax({
            type: 'POST',
            url: "http://localhost:9090/addSurvey",
            contentType: "application/json;charset=utf-8",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
            data: JSON.stringify({
                "id": parseInt(id),
                "slpTime": parseInt(slpTime),
                "gupTime": parseInt(gupTime),
                "slpNoisy": parseInt(slpNoisy),
                "slpHabits": parseInt(slpHabits),
                "clean": parseInt(clean),
                "games": parseInt(games),
                "atmos": parseInt(atmos),
                "characters": parseInt(characters)
            }),
            dataType: "JSON",
            success: function (result) {
                alert(result.msg);
            },
            error: function (err) {

            }
        });
    }


};

var check=function () {
    var slpTime=$('input[name="slpTime"]:checked').val();
    var gupTime=$('input[name="gupTime"]:checked').val();
    var slpNoisy=$('input[name="slpNoisy"]:checked').val();
    var slpHabits=$('input[name="slpHabits"]:checked').val();
    var clean=$('input[name="clean"]:checked').val();
    var games=$('input[name="games"]:checked').val();
    var atmos=$('input[name="atmos"]:checked').val();
    var characters=$('input[name="characters"]:checked').val()

    if(slpTime==null||gupTime==null||slpNoisy==null||slpHabits==null||clean==null||games==null||atmos==null||characters==null){
        alert("问卷没有填写完整");
        return false;
    }
    return true;
}


function getCookie(c_name) {
    var that = this;
    if (document.cookie.length > 0) {
        //检查这个cookie是否存在，不存在就为 -1
    var  c_start = document.cookie.indexOf(c_name + "=")
        if (c_start !=-1) {
            //获取cookie值的开始位置
            c_start = c_start + c_name.length + 1;
            //通过";"号是否存在来判断结束位置
         var c_end = document.cookie.indexOf(";", c_start);

            if (c_end == -1){
                c_end = document.cookie.length;
            }
            //通过substring()得到了值
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}
