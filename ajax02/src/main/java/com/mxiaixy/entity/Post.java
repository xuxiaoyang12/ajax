package com.mxiaixy.entity;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mxia on 2016/12/7.
 */
public class Post {

    public static void main(String[] args) throws IOException {


        CloseableHttpClient httpClient = HttpClients.createDefault();

        //HttpPost httpPost = new HttpPost("http://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1481042418228_R&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word="+key);
        HttpGet httpGet = new HttpGet("");
       // List<NameValuePair> params = new ArrayList<>();
        //params.add(new BasicNameValuePair());

       // httpPost.setEntity(new UrlEncodedFormEntity(params));
        //发出请求
        //httpClient.execute(httpPost);
        httpClient.execute(httpGet);

    }
}
