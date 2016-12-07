package com.mxiaixy.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mxia on 2016/12/6.
 */
public class HttpUtil {

    public static String sendHttpGetRequest(String url){

        //创建一个可以发送请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个get请求方式
        HttpGet httpGet = new HttpGet(url);

        try {
            //发送请求并且接受服务端的响应
            HttpResponse response = httpClient.execute(httpGet);
            //获取服务器的状态码
            int stateCode = response.getStatusLine().getStatusCode();
            if(stateCode==200){
                //如果状态吗是200表示相应正常
                //获取响应输入流
                InputStream inputStream = response.getEntity().getContent();
                //转换成字符串  并且字符编码设置成UTF-8
                String  result = IOUtils.toString(inputStream,"UTF-8");
                inputStream.close();
                httpClient.close();
                return result;

            }else{

                throw new RuntimeException("请求"+url+"异常"+response.getStatusLine().getStatusCode());
            }




        } catch (IOException e) {
            throw new RuntimeException("请求"+url+"异常",e);
        }


    }
}
