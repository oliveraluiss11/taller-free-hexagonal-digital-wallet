package com.digitalwallet.transferservice.presentation;

import com.digitalwallet.transferservice.domain.TransferRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @PostMapping
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferRequest transferRequest) {
        return new ResponseEntity<>("Transferencia exitosa", HttpStatus.CREATED);
    }
}
