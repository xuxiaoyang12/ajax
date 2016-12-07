<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/6
  Time: 17:40
  To change this template use File | Settings | File Templates.
  词典  翻译
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="text" id="word">
    <button id="btn">query</button>
    <p id="result"></p>
    <script>
        (function(){

            //获取点击事件
            document.querySelector("#btn").onclick=function(){
                //获取文本框的值
                var word = document.querySelector("#word").value;
                //创建ajax引擎
                var xmlHttp = new XMLHttpRequest();
                //设置请求方式和请求地址
                xmlHttp.open("get","/dic?word="+word);
                //设置回调函数
                xmlHttp.onreadystatechange = function(){
                    //获取服务器状态码
                    var code = xmlHttp.readyState;
                    if(code==4){
                        //获取http状态吗
                        var status = xmlHttp.status;

                        if(status==200){
                            //获取服务端返回值(xml);
                            var xmlDoc = xmlHttp.responseXML;
                            //获取返回值中的errorCode标签的值
                            var errorCode = xmlDoc.getElementsByTagName("errorCode")[0].childNodes[0].nodeValue[0];
                            if(errorCode==0){
                                //获取返回值中ex标签
                                var ex = xmlDoc.getElementsByTagName("ex")[0].childNodes[0].nodeValue;
                                //获取id为result的标签并设置值
                                document.querySelector("#result").innerText = ex;
                            }else{
                                alert("errorCode"+errorCode);
                            }
                        }


                    }else{
                        throw new RuntimeException("服务器异常"+xmlHttp.readyState);
                    }
                }
                xmlHttp.send();
            }

        })();

    </script>

</body>
</html>
