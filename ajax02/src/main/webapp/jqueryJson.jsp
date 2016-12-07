<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/6
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON</title>
</head>
<body>

    <button id="btn">json</button>

    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script>
       // $(document).ready(function(){
       (function(){
           //获取点击事件
            document.querySelector("#btn").onclick = function(){
                //获取ajax引擎
                var xmlHttp = new XMLHttpRequest();
                //设置请求地址和请求方式
                xmlHttp.open("get","/date.json");
                //设置回调函数
                xmlHttp.onreadystatechange = function(){
                    //获取服务端的状态码
                    if(xmlHttp.readyState==4){
                        //获取http的状态码
                        if(xmlHttp.status==200){
                            //获取服务端的返回json
                            var xmlDoc = xmlHttp.responseText;
                            //alert(xmlDoc.length)//用来判断xmlDoc 是否为json格式
                            //将字符串转换成json
                            var json = JSON.parse(xmlDoc);
                           //输出json


                        }
                    }

                }
                //发出请求
                xmlHttp.send();



            }




       })();
       // })



    </script>



</body>
</html>
