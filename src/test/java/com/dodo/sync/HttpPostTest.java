package com.dodo.sync;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpPostTest {
    public String post(String url, Object bean) {
        String resp = "";
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
            httpPost.setEntity(new StringEntity(JSON.toJSONString(bean), "utf-8"));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            resp = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

//    @Test
    public void ttt() throws InterruptedException {
        JSONObject object = new JSONObject();
        object.put("username", "gb");
        object.put("password", "gb2019");
        String url = "http://114.115.129.196:8096/platform/ext/token";
        String s = post(url, object);
        System.out.println(s);
    }

    @Test
    public void tttvin() {
        JSONObject object = new JSONObject();
        object.put("vin", "lhgj11810l8001617");
        object.put("jwtToken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnYiIsImV4cCI6MTU5NzgzNzE0M30.zv6BKXkR1alRohEOj9qqQX2nOi2ZnoMpFd9ESo0mgl6ajM4520D06cBF3qDWl3H4t9yidptpGoqtjCeofCeVbw");
        String url = "http://114.115.129.196:8096/platform/ext/data";
        String s = post(url, object);
        System.out.println(s);
    }
}