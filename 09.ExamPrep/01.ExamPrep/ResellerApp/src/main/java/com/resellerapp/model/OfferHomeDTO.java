package com.resellerapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OfferHomeDTO {
    private List<MyOfferDTO> myOffers;
    private List<BoughtOffersDTO> boughtOffers;
    private List<OtherOffersDTO> allOtherOffers;
    private long totalOtherOffers;

    public OfferHomeDTO(List<MyOfferDTO> myOffers, List<BoughtOffersDTO> boughtOffers, List<OtherOffersDTO> otherOffers) {
        this.myOffers = myOffers;
        this.boughtOffers = boughtOffers;
        this.allOtherOffers = otherOffers;
        this.totalOtherOffers = otherOffers.size();
    }
}
