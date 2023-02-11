package com.imdadareeph.cashregister.converter;

import com.imdadareeph.cashregister.functions.ConfigurationFunction;
import com.imdadareeph.cashregister.service.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.imdadareeph.cashregister.service.CashRegisterService.retrieveCurrencyWiseDenominationFunction;

@Component
public class DenominationConverter implements BiFunction<String, String, String> {

    @Autowired
    private ConfigurationFunction configurationFunction;

    @Autowired
    private CashRegisterService cashRegisterService;

    public static Function<Map<String, Float>, String> denominationAsString = (Map<String, Float> deno) -> {
        List<String> stringList = deno.keySet().stream().collect(Collectors.toList());
        return String.join(",", stringList);
    };

    /**
     * Applies this function to the given argument.
     *
     * @param denominationValues the function argument
     * @param currency           the function argument
     * @return the function result
     */
    @Override
    public String apply(String denominationValues, String currency) {
        List<String> denominationValueList = Arrays.asList(denominationValues.split(","));

        Map<String, Float> stringFloatMap1 = Optional.ofNullable(currency)
                .map(cashRegisterService.retrieveCountryWiseConfigValues)
                .map(retrieveCurrencyWiseDenominationFunction).orElseGet(ConcurrentHashMap::new);

        Map<String, Float> stringFloatMap = cashRegisterService.retrieveCurrencyWiseDenominationFunctionByCurrency.apply(
                currency);


        List<String> stringList = denominationValueList.stream()
                .map(x -> convert(x, stringFloatMap1))
                .collect(Collectors.toList());
        return String.join(",", stringList);
    }

    private String convert(String str, Map<String, Float> denominationMap) {
        Map<String, Float> finalMap = denominationMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(dMap -> dMap.getValue() == Float.parseFloat(str))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, ConcurrentHashMap::new));
        //return dMap.getValue();

        return denominationAsString.apply(finalMap);
    }
}
