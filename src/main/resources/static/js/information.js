$(function () {
    if (getCookie('stuID')) {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();
    } else {
        window.location.href = "http://localhost:9090/login.html";
        alert("请先登录");
    }
});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#information').bootstrapTable({
            url: 'http://localhost:9090/allInformation',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable:  false,                     //是否启用排序
            sortOrder: "ASC",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 8,                       //每页的记录行数（*）
            pageList: [8, 16, 24, 32],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect:false,                //是否启用点击选中行
            // height: 680,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "num",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                field: 'date',
                title: '发布日期',
                 formatter:function(value,row){
                     return new Date(value).toLocaleDateString().replace(/\//g, "-") + " " + new Date(value).toTimeString().substr(0, 8);
                 },
                width: '150px'
            },{
                field: 'content',
                title: '内容',
                width:'700px'
            }, {
                field:'num',
                title:'操作',
                formatter:function (value) {
                    // return " <button onclick=\'deleteInfo(\"" + value + "\")\' type='button' class='btn-default btn'>删除</button>"
                    return " <button onclick=\'deleteInfo(" + value + ")\' type='button' class='btn-default btn'>删除</button>"
                },
                width: '50px'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var map= {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            room: $("#txt_search_room").val(),
            // statu: $("#txt_search_statu").val()
        };
        return map;
    };
    return oTableInit;
};



var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        $("#btn_query").click(function () {
            $("#information").bootstrapTable('refresh');
        });
    };

    return oInit;
};




$(document).ready(function () {
    $("#btn_public").click(function () {
        var myDate=new Date();
        var date=myDate.toLocaleString( 'chinese',{hour12:false});        //获取日期与时间
        var  content=$("#content").val();
        $.ajax({
            type: 'POST',
            url: "http://localhost:9090/Information",
            contentType: "application/json",//如果想以json格式把数据提交到后台的话，这个必须有，否则只会当做表单提交
            data: JSON.stringify({
                "date": date,
                "content": content
            }),
            dataType: "JSON",
            success:function (result) {
                alert(result.msg);
                $("#information").bootstrapTable('refresh');
                $("#content").val("");
            },
            error:function (err) {
                alert("发布失败")

            }
        })
    });

});

var  deleteInfo = function (value) {
    $.ajax({
        url:"http://localhost:9090/deleteInformation",
        method:'POST',
        contentType: "application/json;charset=utf-8",
        data:JSON.stringify({
            "num":value
        }),
        dataType:"JSON",
        success:function (result) {
            alert(result.msg);
            $("#information").bootstrapTable('refresh');
        }
    })

};

