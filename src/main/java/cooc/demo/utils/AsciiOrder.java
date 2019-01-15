package cooc.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Xiao
 * @Description //TODO
 * @Date 2018-10-09 11:07
 **/
public class AsciiOrder {

    public static String sign(Map<String, String> params, String machkey) {
        //按参数名asscic码排序
        List<String> names = new ArrayList<>();
        names.addAll(params.keySet());
        java.util.Collections.sort(names);
        String strSign = "" ;
        for (String key : names) {
            strSign += key + "=" + params.get(key) + "&" ;
        }
        String secret = "key=" + machkey;
        strSign += secret;
        System.out.println("加密前：" + strSign);
        String sign = null;
        try {
            sign = md5(strSign).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("加密后：" + sign);
        return sign;
    }

    public static String md5(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5" );
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            //字符数组转换成字符串
            StringBuffer buf = new StringBuffer("" );
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0" );
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


}
