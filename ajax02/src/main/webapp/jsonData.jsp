<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/6
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button id="btn">read json</button>
    <script>
        (function(){
            document.querySelector("#btn").onclick = function(){
                //设置ajax引擎
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("get","/date.json");
                xmlHttp.onreadystatechange = function(){
                    //获取服务端的返回的状态码
                    var code = xmlHttp.readyState;
                    //获取Http的状态吗
                    var status = xmlHttp.status;
                    if(code==4){
                        if (status==200){
                            //获取服务端返回的值
                            var result = xmlHttp.responseText;
                            //把返回的字符串转换成json;   JSON是javascript的内置对象
                            var json = JSON.parse(result);//返回的是json数组
                                alert(json.length);
                            for(var i = 0 ; i <json.length;i++ ){
                                var user = json[i];
                                alert(user.id+" -> "+user.name+" -> "+ user.address);
                            }
                        }
                    }
                }
                xmlHttp.send();
            }
        })();

    </script>

</body>
</html>
