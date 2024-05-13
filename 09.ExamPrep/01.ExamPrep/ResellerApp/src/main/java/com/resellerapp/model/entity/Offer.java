package com.resellerapp.model.entity;

import com.resellerapp.model.OfferCreateBindingModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="offers")
@Getter
@Setter
@NoArgsConstructor
public class Offer extends BaseEntity{
    @NotNull
    @Length(min = 2, max = 50)
    private String description;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @NotNull
    @ManyToOne
    private Condition condition;

    @ManyToOne
    @NotNull
    private User createdBy;

    @ManyToOne
    private User boughtBy;

    public Offer(OfferCreateBindingModel offerCreateBindingModel, Condition condition, User createdBy) {
        this.description = offerCreateBindingModel.getDescription();
        this.price = offerCreateBindingModel.getPrice();
        this.condition = condition;
        this.createdBy = createdBy;
    }
}
