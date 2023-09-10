package com.digitalwallet.customerservice.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CustomerDocument {
    @Id
    private String customerId;
    private String givenNames;
    private String surnames;
    private String documentNumber;
    private String documentType;
    private String email;
    private String phoneNumber;
}
