package com.example.demo2.pojo;

import java.math.BigDecimal;

/**
 * @author xuezhijian
 * @date 2018/10/21 下午8:47
 * @description
 */
public class Test {

    private Long id;

    private String name;

    private BigDecimal balance;

    private Integer version;

    public Test(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
