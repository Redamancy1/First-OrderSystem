package com.cici.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *  微信操作接口
 *  手动获取用户openid等信息
 *  后续优化代码不使用该方式
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    /**
     * 设置域名
     * 获取 code
     * 获取 access_token
     * @param code
     */

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法");
        log.info("code={}",code);

        //获取用户 openid
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx46ab5669508f0f19&secret=5ecb8df3aa35fa7df5ee61c1b4694f62&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);
    }
}
