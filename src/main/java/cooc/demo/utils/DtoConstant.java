package cooc.demo.utils;


/**
 * @author cec
 * @version data：2018/6/21 09:22
 * 系统常量
 */
public class DtoConstant {

    /**
     * 登录用户SESSION
     * id,imgUrl,nickName,userTel,isSuperRetail,chainAdd,rec,recUsers,token,memo,isUse
     */
    public final static String USER_LOGIN = "USERLOGIN" ;

    /**
     * 管理员SESSION
     * id, account, pass,root, memo
     */
    public final static String SYSTEM_LOGIN = "SYSTEMLOGIN" ;


    /**
     * 总后台管理权限
     */
    public final static String SYSTEM_POWER = "SYSTEMPOWER" ;

    /**
     * 基础数据session 用户登录token
     */
    public final static String USER_LOGIN_TOKEN = "USER_LOGIN_TOKEN" ;

    /**
     * 公共 code 成功：1  、失败：0
     */
    public final static int ALL_NO = 0;
    public final static int ALL_YES = 1;

    /**
     * 1美元约等于多少人民币
     */
    public final static double USE_RMB_BAL = 6.84;

    /**
     * 美元币种
     */
    public final static String USE_SYMBOL = "USDT" ;

    /**
     * 内币币种
     */
    public final static String OUR = "GCNY" ;

    /**
     * 1 OUR约等于多少人民币
     */
    public final static double OUR_RMB_BAL = 1;

    /*** 类型 修改密码*/
    public final static int USER_RECHARGE_PASS = 0;
    /*** 类型 修改支付密码*/
    public final static int USER_RECHARGE_PAY = 1;


    /**
     * 发送验证码 SESSION 名称
     */
    public final static String SENT_CODE = "SENTCODE" ;

    /**
     * 默认验证码
     */
    public final static String USUALLY_CODE = "350582" ;

    /**
     * 本系统注册标识
     */
    public final static String PLATFORM_CODE = "SYS" ;

    /**
     * 验证码短信模板
     */
    public static String FORGET_PASS_MSG = "【GCNY】验证码：%s。,您正在进行身份验证,打死不要告诉别人哦! " ;
    //public static String FORGET_PASS_MSG="【GCNY】验证码：%s。验证码很重要，请勿泄露。";

    /**
     * 分页信息
     */
    //页
    public final static int PAGE_SIZE = 1;
    //数据条数
    public final static int PAGE_INDEX = 10;

    /**
     * 上传文件类型
     */
    //图片
    public final static int FILE_TYPE_IMG = 0;
    //文档
    public final static int FILE_TYPE_WORD = 1;

    /**
     * MD5
     */
    public final static String MERCHANT_MD5 = "TRADE" ;
    /**
     * 开关
     */
    public final static boolean MERCHANT_ISMD5 = true;

    /**
     * 加密
     */
    public static String passToMd5(String pass) {

        if (MERCHANT_ISMD5) {
            return DigestUtils.toMD5(pass + MERCHANT_MD5);
        } else {
            return pass;
        }
    }

    /**
     * 哈希加密
     */
    public static String hashToMd5(String str) {
        str = str + MERCHANT_MD5;
        return DigestUtils.toMD5(str);
    }


    /**
     * 商户标识
     */
    public final static String MERCHANT_ID = "7H4VG2" ;

    /**
     * 私钥
     */
    public final static String MERCHANT_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy3prhjVTw9Ou5cif92jjESMPEaUD16MWySdsUr5EAH2tiCMYQu1jVf0suIyU88/fD7/tR1iclYH3+ABUoxokrmv1TqIuszGbLsOSrXw4Gk95ro6Zk6m9bZAy5M7n8krlCR6ymkLCPnhb5NEZjCLgSvinwlxN0zpNWZ/SJQeExePnl4PHr0mLPpv/ENNHhqi5xeCk1shGe1ZcZUs49nN8eclIbCvpCdI75k7brwfH5/p/+lKzFf3/0G8nWbjjqIZe/+DaYsl5PIos1fDj3sLgvtiTsqkw7QeMQYckJPe/I3oS4xlqHFNmGKAKGMVx4GvMmvscfUpnwuvMeoa0oMtk6wIDAQAB" ;

