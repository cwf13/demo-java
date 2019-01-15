package cooc.demo.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * DateUtils
 *
 * @author cec
 * @date 2018-04-02 15:39
 **/


public class DateUtils {
    /**
     * 1.各种时间格式
     */
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
            "yyyyMMdd" );
    public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat(
            "yyyy-MM-dd" );
    public static final SimpleDateFormat yyyy_MM_dd_wz = new SimpleDateFormat(
            "yyyy年MM月dd日" );
    public static final SimpleDateFormat MM_dd_wz = new SimpleDateFormat(
            "MM月dd日" );
    public static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(
            "yyyyMMddHHmmss" );
    public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat(
            "HH:mm" );
    public static final SimpleDateFormat time_sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm" );
    public static final SimpleDateFormat datetime_sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss" );
    public static final DateFormat timedate_sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss" );
    public static final DateFormat MM_dd = new SimpleDateFormat("MM-dd" );
    /**
     * 静态数据
     */
    private static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
    private static final long HOUR_IN_MILLIS = 3600 * 1000;
    private static final long MINUTE_IN_MILLIS = 60 * 1000;
    private static final long SECOND_IN_MILLIS = 1000;
    //private static Calendar calendar = Calendar.getInstance();

    /**
     * 获取各种时间格式的 SimpleDateFormat
     */
    public static SimpleDateFormat getSimpleDateFormat(String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        return dateformat;
    }
    /**
     * 一。时间转换
     */
    /**
     * 1.获取Date类型时间
     */
    /**
     * 1.1.1获取系统当前时间Date
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 1.1.2 Timestamp转化Date
     */
    public static Date getDate(Timestamp time) {
        if (time == null) {
            return null;
        }
        return time;
    }

    /**
     * 1.1.3 Calendar 转化Date
     */
    public static Date getDate(Calendar calendar) {
        if (calendar == null) {
            return null;
        } else {
            Date date = calendar.getTime();
            return date;
        }
    }

    /**
     * 1.1.4 String转化Date
     */
    public static Date getDate(String time) {
        if (!isNotNull(time)) {
            return null;
        }
        String format[] = new String[]{"yyyyMMdd" , "yyyy-MM-dd" , "yyyy年MM月dd日" , "yyyyMMddHHmmss" , "yyyy-MM-dd HH:mm:ss" , "yyyy-MM-dd HH:mm"};
        Date date = null;
        for (String str : format) {
            try {
                date = getSimpleDateFormat(str).parse(time);
                break;
            } catch (Exception e) {

            }
        }
        return date;
    }

    public static Date getDate(String time, String format) {
        Date date = null;
        if (!isNotNull(time)) {
            return null;
        }
        if (!isNotNull(format)) {
            return getDate(time);
        }
        try {
            date = getSimpleDateFormat(format).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 1.1.5 long转化Date
     */
    public static Date getDate(long time) {
        return new Date(time);
    }

    /**
     * 2.1.1 获取系统当前Timestamp
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 2.1.2 获取Date转换Timestamp
     */
    public static Timestamp getTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 2.1.3 获取Calendar转换Timestamp
     */
    public static Timestamp getTimestamp(Calendar calendar) {
        if (calendar == null) {
            return null;
        } else {
            Date date = calendar.getTime();
            return getTimestamp(date);
        }
    }

    /**
     * 2.1.4 获取String转换Timestamp,format可以为空
     */
    public static Timestamp getTimestamp(String time, String format) {
        if (!isNotNull(time)) {
            return null;
        }
        return getTimestamp(getDate(time, format));
    }

    /**
     * 2.1.5 获取long转换Timestamp
     */
    public static Timestamp getTimestamp(long time) {
        return new Timestamp(time);
    }

    /**
     * 3.1.1 获取系统当前Calendar
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 3.1.2 获取Date转换Calendar
     */
    public static Calendar getCalendar(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
    }

    /**
     * 3.1.3 获取Timestamp转换Calendar
     */
    public static Calendar getCalendar(Timestamp time) {
        if (time == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            return calendar;
        }
    }

    /**
     * 3.1.4 获取String转换Calendar
     */
    public static Calendar getCalendar(String time, String format) {
        if (!isNotNull(time)) {
            return null;
        } else {
            return getCalendar(getDate(time, format));
        }
    }

    /**
     * 3.1.5 获取long转换Calendar
     */
    public static Calendar getCalendar(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }

    /**
     * 4.1.1 获取系统当前时间String
     */
    public static String getStringTime(String format) {
        if (!isNotNull(format)) {
            return null;
        }
        return getStringTime(getDate(), format);
    }

    /**
     * 4.1.2 获取Date转换String
     */
    public static String getStringTime(Date date, SimpleDateFormat date_sdf) {
        if (date == null) {
            return null;
        }
        return date_sdf.format(date);
    }

    public static String getStringTime(Date date, String format) {
        if (date == null || !isNotNull(format)) {
            return null;
        }
        return getSimpleDateFormat(format).format(date);
    }

    /**
     * 4.1.3 获取Calendar转换String
     */
    public static String getStringTime(Calendar calendar, SimpleDateFormat date_sdf) {
        if (calendar == null) {
            return null;
        }
        return date_sdf.format(calendar);
    }

    public static String getStringTime(Calendar calendar, String format) {
        if (calendar == null || !isNotNull(format)) {
            return null;
        }
        return getSimpleDateFormat(format).format(calendar);
    }

    /**
     * 4.1.4 获取Timestamp转换String
     */
    public static String getStringTime(Timestamp time, String format) {
        if (time == null || !isNotNull(format)) {
            return null;
        }
        return getSimpleDateFormat(format).format(time);
    }

    public static String getStringTime(Timestamp time, SimpleDateFormat date_sdf) {
        if (time == null) {
            return null;
        }
        return date_sdf.format(time);
    }

    /**
     * 4.1.5 获取long转换String
     */
    public static String getStringTime(long time, String format) {
        return getStringTime(getDate(time), format);
    }

    public static String getStringTime(long time, SimpleDateFormat date_sdf) {
        return getStringTime(getDate(time), date_sdf);
    }

    /**
     * 5.1.1 获取系统当前时间long
     */
    public static long getLongTime() {
        return getDate().getTime();
    }

    /**
     * 5.1.2 获取Date转换long
     * 如果错误返回-1
     */
    public static long getLongTime(Date date) {
        if (date == null) {
            return -1;
        }
        return date.getTime();
    }

    /**
     * 5.1.3 获取Timestamp转换long
     * 如果错误返回-1
     */
    public static long getLongTime(Timestamp date) {
        if (date == null) {
            return -1;
        }
        return date.getTime();
    }

    /**
     * 5.1.4 获取Calendar转换long
     * 如果错误返回-1
     */
    public static long getLongTime(Calendar calendar) {
        if (calendar == null) {
            return -1;
        }
        return calendar.getTimeInMillis();
    }

    /**
     * 5.1.5 获取String转换long
     * 如果错误返回-1
     */
    public static long getLongTime(String time, String format) {
        if (!isNotNull(time)) {
            return -1;
        }
        return getDate(time, format).getTime();
    }

    /**
     * 6.1.1 转换JSONObject里面的时间转换为 String 返回JSONObject
     * 如果format为空则为默认 yyyy-MM-dd HH:mm:ss
     */
    public static JSONObject transTimestamp(JSONObject obj, String key, String format) {
        if (!isNotNull(format)) {
            format = "yyyy-MM-dd HH:mm:ss" ;
        }
        if (isNotNull(obj, key)) {
            Date nowDate = new Date();
            nowDate.setTime(obj.getLong(key));
            obj.put(key, getSimpleDateFormat(format).format(nowDate));
        }
        return obj;
    }

    /**
     * 6.1.2 转换JSONObject里面的多个时间转换为 String 返回JSONObject
     * 如果format为空则为默认 yyyy-MM-dd HH:mm:ss
     */
    public static JSONObject transTimestamp(JSONObject obj, String[] keys, String format) {
        if (!isNotNull(format)) {
            format = "yyyy-MM-dd HH:mm:ss" ;
        }
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                if (isNotNull(obj, key)) {
                    Date nowDate = new Date();
                    nowDate.setTime(obj.getLong(key));
                    obj.put(key, getSimpleDateFormat(format).format(nowDate));
                }
            }
        }
        return obj;
    }


    public static JSONObject transTimeStamp1(JSONObject oData, String sSdfFormat, String[] sKeys) {
        for (String sKey : sKeys)
            if (!("null" ).equals(oData.getString(sKey))) {
                SimpleDateFormat format = new SimpleDateFormat(sSdfFormat);
                Date nowDate = new Date();
                JSONObject time = oData.getJSONObject(sKey);
                nowDate.setTime(time.getLong("time" ));
                oData.element(sKey, format.format(nowDate));
            }
        return oData;
    }

    /**
     * 7.1.1  转换JSONArray里面的时间转换为 String 返回JSONArray
     * 如果format为空则为默认 yyyy-MM-dd HH:mm:ss
     */
    public static JSONArray transTimestamp(JSONArray array, String key, String format) {
        if (!isNotNull(format)) {
            format = "yyyy-MM-dd HH:mm:ss" ;
        }
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject tmpobj = array.getJSONObject(i);
                if (isNotNull(tmpobj, key))
                    continue;
                else {
                    JSONObject time = tmpobj.getJSONObject(key);
                    Date nowDate = new Date();
                    nowDate.setTime(time.getLong("time" ));
                    tmpobj.element(key, getSimpleDateFormat(format).format(nowDate));
                }
            }
        }
        return array;
    }

    /**
     * 7.1.1  转换JSONArray里面的多个时间转换为 String 返回JSONArray
     * 如果format为空则为默认 yyyy-MM-dd HH:mm:ss
     */
    public static JSONArray transTimestamp(JSONArray array, String[] keys, String format) {
        if (!isNotNull(format)) {
            format = "yyyy-MM-dd HH:mm:ss" ;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        for (int i = 0; i < array.size(); i++) {
            JSONObject tmpobj = array.getJSONObject(i);
            for (String key : keys) {
                if (("null" ).equals(tmpobj.getString(key)))
                    continue;
                else {
                    JSONObject time = tmpobj.getJSONObject(key);
                    Date nowDate = new Date();
                    nowDate.setTime(time.getLong("time" ));
                    tmpobj.element(key, sdf.format(nowDate));
                }
            }
        }
        return array;
    }
    /**
     * 二。时间计算
     */
    /**
     * 1 比较
     */
    /**
     * 1.1.1 比较2个Date
     * date1>date2 返回1
     * date1=date2 返回2
     * date1<date2 返回3
     * 错误（至少1个为null）：返回-1
     */
    public static int comparison(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return -1;
        } else if (date1.getTime() > date2.getTime()) {
            return 1;
        } else if (date1.getTime() == date2.getTime()) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 1.1.2 比较2个Timestamp
     * date1>date2 返回1
     * date1=date2 返回2
     * date1<date2 返回3
     * 错误（至少1个为null）：返回-1
     */
    public static int comparison(Timestamp date1, Timestamp date2) {
        if (date1 == null || date2 == null) {
            return -1;
        } else if (date1.getTime() > date2.getTime()) {
            return 1;
        } else if (date1.getTime() == date2.getTime()) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 1.1.3 比较2个Calendar
     * date1>date2 返回1
     * date1=date2 返回2
     * date1<date2 返回3
     * 错误（至少1个为null）：返回-1
     */
    public static int comparison(Calendar date1, Calendar date2) {
        if (date1 == null || date2 == null) {
            return -1;
        } else if (getLongTime(date1) > getLongTime(date2)) {
            return 1;
        } else if (getLongTime(date1) == getLongTime(date2)) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 1.1.3 比较2个String时间的大小
     * date1>date2 返回1
     * date1=date2 返回2
     * date1<date2 返回3
     * 错误（至少1个为null）：返回-1
     */
    public static int comparison(String time1, String time2, String format1, String format2) {
        if (!isNotNull(new String[]{time1, time2, format1})) {
            return -1;
        }
        if (!isNotNull(format2)) {
            format2 = format1;
        }
        return comparison(getDate(time1, format2), getDate(time1, format2));
    }
    /**
     * 2 时间加减法
     */

    /**
     * 2.1.1 Date时间加减法(计算时间加上多久，减去多久)
     * time:时间
     * year：年
     * month：月
     * days：天
     * hour：小时
     * min：分钟
     * second：秒
     */
    public static Date addAndSubtract(Date time, int year, int month, int days, int hour, int min, int second) {
        if (time == null) {
            return null;
        }
        Calendar c = addAndSubtract(getCalendar(time), year, month, days, hour, min, second);
        return getDate(c);
    }

    /**
     * 2.1.2 Timestamp时间加减法(计算时间加上多久，减去多久)
     * time:时间
     * year：年
     * month：月
     * days：天
     * hour：小时
     * min：分钟
     * second：秒
     */
    public static Timestamp addAndSubtract(Timestamp time, int year, int month, int days, int hour, int min, int second) {
        if (time == null) {
            return null;
        }
        Calendar c = addAndSubtract(getCalendar(time), year, month, days, hour, min, second);
        return getTimestamp(getDate(c));
    }

    /**
     * 2.1.3 Calendar时间加减法(计算时间加上多久，减去多久)
     * time:时间
     * year：年
     * month：月
     * days：天
     * hour：小时
     * min：分钟
     * second：秒
     */
    public static Calendar addAndSubtract(Calendar calendar, int year, int month, int days, int hour, int min, int second) {
        if (calendar == null) {
            return null;
        }
        Calendar c = calendar;
        c.add(c.YEAR, year);//属性很多也有月等等，可以操作各种时间日期
        c.add(c.MONTH, month);
        c.add(c.DATE, days);
        c.add(c.HOUR, days);
        c.add(c.MINUTE, days);
        c.add(c.SECOND, days);
        return c;
    }

    /**
     * 2.1.4 String时间加减法(计算时间加上多久，减去多久)
     * time:时间
     * year：年
     * month：月
     * days：天
     * hour：小时
     * min：分钟
     * second：秒
     */
    public static String addAndSubtract(String time, String format, int year, int month, int days, int hour, int min, int second) {
        Calendar c = addAndSubtract(getCalendar(time, format), year, month, days, hour, min, second);
        return getStringTime(c, format);
    }
    /**
     * 3. 计算时间差
     */

    /**
     * 3.1.1 计算2个Date之间的时间差
     * 采用的是退1法
     * backtype=3,返回相差天数
     * backtype=4，返回相差小时数
     * backtype=5，返回相差分钟数
     * backtype=6，返回相差秒数
     * backtype=7，返回相差毫秒数
     * 错误返回-1
     */
    public static long getTimeDistance(Date date1, Date date2, int backtype) {
        if (date1 == null || date2 == null) {
            return -1;
        }
        long date1m = date1.getTime();
        long date2m = date2.getTime();
        long back = 0;
        back = date1m - date2m;
        switch (backtype) {
            case 3://返回相差天数
                back = back / DAY_IN_MILLIS;
                break;
            case 4://返回相差小时数
                back = back / HOUR_IN_MILLIS;
                break;
            case 5://返回相差分钟数
                back = back / MINUTE_IN_MILLIS;
                break;
            case 6://返回相差秒数
                back = back / SECOND_IN_MILLIS;
                break;
            case 7://返回相差毫秒数
                break;
            default:
                break;
        }
        return back;
    }

    public static long getTimeDistance(Date date1, Date date2, String backtype) {
        int type = 5;
        if (!isNotNull(backtype)) {
            type = getbacktype(backtype);
        }
        return getTimeDistance(date1, date2, type);
    }

    /**
     * 3.1.2 计算2个Timestamp之间的时间差
     * 采用的是退1法
     * backtype=3,返回相差天数
     * backtype=4，返回相差小时数
     * backtype=5，返回相差分钟数
     * backtype=6，返回相差秒数
     * backtype=7，返回相差毫秒数
     * 错误返回-1
     */
    public static long getTimeDistance(Timestamp date1, Timestamp date2, int backtype) {
        return getTimeDistance(date1, date2, backtype);
    }

    public static long getTimeDistance(Timestamp date1, Timestamp date2, String backtype) {
        int type = 5;
        if (!isNotNull(backtype)) {
            type = getbacktype(backtype);
        }
        return getTimeDistance(date1, date2, type);
    }

    /**
     * 3.1.3 计算2个Calendar之间的时间差
     * 采用的是退1法
     * backtype=3,返回相差天数
     * backtype=4，返回相差小时数
     * backtype=5，返回相差分钟数
     * backtype=6，返回相差秒数
     * backtype=7，返回相差毫秒数
     * 错误返回-1
     */
    public static long getTimeDistance(Calendar calendar1, Calendar calendar2, int backtype) {
        if (calendar1 == null || calendar2 == null) {
            return -1;
        }
        return getTimeDistance(calendar1.getTime(), calendar2.getTime(), backtype);
    }

    public static long getTimeDistance(Calendar calendar1, Calendar calendar2, String backtype) {
        int type = 5;
        if (!isNotNull(backtype)) {
            type = getbacktype(backtype);
        }
        return getTimeDistance(calendar1, calendar2, type);
    }

    /**
     * 3.1.4 计算2个String之间的时间差
     * 采用的是退1法
     * backtype=3,返回相差天数
     * backtype=4，返回相差小时数
     * backtype=5，返回相差分钟数
     * backtype=6，返回相差秒数
     * backtype=7，返回相差毫秒数
     * 错误返回-1
     */
    public static long getTimeDistance(String time1, String time2, String format1, String format2, int backtype) {
        if (!isNotNull(new String[]{time1, time2, format1})) {
            return -1;
        }
        if (!isNotNull(format2)) {
            format2 = format1;
        }
        return getTimeDistance(getDate(time1, format1), getDate(time2, format2), backtype);
    }

    public static long getTimeDistance(String time1, String time2, String format1, String format2, String backtype) {
        int type = 5;
        if (!isNotNull(backtype)) {
            type = getbacktype(backtype);
        }
        return getTimeDistance(time1, time2, format1, format2, type);
    }
    /**
     * 4.获取今天是星期几
     */
    /**
     * 4.1.1 获取今天是星期几Date
     */
    public static String getWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getWeek(cal);
    }

    /**
     * 4.1.2 获取今天是星期几Timestamp
     */
    public static String getWeek(Timestamp date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getWeek(cal);
    }

    /**
     * 4.1.3 获取今天是星期几Calendar
     */
    public static String getWeek(Calendar calendar) {
        String[] weekDays = {"星期日" , "星期一" , "星期二" , "星期三" , "星期四" , "星期五" , "星期六"};
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 4.1.4 获取今天是星期几String
     */
    public static String getWeek(String time, String format) {
        return getWeek(getCalendar(time, format));
    }
    /**
     * 5 获取年，月，日，时，分，秒
     */
    /**
     * 5.1.1 Date获取年，月，日，时，分，秒
     * backtype=1,返回年
     * backtype=2,返回月
     * backtype=3,返回日
     * backtype=4,返回时
     * backtype=5,返回分
     * backtype=6,返回秒
     * 错误返回-1
     */
    public static int getSingleDate(Date date, int backtype) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return getSingleDate(calendar, backtype);
    }

    public static int getSingleDate(Date date, String backtype) {
        return getSingleDate(date, getbacktype(backtype));
    }

    /**
     * 5.1.2 Timestamp获取年，月，日，时，分，秒
     * backtype=1,返回年
     * backtype=2,返回月
     * backtype=3,返回日
     * backtype=4,返回时
     * backtype=5,返回分
     * backtype=6,返回秒
     * 错误返回-1
     */
    public static int getSingleDate(Timestamp date, int backtype) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return getSingleDate(calendar, backtype);
    }

    public static int getSingleDate(Timestamp date, String backtype) {
        return getSingleDate(date, getbacktype(backtype));
    }

    /**
     * 5.1.3 Calendar获取年，月，日，时，分，秒
     * backtype=1,返回年
     * backtype=2,返回月
     * backtype=3,返回日
     * backtype=4,返回时
     * backtype=5,返回分
     * backtype=6,返回秒
     * 错误返回-1
     */
    public static int getSingleDate(Calendar calendar, int backtype) {
        if (calendar == null) {
            return -1;
        }
        int back = 0;
        switch (backtype) {
            case 1://返回年
                back = calendar.get(Calendar.YEAR);
                break;
            case 2://返回月
                back = calendar.get(Calendar.MONTH);
                break;
            case 3://返回日
                back = calendar.get(Calendar.DAY_OF_MONTH);
                break;
            case 4://返回时
                back = calendar.get(Calendar.HOUR);
                break;
            case 5://返回分
                back = calendar.get(Calendar.MINUTE);
                break;
            case 6://返回秒
                back = calendar.get(Calendar.SECOND);
                break;
            default:
                break;
        }
        return back;
    }

    public static int getSingleDate(Calendar calendar, String backtype) {
        return getSingleDate(calendar, getbacktype(backtype));
    }

    /**
     * 5.1.4 String获取年，月，日，时，分，秒
     * backtype=1,返回年
     * backtype=2,返回月
     * backtype=3,返回日
     * backtype=4,返回时
     * backtype=5,返回分
     * backtype=6,返回秒
     * 错误返回-1
     */
    public static int getSingleDate(String time, String format, int backtype) {
        return getSingleDate(getCalendar(time, format), backtype);
    }

    public static int getSingleDate(String time, String format, String backtype) {
        return getSingleDate(time, format, getbacktype(backtype));
    }
    /**
     * 6 获得本周的周一或周日
     */
    /**
     * 6.1.1 获得本周的周一或周日Date
     */
    public static Date getWeekFirstDay(Date time) {
        if (time == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return getDate(getWeekFirstDay(calendar));
    }

    /**
     * 6.1.2 Timestamp 获得本周的周一或周日
     */
    public static Timestamp getWeekFirstDay(Timestamp time) {
        if (time == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return getTimestamp(getWeekFirstDay(calendar));
    }

    /**
     * 6.1.3 Calendar 获得本周的周一或周日
     */
    public static Calendar getWeekFirstDay(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
        return calendar;
    }

    /**
     * 6.1.4 String 获得本周的周一或周日
     */
    public static String getWeekFirstDay(String time, String format) {
        return getStringTime(getWeekFirstDay(getCalendar(time, format)), format);
    }


    /**********************************不是时间方法，属于辅助方法********************************/
    /**
     * 检查string是否为空
     */
    private static boolean isNotNull(String str) {
        if (str == null || str.trim().isEmpty() || str.equals("null" )) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检查string是否为空
     */
    private static boolean isNotNull(String[] strs) {
        if (strs != null && strs.length > 0) {
            for (String str : strs) {
                if (!isNotNull(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * JSONObject检查里面的key是否为空
     */
    private static boolean isNotNull(JSONObject obj, String key) {
        if (obj == null || obj.containsKey(key) || obj.get(key) == null || obj.getString(key).equals("null" )) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据str获取返回类型
     *
     * @param str
     * @return
     */
    public static int getbacktype(String str) {
        int back = 1;
        if (str.equals("yyyy" ) || str.equals("YEAR" ) || str.equals("year" ) || str.equals("nian" )) {
            back = 1;
        } else if (str.equals("MM" ) || str.equals("MONTH" ) || str.equals("month" ) || str.equals("yue" )) {
            back = 2;
        } else if (str.equals("dd" ) || str.equals("Day" ) || str.equals("day" ) || str.equals("tian" ) || str.equals("ri" )) {
            back = 3;
        } else if (str.equals("HH" ) || str.equals("HOUR" ) || str.equals("hour" ) || str.equals("shi" ) || str.equals("xiaoshi" )) {
            back = 4;
        } else if (str.equals("mm" ) || str.equals("MINUTE" ) || str.equals("minute" ) || str.equals("fen" ) || str.equals("fengzhong" )) {
            back = 5;
        } else if (str.equals("ss" ) || str.equals("SECOND" ) || str.equals("second" ) || str.equals("miao" )) {
            back = 6;
        } else if (str.equals("hs" ) || str.equals("MILLI" ) || str.equals("milli" ) || str.equals("MILLISECOND" ) || str.equals("millisecond" ) || str.equals("haomiao" )) {
            back = 7;
        }
        return back;
    }

}
