package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class MyOfferDTO extends BoughtOffersDTO{
    private UUID id;
    private ConditionName condition;

    public MyOfferDTO(Offer offer) {
        super(offer);
        this.id = offer.getId();
        this.condition = offer.getCondition().getName();
    }
}
