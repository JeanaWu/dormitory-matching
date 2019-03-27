$(document).ready(function () {
    $("#btn_signUp").click( function(){
        var id = $("#id").val();
        var name = $("#name").val();//获取表单的输入值;
        var password = $("#password").val();//获取表单的输入值;
        var birth=$("#birth").val() == "" ? null : $("#birth").val();
        var gender=$('input[name="gender"]:checked').val();
        var college=$("#college").find("option:selected").text();
        var department=$("#department").find("option:selected").text();

        $.ajax({
            type: 'POST',
            url: "http://localhost:9090/signup",
            contentType: "application/json",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
            data: JSON.stringify({
                "name": name,
                "id": parseInt(id),
                "password": password,
                "birth": birth,
                "gender": parseInt(gender),
                "college": college,
                "department": department

            }),
            dataType: "JSON",

            success: function(result) {
                alert(result.msg)
            },

            error:function(err){
                alert(err.msg)
            }
        });
    });
});
