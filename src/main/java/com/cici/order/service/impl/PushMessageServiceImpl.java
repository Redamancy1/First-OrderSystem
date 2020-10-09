package com.cici.order.service.impl;

import com.cici.order.config.WechatAccountConfig;
import com.cici.order.dto.OrderDTO;
import com.cici.order.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 推送消息接口实现类
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        //公众平台模板 Id
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        //接收方的 openid
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        //通知消息的 name,value,color(可不写)
        List<WxMpTemplateData> data = Arrays.asList(
          new WxMpTemplateData("first","请记得收获"),
          new WxMpTemplateData("keyword1","微信点餐"),
          new WxMpTemplateData("keyword2","15521930000"),
          new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
          new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
          new WxMpTemplateData("keyword5","￥"+orderDTO.getOrderAmount()),
          new WxMpTemplateData("remark","欢迎下次再次光临!")
        );
        templateMessage.setData(data);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败,{}",e);
        }
    }
}
