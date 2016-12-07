var ajax = {};
//网ajax对象中设置函数  并传入三个参数
ajax.sendpost = function( url,data,fn){
    //设置ajax引擎
    var xmlHttp = new XMLHttpRequest();
    //设置请求凡是和请求地址
    xmlHttp.open("post",url);
    //设置MIME TYPE
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    //设置回调函数
    xmlHttp.onreadystatechange = function(){
        //获取服务端状态吗
        if(xmlHttp.readyState==4){
            //获取http状态吗
            if(xmlHttp.status==200){
                //获取服务端返回值
                var xmlDoc = xmlHttp.responseText;
                //吧结果传给函数
                fn(xmlDoc);


            }
        }
    }

    //发送请求
    xmlHttp.send(data);



}