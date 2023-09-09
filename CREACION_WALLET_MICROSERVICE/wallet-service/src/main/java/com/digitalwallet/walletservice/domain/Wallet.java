package com.digitalwallet.walletservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Wallet {
    private BigDecimal balance;
    private String currency;
    private Customer customer;
}
