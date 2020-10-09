package com.cici.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目访问路径配置
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
@ConfigurationProperties(prefix = "projecturl")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */
    public String sell;
}
