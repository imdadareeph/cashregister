package com.imdadareeph.cashregister.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashRegisterRequest {

    private float purchasePrice;
    private float cashGiven;
}
