package com.imdadareeph.cashregister.domain.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "currencies")
@Getter
@Setter
public class Currencies {
    private String name;
    private String countryCode;
    private String precision;
    private List<Map<String, String>> denominations;

}
