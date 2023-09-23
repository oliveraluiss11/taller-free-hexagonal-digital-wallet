package com.digitalwallet.customerservice.infrastructure;

import com.digitalwallet.customerservice.application.CreateCustomer;
import com.digitalwallet.customerservice.domain.CustomerCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomer createCustomer;

    @PostMapping
    public ResponseEntity registerCustomer(@RequestBody CustomerCreation request) {
        createCustomer.save(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
