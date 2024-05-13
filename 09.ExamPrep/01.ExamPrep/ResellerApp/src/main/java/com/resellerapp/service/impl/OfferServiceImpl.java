package com.resellerapp.service.impl;

import com.resellerapp.model.*;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final LoggedUser loggedUser;
    private UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ConditionRepository conditionRepository, LoggedUser loggedUser, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public OfferHomeDTO getOffersForHomePage() {
        List<Offer> offers = this.offerRepository.findAll();
        List<MyOfferDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();

        for (int i = 0; i < offers.size(); i++) {
            Offer offer = offers.get(i);
            String loggedUsername = loggedUser.getUsername();
            if(offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUsername)){
                myOffers.add(new MyOfferDTO(offer));
            }else if(offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUsername)){
                boughtOffers.add(new BoughtOffersDTO(offer));
            }else if(offer.getBoughtBy() == null){
                otherOffers.add(new OtherOffersDTO(offer));
            }
        }

        OfferHomeDTO dto = new OfferHomeDTO(myOffers, boughtOffers, otherOffers);
        return dto;
    }

    @Override
    public boolean create(OfferCreateBindingModel offerCreateBindingModel) {
        Condition condition = this.conditionRepository.findByName(offerCreateBindingModel.getCondition());
        User user = this.userRepository.findByUsername(loggedUser.getUsername());
        if(condition != null && user != null){
            Offer offer = new Offer(offerCreateBindingModel, condition, user);
            this.offerRepository.save(offer);
            return true;
        }
        return false;
    }

    @Override
    public void buy(UUID id) {
        Optional<Offer> optOffer = this.offerRepository.findById(id);
        if(optOffer.isPresent()){
            User user = this.userRepository.findByUsername(loggedUser.getUsername());
            Offer offer = optOffer.get();
            offer.setBoughtBy(user);
            this.offerRepository.save(offer);
        }
    }

//    @Override
//    public void remove(UUID id) {
//        Optional<Offer> optOffer = this.offerRepository.findById(id);
//        this.offerRepository.remove(optOffer.get());
//    }
}
