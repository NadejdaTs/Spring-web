package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "moods")
@Getter
@Setter
public class Mood extends BaseEntity{
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private MoodName name;

    @Column
    private String description;
}
