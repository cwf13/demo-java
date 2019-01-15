package cooc.demo.biz;

import cooc.demo.model.ZaUsers;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

/**
 * @InterfaceName ZaBaseUserBiz
 * @Description ZaBaseUserBiz
 * @Author weifeng.chen
 * @Date 2018/12/06 11:50
 * @Version 1.0
 **/

public interface ZaBaseUserBiz {

    /**
     * @return net.sf.json.JSONObject
     * @Description //验证登陆
     * @Date 2018/9/13 13:41
     * @Param []
     **/

    ZaUsers zaLogin(String user_acc, String user_pass);

    /**
     * 获取平台用户面额
     *
     * @param
     * @return
     */
    JSONObject denominationList(String url, String platform);

    JSONObject getZaVersion(Long userId, String platform, String money, String id, HttpServletResponse response);

    JSONObject getUserList();


}
