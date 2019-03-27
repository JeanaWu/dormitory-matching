$("#logout").click(function () {
    clearCookie('stuID');
    alert("用户退出");
});



$("#id").text("学号:"+getCookie('stuID'));

//删除cookie
function clearCookie(name) {
    setCookie(name, "", -1);
}

//设置cookie
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires + "; path=/";//path=/是根路径
}

//获取Cookie
function getCookie(c_name) {
    var that = this;
    if (document.cookie.length > 0) {
        //检查这个cookie是否存在，不存在就为 -1
        var c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            //获取cookie值的开始位置
            c_start = c_start + c_name.length + 1;
            //通过";"号是否存在来判断结束位置
            var c_end = document.cookie.indexOf(";", c_start);

            if (c_end == -1) {
                c_end = document.cookie.length;
            }
            //通过substring()得到了值
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
};