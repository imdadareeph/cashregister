package com.imdadareeph.cashregister.functions;

import com.imdadareeph.cashregister.domain.configs.Currencies;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author : Imdad Areeph
 */
@Component
public class DenominationFunction implements Function<Currencies, Map<String, Float>> {


    /**
     * Applies this function to the given argument.
     *
     * @param currencies the function argument
     * @return the function result
     */
    @Override
    public Map<String, Float> apply(Currencies currencies) {
        return currencies
                .getDenominations()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        (mapValue) -> Float.parseFloat(mapValue.getValue())));
    }


}
