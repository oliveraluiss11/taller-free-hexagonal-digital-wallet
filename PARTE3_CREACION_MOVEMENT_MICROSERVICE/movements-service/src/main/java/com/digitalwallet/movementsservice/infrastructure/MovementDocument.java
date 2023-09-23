package com.digitalwallet.movementsservice.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementDocument {
    @Id
    private String movementId;
    private String transferId;
    private String operationNumber;
    private String typeTransaction;
    private String currency;
    private BigDecimal amount;
    private String walletId;
    private LocalDateTime registrationDate;
}

