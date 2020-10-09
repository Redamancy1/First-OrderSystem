package com.cici.order.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信开放平台配置
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Configuration
public class WechatOpenConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxOpenService(){
        WxMpService wxOpenService = new WxMpServiceImpl();
        wxOpenService.setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenService;
    }

    @Bean
    public WxMpConfigStorage wxOpenConfigStorage(){

        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(accountConfig.getOpenAppId());
        wxMpConfigStorage.setSecret(accountConfig.getOpenAppSecret());
        return wxMpConfigStorage;

    }


}
