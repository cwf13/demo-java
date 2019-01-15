package cooc.demo.controller;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class DemoWM {

    /*static final WebClient webClient = new WebClient();*/

    //*********************************下单*************************************************//
    public static void main(String[] args) throws Exception {

        String token = "mnm7hqrksy0h5l0i0bylgnj0oy3h8djx";
        String postUrl = "http://rain.wmpayinc.com:8086/Pay_Index.html";
        Map<String, String> res = new HashMap<>();
        String pay_bankcode = "904";
        String pay_memberid = "10004";//商户id
        String pay_orderid = new Date().getTime() + "666666";//20位订单号 时间戳+6位随机字符串组成
        String pay_applydate = new Date().getTime() + "";//yyyy-MM-dd HH:mm:ss
        String pay_notifyurl = "www.baidu.com";//通知地址
        String pay_callbackurl = "www.baidu.com";//回调地址
        String pay_amount = "10";
        String pay_attach = "";
        String pay_productname = "904";
//        String pay_productnum = "";
//        String pay_productdesc = "";
//        String pay_producturl = "";
        String stringSignTemp = "pay_amount=" + pay_amount + "&pay_applydate=" + pay_applydate + "&pay_bankcode=" + pay_bankcode + "&pay_callbackurl=" + pay_callbackurl + "&pay_memberid=" + pay_memberid + "&pay_notifyurl=" + pay_notifyurl + "&pay_orderid=" + pay_orderid + "&key=" + token + "";
        String pay_md5sign = md5(stringSignTemp);

        res.put("pay_memberid", pay_memberid);
        res.put("pay_orderid", pay_orderid);
        res.put("pay_applydate", pay_applydate);
        res.put("pay_bankcode", pay_bankcode);
        res.put("pay_notifyurl", pay_notifyurl);
        res.put("pay_amount", pay_amount);
        res.put("pay_callbackurl", pay_callbackurl);
        res.put("pay_productname", pay_productname);
//        res.put("pay_productnum", pay_productnum);
//        res.put("pay_productdesc", pay_productdesc);
        res.put("pay_md5sign", pay_md5sign);
//        res.put("pay_producturl", pay_producturl);

        String data = "<html><head>" +
                "<script type='text/javascript'>" +
                "window.onload=function(){  document.getElementById('myform').submit(); } " +
                "</script></head><body>请进行付款，静心等待！" +
                "<form action='" + postUrl + "' id='myform' method='post'>" +
                "<input type='text' name='pay_memberid' value='" + pay_memberid + "'>" +
                "<input type='text' name='pay_orderid' value='" + pay_orderid + "'>" +
                "<input type='text' name='pay_applydate' value='" + pay_applydate + "'>" +
                "<input type='text' name='pay_bankcode' value='" + pay_bankcode + "'>" +
                "<input type='text' name='pay_notifyurl' value='" + pay_notifyurl + "'>" +
                "<input type='text' name='pay_amount' value='" + pay_amount + "'>" +
                "<input type='text' name='pay_callbackurl' value='" + pay_callbackurl + "'>" +
                "<input type='text' name='pay_productname' value='" + pay_productname + "'>" +
                "<input type='text' name='pay_md5sign' value='" + pay_md5sign + "'>" +
                "<input type='text' name='pay_attach' value='" + pay_attach + "'>" +
                "</form> " +
                "</body></html>";
        System.out.println(data);
        String url = postUrl + "?pay_memberid=" + pay_memberid + "&pay_orderid=" + pay_orderid + "&pay_applydate=" + pay_applydate + "&pay_bankcode=" + pay_bankcode +
                "&pay_notifyurl=" + pay_notifyurl + "&pay_amount=" + pay_amount + "&pay_callbackurl=" + pay_callbackurl + "&pay_productname=" + pay_productname +
                "&pay_md5sign=" + pay_md5sign;
        System.out.println(url);
//        String url = getPostUrl(postUrl, res);
//        String result = httpPostForText(url);
        String result=HttpUtil.postWithParamsForString(postUrl,res);
        System.out.println("**********************************");
        System.out.println(result);
    }
/*

    public static String sign(Map<String, String> params, String weixinkey) {
        //按参数名asscic码排序
        List<String> names = new ArrayList<>();
        names.addAll(params.keySet());
        Collections.sort(names);
        String strSign = "";
        for (String key : names) {
            strSign += key + "=" + params.get(key) + "&";
        }
        String secret = "key=" + weixinkey;
        strSign += secret;
        return MD5.MD5Encode(strSign).toLowerCase();
    }
*/


    public static String md5(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            //字符数组转换成字符串
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString().toUpperCase();
            // 16位的加密
            //return buf.toString().substring(8, 24).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
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

    public static String getPostUrl(String url, Map<String, String> map) {
        String res = url + "?";
        for (String key : map.keySet()) {
            res += key + "=" + map.get(key) + "&";
        }
        return res.substring(0, res.length() - 1);
    }
}
