package com.imdadareeph.cashregister.controller;

import com.imdadareeph.cashregister.converter.DenominationConverter;
import com.imdadareeph.cashregister.domain.dto.CashRegisterError;
import com.imdadareeph.cashregister.domain.dto.CashRegisterRequest;
import com.imdadareeph.cashregister.domain.dto.CashRegisterResponse;
import com.imdadareeph.cashregister.exception.CashRegisterException;
import com.imdadareeph.cashregister.functions.ChangeFunction;
import com.imdadareeph.cashregister.functions.ConfigurationFunction;
import com.imdadareeph.cashregister.functions.DenominationFunction;
import com.imdadareeph.cashregister.service.CashRegisterService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.imdadareeph.cashregister.service.CashRegisterService.retrieveCurrencyWiseDenominationFunction;

@RestController
@RequestMapping("/cashregister")
public class CashRegisterController {

    @Autowired
    private CashRegisterService cashRegisterService;

    @Autowired
    private ChangeFunction changeFunction;

    @Autowired
    private DenominationFunction denominationFunction;

    @Autowired
    private ConfigurationFunction configurationFunction;

    @Autowired
    private DenominationConverter denominationConverter;


    @PostMapping("/{currency}")
    public ResponseEntity<CashRegisterResponse> createTutorial(@PathVariable String currency, @RequestBody CashRegisterRequest cashRegisterRequest) {
        CashRegisterResponse cashRegisterResponse = new CashRegisterResponse();
        try {
            String denominationResponse = Optional.ofNullable(currency)
                    .map(cashRegisterService.retrieveCountryWiseConfigValues)
                    .map(retrieveCurrencyWiseDenominationFunction)
                    .map(denominationMap -> {
                        String denominationValues = changeFunction.apply(cashRegisterRequest, denominationMap);
                        //cashRegisterService.retrieveCurrencyWiseDenominationFunctionByCurrency.apply(currency);
                        //String denominationKeys = denominationAsString.apply(denominationMap);
                        return denominationValues;

                    })
                   .map(x->denominationConverter.apply(x,currency))
                    .orElse(StringUtils.EMPTY);

            /*Currencies currencies = cashRegisterService.retrieveCountryWiseConfigValues.apply(currency);
            String denominationResponse = Optional.ofNullable(currencies).map(retrieveCurrencyWiseDenominationFunction)
                    .map(denominationMap -> changeFunction.getCashChange(cashRegisterRequest, denominationMap))
                    .orElse(StringUtils.EMPTY);*/

            cashRegisterResponse.setCurrency(currency);
            cashRegisterResponse.setCurrencyDenominations(denominationResponse);
            return new ResponseEntity<>(cashRegisterResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            Throwable rootCause = Optional.ofNullable(ExceptionUtils.getRootCause(e))
                    .orElseGet(() -> new CashRegisterException("CashRegisterException"));
            cashRegisterResponse.setCashRegisterError(CashRegisterError.builder()
                    .errorCode("500")
                    .errorMessage("Service Exception at Controller layer")
                    .rootCause(rootCause.toString())
                    .build());
            return new ResponseEntity<>(cashRegisterResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
