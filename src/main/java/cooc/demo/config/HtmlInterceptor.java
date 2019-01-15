package cooc.demo.config;


import cooc.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Decriction:
 * @Author: weifeng.chen
 * @Date: 2018/12/6 22:36
 * @Version 1.0
 */
@Configuration
public class HtmlInterceptor extends WebMvcConfigurationSupport {

    private static List<String> excludePathList = new ArrayList<>();

    static {
        excludePathList.add("/" );
        excludePathList.add("/login" );
        excludePathList.add("/static/**" );
        excludePathList.add("/user/login" );
        excludePathList.add("/favicon.ico" );
        excludePathList.add("/register.html" );
        excludePathList.add("/register" );
        excludePathList.add("/user/register" );
        excludePathList.add("/user/zalogin" );
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**" )
                .excludePathPatterns(excludePathList);//例外
        super.addInterceptors(registry);
    }


    /**
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认true即匹配；
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认true即匹配；
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true)
                .setUseTrailingSlashMatch(true);


    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**" ) //静态资源访问路径
                .addResourceLocations("classpath:/static/" );     //静态资源映射路径
        super.addResourceHandlers(registry);
    }

    /**
     * 解决返回数据乱码问题
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8" ));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/" ).setViewName("forward:/login" );
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

}
