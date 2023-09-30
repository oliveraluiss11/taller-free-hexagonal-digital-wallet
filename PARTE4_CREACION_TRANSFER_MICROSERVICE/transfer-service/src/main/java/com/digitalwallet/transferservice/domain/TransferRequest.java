package com.digitalwallet.transferservice.domain;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class TransferRequest {
    @Pattern(regexp = "^9[0-9]{8}$", message = "El número de teléfono de origen debe empezar con 9 y tener 9 dígitos")
    private String originPhoneNumber;

    @Pattern(regexp = "^9[0-9]{8}$", message = "El número de teléfono de destino debe empezar con 9 y tener 9 dígitos")
    private String destinationPhoneNumber;
}
