package com.cici.order.handler;

import com.cici.order.config.ProjectUrlConfig;
import com.cici.order.exception.SellException;
import com.cici.order.exception.SellerAuthorizeException;
import com.cici.order.utils.ResultVOUtil;
import com.cici.order.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截异常请求
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
