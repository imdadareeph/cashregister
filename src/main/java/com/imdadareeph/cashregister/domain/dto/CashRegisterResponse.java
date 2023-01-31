package com.imdadareeph.cashregister.domain.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashRegisterResponse {

    private String countryCode;
    Map<String, String> change;
    CashRegisterError cashRegisterError;
}
