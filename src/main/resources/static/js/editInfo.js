$(function () {
    if(getCookie('stuID')=="000000") {
        var id = location.href.substr(location.href.indexOf("#") + 1);

        $.ajax({
            type: "GET",
            url: "http://39.108.37.4:9090/edit/" + id,
            dataType: "json",
            success: function (result) {

                var college = result.college;
                var department = result.department;

                var birthdata = new Date(result.birth);
                var birthmonth = ((birthdata.getMonth() + 1).toString().length == 1) ? ("0" + (birthdata.getMonth() + 1).toString()) : ((birthdata.getMonth() + 1));
                var birthday = (birthdata.getDate().toString().length == 1) ? ("0" + birthdata.getDate()) : birthdata.getDate();
                var birth= birthdata.getUTCFullYear() + "-" + birthmonth + "-" + birthday;
                $("#id").val(id);
                $("#name").val(result.name);
                $("#password").val(result.password);
                $("#birth").attr("value",birth);
                $("input[name='gender'][value='" + result.gender + "']").attr("checked", true);
                $("#college").find("option:contains('" + college + "')").attr("selected", true);
                $("#department").find("option:contains('" + department + "')").attr("selected", true);
            }
        })
    }else {
        window.location.href="http://39.108.37.4:9090/login.html";
        alert("请先登录");
    }
});

// function getDate(nS) {
//     return new Date(parseInt(nS)).toLocaleDateString().replace(/\//g, "-");
// }


$(document).ready(function () {
 $("#btn_update").click( function(){
        var newId = $("#id").val();
        var name = $("#name").val();//获取表单的输入值;
        var password = $("#password").val();//获取表单的输入值;
        var birth = $("#birth").val();
        var gender = $('input[name="gender"]:checked').val();
        var college = $("#college").find("option:selected").text();
        var department = $("#department").find("option:selected").text();
        var id = location.href.substr(location.href.indexOf("#") + 1);
        if (checkEdit()) {
            $.ajax({
                type: 'POST',
                url: "http://39.108.37.4:9090/editInfo/" + id,
                contentType: "application/json",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
                data: JSON.stringify({
                    "id":newId,
                    "name": name,
                    "password": password,
                    "birth": birth,
                    "gender": parseInt(gender),
                    "college": college,
                    "department": department
                }),//JSON.stringify()必须有,否则只会当做表单的格式提交
                dataType: "JSON",
                success: function (result) {
                    alert(result.msg);
                    if (result.msg == "学生信息更新成功") {
                        window.location.href = "http://39.108.37.4:9090/editInfo.html#" + newId;

                    }
                    else window.location.reload();
                },
                error: function (err) {
                    alert("err");
                    window.location.href = "http://39.108.37.4:9090/editInfo.html#" + id;
                }


            });

        }

    })
});

var checkEdit = function () {
    var id = location.href.substr(location.href.indexOf("#") + 1);
    var name = $("#name").val();//获取表单的输入值;
    var password = $("#password").val();//获取表单的输入值;
    var birth = $("#birth").val();
    var gender = $('input[name="gender"]:checked').val();
    var college = $("#college").find("option:selected").text();
    var department = $("#department").find("option:selected").text();

    if (id == "" || name == "" || gender == "" || password == "" || birth == "" || college =="" || department == "") {
        alert("请填写完整信息");
        return false;
    } else {
        return true;
    }
}