package cooc.demo.controller;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http工具类
 */
public class HttpUtil {


    /**
     * @param url 请求url
     * @param map 参数map
     */
    public static String postWithParamsForString(String url, Map<String, String> map) {
        List<NameValuePair> params = new ArrayList<>();
        for (String key : map.keySet()) {
            params.add(new BasicNameValuePair(key, map.get(key)));
        }
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        String s = "";
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
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

    public static String httpPostForText(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept-Charset", "utf-8");// 设置可消费编码格式
        // 构造请求数据 使用ContentType.APPLICATION_JSON 默认编码格式为UTF-8
        String responseContent = null; // 响应内容
        CloseableHttpResponse response = null;
        try {
            // get 请求
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, Consts.UTF_8);
            } else {
            }
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
            }
        }
        return responseContent;
    }
}