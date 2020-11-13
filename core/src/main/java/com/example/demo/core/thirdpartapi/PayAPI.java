package com.example.demo.core.thirdpartapi;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@ThirdPartAPI(url = "/bank/pay", desc = "支付接口")
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class PayAPI extends AbstractAPI {
    @ThirdPartAPIField(order = 1, type = "N", length = 20)
    private long userId;
    @ThirdPartAPIField(order = 2, type = "M", length = 10)
    private BigDecimal amount;
}



