package com.digitalwallet.movementsservice.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Document(collection = "movement")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

