package com.imdadareeph.cashregister.functions;

import com.imdadareeph.cashregister.domain.dto.CashRegisterRequest;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

@Component
public class ChangeFunction implements BiFunction<CashRegisterRequest, Map<String, Float>, String> {


    /**
     * Applies this function to the given arguments.
     *
     * @param cashRegisterRequest the first function argument
     * @param stringFloatMap      the second function argument
     * @return the function result
     */
    @Override
    public String apply(CashRegisterRequest cashRegisterRequest, Map<String, Float> stringFloatMap) {
        if (cashRegisterRequest.getCashGiven() < cashRegisterRequest.getPurchasePrice()) {
            return "ERROR";
        }
        if (cashRegisterRequest.getCashGiven() == cashRegisterRequest.getPurchasePrice()) {
            return "ZERO";
        }
        float cashBack = cashRegisterRequest.getCashGiven() - cashRegisterRequest.getPurchasePrice();

        StringBuilder change = new StringBuilder();
        LinkedHashMap<String, Float> sortedDenominations = getDescendinggSortedDenominations(stringFloatMap);

        for (Float denomination : sortedDenominations.values()) {
            while (cashBack >= denomination) {
                cashBack -= denomination;
                change.append(denomination).append(',');
            }
        }
        return change.toString();
    }

    LinkedHashMap<String, Float> getDescendinggSortedDenominations(Map<String, Float> unSortedMap) {
        LinkedHashMap<String, Float> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return reverseSortedMap;
    }

}
