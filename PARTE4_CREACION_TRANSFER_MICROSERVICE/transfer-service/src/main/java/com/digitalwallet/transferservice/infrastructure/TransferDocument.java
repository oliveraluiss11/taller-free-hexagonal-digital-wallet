package com.digitalwallet.transferservice.infrastructure;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "transfer")
public class TransferDocument {
    @Id
    private String transferId;
    private String originWalletId;
    private String destinationWalletId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private LocalDateTime registrationDate;
}
