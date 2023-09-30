package com.digitalwallet.transferservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Wallet {
    private String walletId;
    private BigDecimal balance;
    private String currency;
    private Customer customer;
}
