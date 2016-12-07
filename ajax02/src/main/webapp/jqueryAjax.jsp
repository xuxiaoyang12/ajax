<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/7
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>纯jquery</title>
</head>
<body>
<input type="text" id="key">
<span id="text"></span>

<%--引入jquery--%>
<script src="/static/js/jquery-3.1.1.min.js"></script>
<script>
    $(function(){
        //当文本框失去焦点时验证
        $("#key").blur(function(){
            //获取文本框的值
            var name = $(this).val();
            $.ajax({
                //设置请求地址
                url:"/jqueryAjax",
                //设置请求方式
               // type:"get",
                type:"post",
                //设置发送请求数据
                data:{"name": name},
                //设置回掉函数
                //成功时
                success: function(data){
                    alert(data);
                },
                //失败时
                error:function(){
                    alert("服务器异常")
                }

            })
        })
    });


</script>

</body>
</html>
