package com.digitalwallet.customerservice.domain;

import lombok.Getter;

@Getter
public class CustomerCreation {
    private String givenNames;
    private String surnames;
    private String documentNumber;
    private String documentType;
    private String email;
    private String phoneNumber;
}
