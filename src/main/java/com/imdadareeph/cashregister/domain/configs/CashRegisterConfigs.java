package com.imdadareeph.cashregister.domain.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "services.cashregister")
@Getter
@Setter
public class CashRegisterConfigs {

    List<Currencies> currencies;

}
