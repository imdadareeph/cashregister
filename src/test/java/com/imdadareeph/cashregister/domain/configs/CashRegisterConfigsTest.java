package com.imdadareeph.cashregister.domain.configs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(value = CashRegisterConfigs.class)
class CashRegisterConfigsTest {

    @Autowired
    private CashRegisterConfigs cashRegisterConfigs;

    @BeforeEach
    void setUp() {
    }


    @Test
    public void whenYamlHasLists_thenLoadListValuess() {
        List<Currencies> currencies = cashRegisterConfigs.getCurrencies();
        Currencies firstCurrency = currencies.get(0);
        String scalePrecision = firstCurrency.getPrecision();
        assertThat(scalePrecision).isEqualTo("2");

    }

    @Test
    public void whenYamlHasMap_thenLoadMapValues() {
        List<Currencies> currencies = cashRegisterConfigs.getCurrencies();
        Currencies firstCurrency = currencies.get(0);
        Map<String, String> stringStringMapFirst = firstCurrency.getDenominations().get(0);
        String nameFirst = stringStringMapFirst.get("name");
        assertThat(nameFirst).isEqualTo("PENNY");
    }
}