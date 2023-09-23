package com.digitalwallet.customerservice.infrastructure.external;

import com.digitalwallet.customerservice.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9001", name = "wallet-service")
public interface WalletAPIRepository {
    @PostMapping(value = "/wallets")
    ResponseEntity createWallet(@RequestBody Customer request);
}
