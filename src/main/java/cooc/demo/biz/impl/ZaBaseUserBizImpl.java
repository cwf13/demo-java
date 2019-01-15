package cooc.demo.biz.impl;

import cooc.demo.biz.ZaBaseUserBiz;
import cooc.demo.controller.UserController;
import cooc.demo.mapper.*;
import cooc.demo.model.ZaMall;
import cooc.demo.model.ZaMallExchangeRec;
import cooc.demo.model.ZaUsers;
import cooc.demo.model.ZaVersion;
import cooc.demo.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsDateJsonBeanProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Decriction:
 * @Author: weifeng.chen
 * @Date: 2018/12/6 12:42
 * @Version 1.0
 */
@Service
@Transactional
@MapperScan(value = {"cooc.demo.mapper"})
public class ZaBaseUserBizImpl implements ZaBaseUserBiz {

    private static final Logger log = LoggerFactory.getLogger(ZaBaseUserBizImpl.class);

    @Resource
    private ZaUsersMapper zaUsersMapper;

    @Resource
    private BaseDomainMapper baseDomainMapper;

    @Resource
    private ZaMallMapper zaMallMapper;
    @Resource
    private ZaVersionMapper zaVersionMapper;

    @Resource
    private ZaMallExchangeRecMapper zaMallExchangeRecMapper;


    @Override
    public ZaUsers zaLogin(String user_acc, String user_pass) {

        //返回消息
        JSONObject back = new JSONObject();
        back.element("msg" , "登录成功！" );
        back.element("resCode" , DtoConstant.ALL_YES);

        //查询数据组织
        Map<String, String> map = new HashMap<>();
        map.put("account" , user_acc);
        //是否需要密码验证
//         map.put("password",DtoConstant.passToMd5(user_pass));
        map.put("password" , user_pass);

        //查询
        ZaUsers zaUsers = zaUsersMapper.queryByLogins(map);

        JSONObject data = JSONObject.fromObject(zaUsers);


        //如果不存在，或者错误
        if (zaUsers == null) {
            back.element("msg" , "账号或密码错误！" ).element("resCode" , DtoConstant.ALL_NO);
        } else if (data.getInt("status" ) != 1) {
            back.element("msg" , "该用户处于禁用状态！" ).element("resCode" , DtoConstant.ALL_NO);
        }
        back.element("data" , zaUsers);
        return zaUsers;

    }

    @Override
    public JSONObject denominationList(String url, String platform) {

        JSONObject back = new JSONObject();
        Map<String, String> baseDomain = baseDomainMapper.selectBaseDomainByDomain(url);
        JSONObject d = JSONObject.fromObject(baseDomain);
        if (ProjectUtil.isNull(baseDomain)) {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "该平台不存在" );
            return back;
        }
        if (DtoConstant.ALL_YES != d.getInt("isUse" )) {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "该平台已被禁用" );
            return back;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("isUse" , DtoConstant.ALL_YES);
        map.put("platform" , d.getString("platform" ));
        List<Map<String, String>> list = zaMallMapper.selectZaMallByMap(map);
        JSONArray array = JSONArray.fromObject(list);
        TimeUtil.transTimestamp(array, "createTime" , "yyyy-MM-dd HH:mm:ss" );
        JSONObject data = new JSONObject();
        data.element("array" , array);
        back.element("data" , data);
        back.element("resCode" , DtoConstant.ALL_YES);
        back.element("msg" , "获取成功" );
        return back;
    }

    @Override
    public JSONObject getZaVersion(Long userId, String platform, String id, String type, HttpServletResponse response) {

        JSONObject back = new JSONObject();
        ZaMall zaMall = zaMallMapper.selectByPrimaryKey(Long.valueOf(id));
        if (ProjectUtil.isNull(zaMall)) {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "该面额不存在" );
            return back;
        }
        //银行编码
        String pay_bankcode = "" ;
        //支付宝支付
        if (type.equals(String.valueOf(DtoConstant.ALL_YES))) {
            pay_bankcode = "903" ;
        }
        //微信支付
        if (type.equals(String.valueOf(DtoConstant.ALL_NO))) {
            pay_bankcode = "902" ;
        }


        Map<String, String> returnMap = zaVersionMapper.selectZaVersionByPlatform(platform);
        JSONObject obj = JSONObject.fromObject(returnMap);

        //生成订单
        ZaMallExchangeRec zaMallExchangeRec = new ZaMallExchangeRec();
        zaMallExchangeRec.setUserid(userId);
        zaMallExchangeRec.setCreatetime(DateUtils.getDate(DateUtils.getTimestamp()));
        zaMallExchangeRec.setObjid(Long.valueOf(id));
        zaMallExchangeRec.setPlatform(platform);
        zaMallExchangeRec.setPaytype(Integer.valueOf(type));
        zaMallExchangeRec.setStatus(DtoConstant.ALL_NO);
        zaMallExchangeRec.setTitile(String.valueOf(zaMall.getDenomination()) + "元套餐" );
        zaMallExchangeRec.setPay(new BigDecimal(zaMall.getDenomination()));

        int i = zaMallExchangeRecMapper.insertSelective(zaMallExchangeRec);

        if (i < 0) {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "订单生成失败" );
            return back;
        }


        //商户号
        String pay_memberid = obj.getString("mch" );
        //订单号
        String pay_orderid = ProjectUtil.getorderCode();

        String postUrl = obj.getString("thirdUrl" );
        //密钥
        String key = obj.getString("key" );

        //提交时间
        String pay_applydate = TimeUtil.getNowDate("yyyy-MM-dd HH:mm:ss" );

        //服务端通知
        String pay_notifyurl = "http://www.baidu.com" ;
        //页面跳转通知
        String pay_callbackurl = "http://www.baidu.com" ;
        //订单金额

        String pay_amount = zaMall.getPaymoney().toString();
        //MD5签名

        //商品名称
        String pay_productname = "911" ;


        String pay_attach = "00" ;


        Map<String, String> map = new HashMap<String, String>();

        map.put("pay_memberid" , pay_memberid);
        map.put("pay_orderid" , pay_orderid);
        map.put("pay_applydate" , pay_applydate);
        map.put("pay_bankcode" , pay_bankcode);
        map.put("pay_notifyurl" , pay_notifyurl);
        map.put("pay_amount" , pay_amount);
        map.put("pay_callbackurl" , pay_callbackurl);
        map.put("pay_productname" , pay_productname);
        String stringSignTemp = "pay_amount=" + pay_amount + "&pay_applydate=" + pay_applydate + "&pay_bankcode=" + pay_bankcode + "&pay_callbackurl=" + pay_callbackurl + "&pay_memberid=" + pay_memberid + "&pay_notifyurl=" + pay_notifyurl + "&pay_orderid=" + pay_orderid + "&key=" + key + "" ;
        String pay_md5sign = null;
        try {
            pay_md5sign = AsciiOrder.md5(stringSignTemp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        map.put("pay_md5sign" , pay_md5sign);
        /*   map.put("pay_attach",pay_attach);*/


        String k = HttpU.postWithParamsForString(postUrl, map);
        log.info(k);

        try {
            response.getWriter().print(k);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public JSONObject getUserList() {

        JSONObject back = new JSONObject();

        List<Map<String,String>> userList = zaUsersMapper.getUserList();

        JSONArray array = JSONArray.fromObject(userList);

        JSONObject data = new JSONObject();

        data.element("array",array);
        back.element("data",data);
        back.element("code",DtoConstant.ALL_YES);
        back.element("msg","获取成功");
        return back;
    }
}
