package cooc.demo.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpU {

    public static void main(String[] args) {

        String url = "http://localhost/test" ;
        Map<String, String> map = new HashMap<>();
        map.put("str" , "测试1" );
        map.put("str2" , "测试2" );
        String res = postWithParamsForString(url, map);
        System.out.println(res);
    }

    public static String postWithParamsForString(String url, Map<String, String> map) {
        List<NameValuePair> params = new ArrayList<>();
        for (String key : map.keySet()) {
            params.add(new BasicNameValuePair(key, map.get(key)));
        }
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        String s = "" ;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8" ));
            httpPost.setHeader("Content-type" , "application/x-www-form-urlencoded" );
            HttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                s = EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}