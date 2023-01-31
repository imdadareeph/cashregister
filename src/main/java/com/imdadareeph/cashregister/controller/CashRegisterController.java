package com.imdadareeph.cashregister.controller;

import com.imdadareeph.cashregister.domain.dto.CashRegisterError;
import com.imdadareeph.cashregister.domain.dto.CashRegisterRequest;
import com.imdadareeph.cashregister.domain.dto.CashRegisterResponse;
import com.imdadareeph.cashregister.service.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cashregister")
public class CashRegisterController {

    @Autowired
    private CashRegisterService cashRegisterService;


    @PostMapping("/{country}")
    public ResponseEntity<CashRegisterResponse> createTutorial(@PathVariable String country, @RequestBody CashRegisterRequest cashRegisterRequest) {
        CashRegisterResponse cashRegisterResponse = new CashRegisterResponse();
        try {
            cashRegisterService.retrieveCountryWiseConfigValues(country);
            cashRegisterResponse.setCountryCode(country);
            return new ResponseEntity<>(cashRegisterResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            cashRegisterResponse.setCashRegisterError(CashRegisterError.builder()
                    .errorCode("500")
                    .errorMessage("Service Exception at Controller layer")
                    .build());
            return new ResponseEntity<>(cashRegisterResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
