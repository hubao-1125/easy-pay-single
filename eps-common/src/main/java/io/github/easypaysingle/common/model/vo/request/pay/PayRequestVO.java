package io.github.easypaysingle.common.model.vo.request.pay;

import io.github.easypaysingle.common.model.vo.request.PayRequestCommonVO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述: -类
 *
 * @author hubao
 * @Date: 2024/3/28$ 15:45$
 */
@Data
@Builder
public class PayRequestVO extends PayRequestCommonVO implements Serializable {

    /**
     * 微信支付请求参数VO
     */
    private WXPayRequestVO wxPayRequestVO;
}
