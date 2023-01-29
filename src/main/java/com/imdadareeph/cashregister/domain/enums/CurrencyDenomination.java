package com.imdadareeph.cashregister.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum CurrencyDenomination {
    PENNY("PENNY"),
    NICKEL("NICKEL"),
    DIME("DIME"),
    QUARTER("QUARTER"),
    HALF_DOLLAR("HALF_DOLLAR"),
    ONE("ONE"),
    TWO("TWO"),
    FIVE("FIVE"),
    TEN("TEN"),
    TWENTRY("TWENTRY"),
    FIFTY("FIFTY"),
    ONE_HUNDRED("ONE_HUNDRED");

    @Getter
    private String value;
}
