package com.imdadareeph.cashregister.service;

import com.imdadareeph.cashregister.domain.configs.CashRegisterConfigs;
import com.imdadareeph.cashregister.domain.configs.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.BiPredicate;

@Service
public class CashRegisterService {

    @Autowired
    private CashRegisterConfigs cashRegisterConfigs;

    private BiPredicate<String, String> countryCodeBiPredicate = String::equalsIgnoreCase;

    public Currencies retrieveCountryWiseConfigValues(String countryCode) {

        Currencies currencies = new Currencies();
        Optional<Currencies> currenciesOptional = cashRegisterConfigs.getCurrencies()
                .stream()
                .filter(currency -> countryCodeBiPredicate.test(currency.getCountryCode(), countryCode))
                .findFirst();
        if (currenciesOptional.isPresent()) {
            currencies = currenciesOptional.get();
        }
        return currencies;

    }

}
