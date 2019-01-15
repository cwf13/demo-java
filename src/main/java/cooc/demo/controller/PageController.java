package cooc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Decriction:
 * @Author: weifeng.chen
 * @Date: 2018/12/6 23:43
 * @Version 1.0
 */
@Controller
public class PageController {

    @RequestMapping(value = "/zaindex" )
    public String index(HttpServletRequest request) {
        System.out.println("ip： 访问了主页.." );
        return "websocketTest" ;
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        System.out.println("ip： 访问了主页.." );
        return "login" ;
    }

    @RequestMapping(value = "/websocketTest")
    public String websocketTest(HttpServletRequest request) {
        System.out.println("ip： 访问了websocketTest主页.." );
        return "websocketTest" ;
    }
}
