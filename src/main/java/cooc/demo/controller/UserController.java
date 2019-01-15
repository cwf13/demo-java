package cooc.demo.controller;


import cooc.demo.biz.ZaBaseUserBiz;
import cooc.demo.model.ZaUsers;
import cooc.demo.utils.AsciiOrder;
import cooc.demo.utils.DtoConstant;
import cooc.demo.utils.ProjectUtil;
import cooc.demo.utils.TimeUtil;
import cooc.demo.websocket.WebSocketServer;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author XYR
 * @time 2018/11/21 16:55
 */
@Controller
@RequestMapping("/user/" )
public class UserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Resource
    private ZaBaseUserBiz zaBaseUserBiz;


    /**
     * 用户登录
     */
    //http://localhost/user/zalogin?userName=123456&password=123456
    @RequestMapping("zalogin" )
    @ResponseBody
    public String zaLogin(String userName, String password, HttpServletRequest request) {

        String name = request.getParameter("userName");
        String pass = request.getParameter("password");

        JSONObject back = new JSONObject();
        //判断
        if (ProjectUtil.stringIsNULL(userName)) {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "帐号不能为空！" );
            return back.toString();
        }

        if (ProjectUtil.stringIsNULL(password)) {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "密码不能为空！" );
            return back.toString();
        }

        //数据判断
        ZaUsers zaUsers = zaBaseUserBiz.zaLogin(userName, password);


        //存入session
        if (zaUsers != null) {

            request.getSession().setAttribute(DtoConstant.USER_LOGIN, JSONObject.fromObject(zaUsers));


            JSONObject data = new JSONObject();
            data.element("name" , zaUsers.getName());
            data.element("tel" , zaUsers.getTel());

            back.element("msg" , "登录成功！" )
                    .element("resCode" , DtoConstant.ALL_YES)
                    .element("data" , data);
        }

        return back.toString();
    }

    //http://localhost/user/denominationList?url=localhost
    @RequestMapping(value = "denominationList" )
    @ResponseBody
    public String denominationList(HttpServletRequest request) {

        String url = request.getRequestURL().toString();
        String url1 = request.getServletPath();
        url = url.substring(0, url.indexOf(url1));
        url = url.replace("http://" , "" );

        JSONObject back = new JSONObject();


        //组织查询数据
        Map<String, Object> map = new HashMap<>();

        JSONObject user = JSONObject.fromObject(request.getSession().getAttribute(DtoConstant.USER_LOGIN));
        if (DtoConstant.ALL_YES == user.getInt("status" )) {

        } else {
            back.element("resCode" , DtoConstant.ALL_NO);
            back.element("msg" , "该用户已禁用" );
            return back.toString();
        }

        JSONObject data = zaBaseUserBiz.denominationList(url, user.getString("platform" ));

        return data.toString();
    }

    @RequestMapping("getTest" )
    @ResponseBody
    public void test(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id" );
        String type = request.getParameter("type" );

        if (ProjectUtil.stringIsNULL(id)) {
            log.info("面额id不能为空" );
            return;
        }
        if (ProjectUtil.stringIsNULL(type)) {
            log.info("请选择通道" );
            return;
        }

        JSONObject user = JSONObject.fromObject(request.getSession().getAttribute(DtoConstant.USER_LOGIN));


        zaBaseUserBiz.getZaVersion(user.getLong("id" ), user.getString("platform" ), id, type, response);

    }

    @RequestMapping("callBack" )
    @ResponseBody
    public void callBack(String pay_amount, String pay_applydate, String pay_bankcode, String pay_callbackurl, String pay_memberid, String pay_notifyurl, String pay_orderid, String key, String sign, String returncode) {


        String stringSignTemp = "pay_amount=" + pay_amount + "&pay_applydate=" + pay_applydate + "&pay_bankcode=" + pay_bankcode + "&pay_callbackurl=" + pay_callbackurl + "&pay_memberid=" + pay_memberid + "&pay_notifyurl=" + pay_notifyurl + "&pay_orderid=" + pay_orderid + "&key=" + key + "" ;

        String pay_md5sign = null;
        try {
            pay_md5sign = AsciiOrder.md5(stringSignTemp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (!pay_md5sign.equals(sign)) {
            log.info("签名不匹配" );
        }


    }

    //http://localhost/user/testee
    @RequestMapping("testee" )
    @ResponseBody
    public Map<String, Object> testee(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> result = new HashMap<String, Object>();

        try {
            WebSocketServer.sendInfo("有新客户呼入,sltAccountId:0000000" );
            result.put("operationResult" , true);
        } catch (IOException e) {
            result.put("operationResult" , true);
        }
        return result;
    }


    //http://localhost/user/getUserList
    @RequestMapping("getUserList" )
    @ResponseBody
    public String getUserList(HttpServletRequest request, HttpServletResponse response,String name,String age) {

       JSONObject back = zaBaseUserBiz.getUserList();
       return back.toString();
    }



}
