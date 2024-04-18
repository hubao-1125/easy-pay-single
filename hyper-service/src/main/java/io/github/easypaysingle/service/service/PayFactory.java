package io.github.easypaysingle.service.service;

import io.github.hyperpay.common.model.vo.request.pay.PayRequestVO;
import io.github.hyperpay.common.model.vo.response.ResponseVO;
import io.github.easypaysingle.service.enums.PayServiceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 功能描述: 支付工厂-类
 *
 * @author hubao
 * @since 2024/4/1$ 14:46$
 */
@Component
public class PayFactory {


    @Autowired
    private ApplicationContext applicationContext;


    public ResponseVO pay(PayRequestVO payRequestVO) {

        // 获取支付服务枚举
        PayServiceEnum payServiceEnum = PayServiceEnum.getPayServiceEnumByPaywayEnum(payRequestVO.getPaywayEnum());
        if (Objects.isNull(payServiceEnum)) {
            return ResponseVO.builder().build();

        }

        // 获取支付服务类
        Class<?> clazz = payServiceEnum.getClazz();
        PayService payService = (PayService) applicationContext.getBean(clazz);
        // 调用支付服务
        return payService.pay(payRequestVO);
    }
}
