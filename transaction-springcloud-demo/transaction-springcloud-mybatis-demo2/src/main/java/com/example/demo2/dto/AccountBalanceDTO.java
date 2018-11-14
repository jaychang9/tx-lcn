package com.example.demo2.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * <p>
 *  TODO 类作用描述
 * </p>
 *
 * @author zhangjie
 * @since 2018-11-13
 */
@Data
@Builder
public class AccountBalanceDTO {
    private Long accountId;
    private BigDecimal amount;
}
