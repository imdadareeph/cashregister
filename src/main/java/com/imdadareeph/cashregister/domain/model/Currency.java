package com.imdadareeph.cashregister.domain.model;


import com.imdadareeph.cashregister.domain.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "CURRENCY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "CURRENCY_TYPE")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
}
