package cooc.demo.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Random;

/**
 * @author cec
 * @version data：2018/6/21 09:22
 * 系统常量
 */
public class ProjectUtil {


    /**
     * ajax 返回
     *
     * @param response
     * @param msg
     * @throws IOException
     */
    public static void printMsg(HttpServletRequest request, HttpServletResponse response, String msg) throws IOException {

        //前端传过来的回调函数名称
        response.setCharacterEncoding("utf-8" );
        response.setContentType("text/plain" );
        response.getWriter().write(msg);

    }


    /**
     * 接收远程传递的post消息
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String receivePostMsg(ServletInputStream inputStream) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, "UTF-8" ));
        String line = null;
        String result = "" ;
        try {
            while ((line = input.readLine()) != null) {
                result += line + "\r\n" ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }

        return result;
    }

    /**
     * 判断String是否为空
     *
     * @param values
     * @return true or false (等于空返回true   不等于看返回false)
     */
    public static boolean stringIsNULL(String values) {

        if (values == null || "".equals(values) || "null".equals(values) || "undefined".equals(values)) {
            return true;
        }
        return false;

    }


    /**
     * 生成订单编号
     *
     * @return orderCode
     */
    public static String getorderCode() {
        String Time = TimeUtil.getNowDate("yyyyMMddHHmmSS" );
        String str = "" ;
        str += (int) (Math.random() * 9 + 1);
        for (int i = 0; i < 4; i++) {
            str += (int) (Math.random() * 10);
        }
        String uporderCode = Time + str;
        return uporderCode;
    }

    /**
     * 根据长度随机生成
     * 26英文字和0~9随机生成
     *
     * @param length
     * @return entNum
     */
    public static String getEntNumCode(int length) {
        String val = "" ;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num" ;
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = 65;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 根据长度随机生成
     * 26英文字
     *
     * @param length
     * @return entNum
     */
    public static String getEnglishCode(int length) {
        String val = "" ;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 取得大写字母还是小写字母
            int choice = 65;
            val += (char) (choice + random.nextInt(26));
        }
        return val.toLowerCase();
    }

    //测试拆包的
    public static void main(String[] args) {

        double a = 1000;
        int count = 8;
        //每包必须大于100，
        int b = 100;
        if (a < count * b) {
            System.out.println("金额对不上" );
        } else if (a == count * b) {
            System.out.println("平均每个100" );
        } else {
            //剔出小数  2000.01-2000
            double money1 = a - (int) a;
            //可随机的数值 2000-800
            int money2 = (int) a - count * b;
            for (int i = count; i > 0; i--) {

                int money3 = redNum(money2, i);
                if (i == 1) {
                    System.out.println("第" + i + "包：" + (money3 + b + money1));
                } else {
                    System.out.println("第" + i + "包：" + (money3 + b));
                }

                money2 = money2 - money3;
            }

        }
    }

    /**
     * 测试
     */
    public static int redNum(int money2, int i) {

        int max = money2 - i + 1;
        Random random = new Random();
        int a = random.nextInt(max);
        if (i == 1) {
            return max;
        } else {
            return a;
        }
    }

