package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "priorities")
@Getter
@Setter
public class Priority extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PriorityName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority")
    private Set<Task> tasks;

    public void setName(PriorityName name) {
        this.name = name;
        setDescription(name);
    }

    private void setDescription(PriorityName name){
        String description = "";
        switch(name){
            case URGENT -> description = "An urgent problem that blocks the system use until the issue is resolved.";
            case IMPORTANT -> description = "A core functionality that your product is explicitly supposed to perform is compromised.";
            case LOW -> description = "Should be fixed if time permits but can be postponed.";
        }
        this.description = description;
    }
}