    /**
     * 通道ID
     */
    public final static String MERCHANT_ROUTE = "10" ;


    /**
     * 公钥-platform
     */
    public final static String PUBLICK_TRADE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5fXa8JcAxy3UIq1b/WlaDP3A8RFeUxIlFBz2AA+BV1BVvWUmd+4mm53EeppoOrkCmxjnyH7xIfDvQASHUkzDmbB5YAW/3/xmdvXJzFSdDYm3MrGeqbbAG7mMPJghHu1ynhKwaISdEcMV+DWWBOSmziJeISsYIcvR3kv21RxAahLvuqdj5muD7Bsaok4m3wAGluQA3B/+U1VuqiC/oMXDalHtfvAgx9gcxNiJcr4kIXXzD1yOpoZnYed9ryisvIi7KihDKnHjpXiWqi4pRAzUL6rn5e6uCGsQV2YRuF2SbTChCohMeycHsYYYv/H+K3OnFQvBROqbzDzTrmMuPyoYywIDAQAB" ;

    /**
     * 私钥-trade
     */
    public final static String PRIVECE_TRADE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDl9drwlwDHLdQirVv9aVoM/cDxEV5TEiUUHPYAD4FXUFW9ZSZ37iabncR6mmg6uQKbGOfIfvEh8O9ABIdSTMOZsHlgBb/f/GZ29cnMVJ0NibcysZ6ptsAbuYw8mCEe7XKeErBohJ0RwxX4NZYE5KbOIl4hKxghy9HeS/bVHEBqEu+6p2Pma4PsGxqiTibfAAaW5ADcH/5TVW6qIL+gxcNqUe1+8CDH2BzE2IlyviQhdfMPXI6mhmdh532vKKy8iLsqKEMqceOleJaqLilEDNQvqufl7q4IaxBXZhG4XZJtMKEKiEx7Jwexhhi/8f4rc6cVC8FE6pvMPNOuYy4/KhjLAgMBAAECggEBALJj/uwUuC3Lh30/LtVvHMRnNX3NE3ct5EWuEcgKPzQUxe6ewTDYNmsSAJF7ps+nJjZbI7ONhlHmLjNjT/awRiy7kezDiQ2hJ3uxQFKacRtHci6JS6QseOsJDZkUCt2LJhcqOF9cQNy+khRyvWYeWqgeURc57waIrs3b8CdyOyYNAZ8wWidx1TyFspipm9X4nJ8ba7TSxcp0WxuCUKvN5wTaZy/I3m1SbWnHPLKNQqwbxBvUPp8CVWcwF3wGZ4VLj8pxXaUynDnYMrbxKLRItvI+eZenfG4tcuSaMIcGFP+xfAvPKNgj3ZqCEx55FUlxwgr3zLf2MFDyTGKeGxqCIoECgYEA//2sPjt53peYUS6e+FNDQScvterrDH1qADi1LugD3QS3NWWeFb0drBGBC932jBN6sdKtpQifELLbHmqBTCt7XUbwMqYNH6bIZgMSdLs71y1NFq+mxuTfzgo0bmzcIH4SSwLsH26Kci9j6k39LZ2sewwaf4cAgs2w4up+rpOV1rkCgYEA5ffyHe80Nd/qme0JWnTqKEr3OrTzZAMlnNmbCchGDhov3h2CePvmVc958L3wdISVS/6lMSS6FAwyH80k4cbQmBEONbSxIq2oB6YU5i0f4w1L1OMhfg03tMaz7abVsoTwg+K8GN7ycGAYhoBllrwReh7OkxMt7ucWsH0aNS706aMCgYEA9p7LbAEcvefKZJvHp3F/36sC+f3iiNviXWhElXYNEsdSQe0uSb8ycO1EJ8ylk/nIQLy5cb9Gj23gUANHobxaU1jeW81B43Zopm7bPv6K/hi0peB/iipBu1x1etUBlYQf14hvNzDlzG//kGGmQmYfH0Rf2vCS+3Fysoo7lbC1sHECgYEAhpDw511Kkt/k+o8+suTJBCzhwEOUTIie4Mpgs3eyrpvaOMHR0BOus7XFZ/7tDnFqn15xsXEJRaPhTMSQ+WCKPQF17C1Ancc6FMe1YP80snrcTcVemtEHMMw5Cy5dy6mIx9PMN012VhWVJFdLmsmP/IK8ZEmLzkkA+OMri8VfYLsCgYBzBP8MeJbnfIcv79+rj6drR0Nh1XEsUSC7iCfU5o23H5Lmju9j2tXf2w/FcAF1hwAL82M8LhShqmopuhmnvNUzkquPk9DHxGzMAEcxILsCVdwlrrWROtI4Y2GMlNllx6W4aZnZs/oBgVzl9kpmwuWI09Ym9ceosbJx2S2OuiDEng==" ;


