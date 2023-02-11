package com.imdadareeph.cashregister.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashRegisterError {
    private String errorCode;
    private String errorMessage;
    private String rootCause;
}
