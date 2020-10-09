package com.cici.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 卖家端消息推送配置
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
       return new ServerEndpointExporter();
    }
}
