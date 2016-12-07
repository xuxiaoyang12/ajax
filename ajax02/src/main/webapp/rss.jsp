<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/6
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button id="btn">onclick pull</button>
    <span id="result"></span>
    <script>
        (function(){
            //获取按钮
            var btn = document.querySelector("#btn");
            //点击按钮
            btn.onclick=function(){
                //获取ajax引擎
                var xmlHttp = new XMLHttpRequest();
                //获取请求方式和请求地址
                xmlHttp.open("get","/rss.xml");
                //设置回调函数
                xmlHttp.onreadystatechange = function(){
                    //接收servlet返回值 并解析在网页上显示
                    //获取服务器状态吗
                    var state = xmlHttp.readyState;
                    if(state == 4) {
                        //获取http状态吗
                        if(xmlHttp.status==200){
                            //获取服务端返回值
                            var xmlDoc = xmlHttp.responseXML;
                            alert(xmlDoc);

                            document.querySelector("#result").innerText=xmlDoc;
                        }

                    }



                }
                //发送请求
                xmlHttp.send();



            }






        })();



    </script>

</body>
</html>
