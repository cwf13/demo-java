package cooc.demo.controller;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;


public class GM {

    //*********************************下单*************************************************//
    public static void main(String[] args) throws Exception {


//        String postUrl = "http://rain.wmpayinc.com:8086/Pay_Index.html";
        TreeMap<String, String> res = new TreeMap<>();
//        String pay_bankcode = "904";


        String url = "http://154.8.184.239/order/api/pay";
        String uid = "MHO17E4SLU6FER31D9HSZV5X99PC2EUF";
        String token = "TDO8EWVSHQZSVUJB06V2XAXXB59E6BPZ";
        String outTradeNo = "201901131746011763";
        String price = "30000";
        String type = "alipay";
        String notifyUrl = "http://paytest11.6yc.com/mobile/userrech/onlinePay.do/notify/73";
        String nonceStr = "oe9KhgIyRWC9EUkDwWRuqTXPQzZxFYFK";
        String commdityName = "payment";
        res.put("uid", uid);
        res.put("outTradeNo", outTradeNo);
        res.put("price", price);
        res.put("type", type);
        res.put("notifyUrl", notifyUrl);
        res.put("nonceStr", nonceStr);
        res.put("commdityName", commdityName);
        String s = sort(res) + "key=" + token;
        System.out.println("*****************"+s.equals("commdityName=GoodsName&nonceStr=PAY110000026293&notifyUrl=http://vv.apapapay.com/xpay/callback/87307848a0b30b0c687bb8910aecf834&outTradeNo=PAY110000026293&price=1000&type=alipay&uid=CXZPR0Z7QD1BAGBKVMDE6B95OMJJ9VBG&key=JTZWXJ6N69U4RJRUIJR7OQMK7IK1X76J"));
        System.out.println("加密前" + s);
//        s="commdityName=GoodsName&nonceStr=PAY110000026293&notifyUrl=http://vv.apapapay.com/xpay/callback/87307848a0b30b0c687bb8910aecf834&outTradeNo=PAY110000026293&price=1000&type=alipay&uid=CXZPR0Z7QD1BAGBKVMDE6B95OMJJ9VBG&key=JTZWXJ6N69U4RJRUIJR7OQMK7IK1X76J";
        String sign = md5(s).toLowerCase();
        System.out.println("加密后" + sign);
        res.put("sign", sign);
        System.out.println(sign);
        String sssss = sendPost(url, JSONObject.toJSONString(res), null);
        System.out.println(sssss);


    }


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

    public static String sort(TreeMap<String, String> map) {
        String res = "";
        for (String s : map.keySet()) {
            res += s + "=" + map.get(s) + "&";
        }
        return res;
    }

    public static String sendPost(String url, String param, String ContentType) {
        String result = null;
        OkHttpClient httpClient = new OkHttpClient();
        String ContentTypea = "text/html;charset=utf-8";
        if (ContentType != null) {
            ContentTypea = ContentType;
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse(ContentTypea), param);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = httpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            return null;
        }
        return result;
    }

}