    /**
     * 根据长度随机生成
     * 0~9随机生成
     *
     * @param length
     * @return entNum
     */
    public static String getEntNumberCode(int length) {
        String val = "" ;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    /**
     * 1.判断是否为空
     */
    public static boolean isNull(Object obj) {
        if (obj != null && !String.valueOf(obj).equals("null" ) && !String.valueOf(obj).equals("" )) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 1.判断JSONObject是否为空
     */
    public static boolean isObjNull(JSONObject obj) {
        if (obj != null && !obj.isEmpty() && !String.valueOf(obj).equals("null" ) && !String.valueOf(obj).equals("" )) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 1.判断是否为空
     */
    public static boolean isNull(JSONObject obj, String keyname) {
        if (obj.containsKey(keyname) && obj.get(keyname) != null && !obj.get(keyname).equals("" ) && !obj.get(keyname).equals("null" )) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * JSONObject空key转为“”
     *
     * @param obj
     * @return String
     */
    public static JSONObject string_JSONObject(JSONObject obj) {

        if (!isNull(obj)) {
            Iterator keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next().toString();
                String value = obj.optString(key);
                if (stringIsNULL(value)) {
                    obj.element(key, "" );
                }

            }
        }
        return obj;

    }

    /**
     * JSONObject空key转为“”
     *
     * @param obj
     * @return String
     */
    public static JSONObject string_JSONObject2(JSONObject obj, String str) {

        if (!isNull(obj)) {
            Iterator keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next().toString();
                String value = obj.optString(key);
                if (stringIsNULL(value)) {
                    obj.element(key, str);
                } else if (value.equals("0.0" )) {
                    obj.element(key, "0.00" );
                }

            }
        }
        return obj;

    }


    /**
     * JSONArray空key转为“”
     *
     * @param array
     * @return String
     */
    public static JSONArray string_JSONArray(JSONArray array) {

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if (!isNull(obj)) {
                Iterator keys = obj.keys();
                while (keys.hasNext()) {
                    String key = keys.next().toString();
                    String value = obj.optString(key);
                    if (stringIsNULL(value)) {
                        obj.element(key, "" );
                    }

                }
            }
        }
        return array;

    }

    /**
     * JSONArray空key转为“”
     *
     * @param array
     * @return String
     */
    public static JSONArray string_JSONArray2(JSONArray array, Object objs) {

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if (!isNull(obj)) {
                Iterator keys = obj.keys();
                while (keys.hasNext()) {
                    String key = keys.next().toString();
                    String value = obj.optString(key);
                    if (stringIsNULL(value)) {
                        obj.element(key, objs);
                    }

                }
            }
        }
        return array;

    }

    //加
    public static double add(double a1, double b1) {
        BigDecimal a2 = new BigDecimal(Double.toString(a1));
        BigDecimal b2 = new BigDecimal(Double.toString(b1));
        return a2.add(b2).doubleValue();
    }

    //减
    public static double sub(double a1, double b1) {
        BigDecimal a2 = new BigDecimal(Double.toString(a1));
        BigDecimal b2 = new BigDecimal(Double.toString(b1));
        return a2.subtract(b2).doubleValue();
    }

    //乘
    public static double mul(double a1, double b1) {
        BigDecimal a2 = new BigDecimal(Double.toString(a1));
        BigDecimal b2 = new BigDecimal(Double.toString(b1));
        return a2.multiply(b2).doubleValue();
    }

    //乘 - 保留两位小数
    public static double mul2(double a1, double b1) {
        DecimalFormat df = new DecimalFormat("#.00" );
        return Double.valueOf(df.format(a1 * b1));
    }

    //乘 - 保留4位小数
    public static double muls(double a1, double b1, int scale) {
        String s = "#." ;
        for (int i = 0; i < scale; i++) {
            s += "0" ;
        }
        DecimalFormat df = new DecimalFormat(s);
        return Double.valueOf(df.format(a1 * b1));
    }

    //除
    public static double div(double a1, double b1, int scale) {

        if (scale < 0) {
            throw new IllegalArgumentException("error" );
        }
        BigDecimal a2 = new BigDecimal(Double.toString(a1));
        BigDecimal b2 = new BigDecimal(Double.toString(b1));
        return a2.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //String转化BigDecimal
    public static BigDecimal moneyStringHandle(String a) {
        BigDecimal b = new BigDecimal(a);
        return b;
    }

    //Double转化BigDecimal
    public static BigDecimal moneyDoubleHandle(Double a) {
        BigDecimal b = new BigDecimal(Double.toString(a));
        return b;
    }

    //报错
    public static boolean errorException(String str, boolean result) {
        try {
            throw new RuntimeException(str);
        } finally {
            return result;
        }
    }

    //乘 - 保留两位小数
    public static double reservedDecimal(double a) {
        DecimalFormat df = new DecimalFormat("#.000" );
        return Double.valueOf(df.format(a));
    }
}
