package com.resellerapp.model;

import com.resellerapp.model.enums.ConditionName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OfferCreateBindingModel {
    private String description;
    private BigDecimal price;
    private ConditionName condition;
}
