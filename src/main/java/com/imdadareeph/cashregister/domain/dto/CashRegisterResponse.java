package com.imdadareeph.cashregister.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CashRegisterResponse {

    private String currency;
    private Map<String, String> change;
    private String currencyDenominations;
    private CashRegisterError cashRegisterError;
}
