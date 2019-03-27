$(function () {
    var id = location.href.substr(location.href.indexOf("#") + 1);

    $.ajax({
        type: "GET",
        url: "http://localhost:9090/edit/" + id,
        dataType: "json",
        success: function (result) {
            var date = getDate(result.birth);
            var college = result.college;
            var department = result.department;
            $("#name").val(result.name);
            $("#password").val(result.password);
            $("#birth").val(date);
            $("input[name='gender'][value='" + result.gender + "']").attr("checked", true);
            $("#college").find("option:contains('" + college + "')").attr("selected", true);
            $("#department").find("option:contains('" + department + "')").attr("selected", true);
        }
    })
});

function getDate(nS) {
    return new Date(parseInt(nS)).toLocaleDateString().replace(/\//g, "-");
}


$(document).ready(function () {
 $("#btn_update").click( function(){
        var id = location.href.substr(location.href.indexOf("#") + 1);
        var name = $("#name").val();//获取表单的输入值;
        var password = $("#password").val();//获取表单的输入值;
        var birth = $("#birth").val();
        var gender = $('input[name="gender"]:checked').val();
        var college = $("#college").find("option:selected").text();
        var department = $("#department").find("option:selected").text();

        if (checkEdit()) {
            $.ajax({
                type: 'POST',
                url: "http://localhost:9090/editInfo/" + id,
                contentType: "application/json",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
                data: JSON.stringify({
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
                },
                error: function (err) {


                }


            });
            window.location.href = "http://localhost:9090/editInfo.html#" + id;
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