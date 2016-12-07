<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/7
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>调用ajax工具类</title>
</head>
<body>
<input type="text" id="key">
<span id="text"></span>
<!-- 导入ajax工具类 -->
<script src="/js/ajax.js"></script>
<script>
    (function(){
        //失去焦点时验证
        document.querySelector("#key").onblur= function(){
            //获取文本框的值
            var name = this.value;
            alert(name)
            //调用ajax引擎验证
            ajax.sendpost("/jqueryAjax","name="+name+"&age=23",function(data) {
                alert(data);


            })




        }



    })();

</script>


</body>
</html>
