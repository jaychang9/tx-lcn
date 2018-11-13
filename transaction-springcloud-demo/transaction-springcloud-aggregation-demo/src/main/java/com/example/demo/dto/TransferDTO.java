package com.example.demo.dto;

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
public class TransferDTO {

    private Long fromAcctId;

    private Long toAcctId;

    private BigDecimal amount;

    public Long getFromAcctId() {
        return fromAcctId;
    }

    public void setFromAcctId(Long fromAcctId) {
        this.fromAcctId = fromAcctId;
    }

    public Long getToAcctId() {
        return toAcctId;
    }

    public void setToAcctId(Long toAcctId) {
        this.toAcctId = toAcctId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
