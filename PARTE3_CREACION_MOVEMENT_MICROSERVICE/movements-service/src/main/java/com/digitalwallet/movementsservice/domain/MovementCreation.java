package com.digitalwallet.movementsservice.domain;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MovementCreation {
    @NotBlank
    private String transferId;

    @NotBlank
    private String operationNumber;

    @NotBlank
    @Pattern(regexp = "^(PEN|USD)$", message = "Currency must be PEN or USD")
    private String currency;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotBlank
    @Pattern(regexp = "^(INCOME|WITHDRAW)$", message = "TypeTransaction must be INCOME or WITHDRAW")
    private String typeTransaction;

    @NotBlank
    private String walletId;
}