    /**
     * 平台地址
     */
    public final static String NOTIFY_URL = "http://localhost/trade" ;
//    public final static String NOTIFY_URL="http://erpc.s1.natapp.cc/trade";


    /**
     * 短信head
     */
    public final static String MSG_HEAD = "【GCNY】" ;


    /**
     * 充值-是否发短信
     */
    public final static String IS_MSG_1 = "1" ;

    /**
     * 提现-是否发短信
     */
    public final static String IS_MSG_2 = "2" ;

    /**
     * 注册-成功是否发短信
     */
    public final static String IS_MSG_4 = "4" ;

    /**
     * 修改登录密码和交易棉麻-成功是否发短信
     */
    public final static String IS_MSG_5 = "5" ;

    /**
     * 异常登录-是否发短信
     */
    public final static String IS_MSG_6 = "6" ;

    /**
     * 支付密码错误-是否发短信
     */
    public final static String IS_MSG_7 = "7" ;

    /**
     * 转账-是否发短信
     */
    public final static String IS_MSG_9 = "9" ;

    /**
     * 实名-是否发短信
     */
    public final static String IS_MSG_10 = "10" ;

    /**
     * 大戶认证-是否发短信
     */
    public final static String IS_MSG_11 = "11" ;

    /**
     * 申诉-是否发短信
     */
    public final static String IS_MSG_12 = "12" ;

    /**
     * 自动撤单--委托单
     */
    public final static String IS_MSG_15 = "15" ;

    /**
     * 固码-理财账号异常冻结否发短信
     */
    public final static String IS_MSG_17 = "17" ;
    /*******************************************要发短信的star*********************************************/

    /**
     * 订单-状态修改是否发短信
     */
    public final static String IS_MSG_3 = "3" ;

    /**
     * 新订单-是否发短信
     */
    public final static String IS_MSG_8 = "8" ;

    /**
     * 直推注册-成功是否发短信
     */
    public final static String IS_MSG_13 = "13" ;

    /**
     * 大戶挂單-是否发短信
     */
    public final static String IS_MSG_14 = "14" ;


    /**
     * 入金-余额不足提醒否发短信
     */
    public final static String IS_MSG_16 = "16" ;
/*******************************************要发短信的end*********************************************/

    /** 固码路径 */
    //public final static String GUMA_PASH="http://193.112.24.24";

    /**
     * 入金标识
     */
    public final static String RUJIN = "rujin" ;

    /** * 入金标识TOKEN */
    //public final static String RUJIN_TOKEN="e10adc3949ba59abbe56e057f20f883e";
}
