package com.imdadareeph.cashregister.functions;

import com.imdadareeph.cashregister.domain.configs.CashRegisterConfigs;
import com.imdadareeph.cashregister.domain.configs.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

/**
 * Author : Imdad Areeph
 */
@Component
public class ConfigurationFunction implements Supplier<List<Currencies>> {
    @Autowired
    private CashRegisterConfigs cashRegisterConfigs;


    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public List<Currencies> get() {
        return cashRegisterConfigs.getCurrencies();
    }
}
