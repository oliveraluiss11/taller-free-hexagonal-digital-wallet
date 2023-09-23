package com.digitalwallet.movementsservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Builder
public class Movement {
    private String movementId;
    private String transferId;
    private String operationNumber;
    private String typeTransaction;
    private String currency;
    private BigDecimal amount;
    private String walletId;
    private LocalDateTime registrationDate;
}
