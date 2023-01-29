package com.imdadareeph.cashregister.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum CurrencyType {
    USD("USD"),
    EUR("EUR"),
    INR("INR"),
    GBP("GBP");

    @Getter
    private String value;
}
