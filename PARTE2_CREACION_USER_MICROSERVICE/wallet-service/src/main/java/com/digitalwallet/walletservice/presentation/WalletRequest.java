package com.digitalwallet.walletservice.presentation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class WalletRequest {
    @NotBlank
    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private String documentNumber;
    @NotBlank
    @NotNull
    @Pattern(regexp = "9[0-9]{8}", message = "phoneNumber value should be 9 digits")
    private String phoneNumber;
    @NotBlank
    @NotNull
    @Pattern(regexp = "DNI", message = "typeDocument value should be DNI")
    private String documentType;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String givenNames;
    @NotBlank
    @NotNull
    private String surnames;
}
