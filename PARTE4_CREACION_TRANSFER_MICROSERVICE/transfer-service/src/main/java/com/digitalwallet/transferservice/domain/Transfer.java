package com.digitalwallet.transferservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class Transfer {
    private String transferId;
    private String originWalletId;
    private String destinationWalletId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private LocalDateTime registrationDate;
}
