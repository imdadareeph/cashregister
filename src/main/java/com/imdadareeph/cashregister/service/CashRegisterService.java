package com.imdadareeph.cashregister.service;

import com.imdadareeph.cashregister.domain.configs.Currencies;
import com.imdadareeph.cashregister.functions.ConfigurationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CashRegisterService {

    @Autowired
    private ConfigurationFunction configurationFunction;

    private static BiPredicate<Currencies, String> currencyMatched = (currencies, currName) -> currencies.getName()
            .equalsIgnoreCase(currName);


    public Function<String, Currencies> retrieveCountryWiseConfigValues = currency -> configurationFunction.get()
            .stream()
            .filter(curr -> currencyMatched.test(curr, currency))
            .findFirst()
            .orElseGet(Currencies::new);

    public Function<String, Map<String, String>> denominationMap = currency -> retrieveCountryWiseConfigValues.apply(currency)
            .getDenominations();

    public  Function<String, Map<String, Float>> retrieveCurrencyWiseDenominationFunctionByCurrency = currency -> denominationMap.apply(currency)
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey,
                    (mapValue) -> Float.parseFloat(mapValue.getValue())));

    public static Function<Currencies, Map<String, Float>> retrieveCurrencyWiseDenominationFunction = currency -> currency
            .getDenominations()
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey,
                    (mapValue) -> Float.parseFloat(mapValue.getValue())));






}
