package com.digitalwallet.transferservice.domain;

import java.math.BigDecimal;

public record UpdateBalanceRequest(BigDecimal balance) {
}
