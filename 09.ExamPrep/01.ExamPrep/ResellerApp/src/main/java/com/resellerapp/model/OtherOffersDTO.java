package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OtherOffersDTO extends MyOfferDTO{
    private String sellerUsername;

    public OtherOffersDTO(Offer offer) {
        super(offer);
        this.sellerUsername = offer.getCreatedBy().getUsername();
    }
}
