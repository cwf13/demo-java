package cooc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Decriction:
 * @Author: weifeng.chen
 * @Date: 2018/12/7 17:07
 * @Version 1.0
 */
@Configuration
public class webSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
