package com.digitalwallet.customerservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {
    private String customerId;
    private String givenNames;
    private String surnames;
    private String documentNumber;
    private String documentType;
    private String email;
    private String phoneNumber;
}
