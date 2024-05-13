package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BoughtOffersDTO {
    private String description;
    private BigDecimal price;

    public BoughtOffersDTO(Offer offer) {
        this.description = offer.getDescription();
        this.price = offer.getPrice();
    }
}
