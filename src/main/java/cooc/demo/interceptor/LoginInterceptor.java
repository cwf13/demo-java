package cooc.demo.interceptor;

import cooc.demo.utils.DtoConstant;
import cooc.demo.utils.ProjectUtil;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Decriction:
 * @Author: weifeng.chen
 * @Date: 2018/12/6 22:55
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        //获取session内容
        JSONObject user = JSONObject.fromObject(request.getSession().getAttribute(DtoConstant.USER_LOGIN));
        String path = request.getServletPath();

        //除指定前缀地址外不进行登录判断
        if (!path.contains("/user/" )) {
            return true;
        }
        JSONObject data = new JSONObject();
        if (ProjectUtil.isNull(user)) {
            data.element("code" , 2);
            data.element("url" , "login.html" );
            data.element("msg" , "请先登录!" );
            ProjectUtil.printMsg(request, response, data.toString());
            return false;
        }


        return true;
    }
}
