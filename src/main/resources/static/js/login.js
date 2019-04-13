$(document).ready(function () {
    $("#btn_login").click( function(){
        var id=$("#id").val();
        var password=$("#password").val();

        //登录点击按钮生成cookie，stuID
        setCookie('stuID',id,1);
        $.ajax({
            type: 'POST',
            url: "http://39.108.37.4:9090/logIn",
            contentType: "application/json;charset=utf-8",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
            data: JSON.stringify({
                "id": id,
                "password": password
            }),
            dataType: "JSON",
            success: function (result) {
                console.log(result);
                switch(result.msg){
                    case -2:
                        alert("密码输入错误");
                        break;
                    case -1:
                        alert("用户不存在，请注册");
                        break;
                    case 0:
                        window.location.href="http://39.108.37.4:9090/index.html";
                        break;
                    case 1:
                        window.location.href="http://39.108.37.4:9090/stuIndex.html";
                        break;
                };
            },
            error: function (err) {
                alert("err");
            }
        });
    });
});






