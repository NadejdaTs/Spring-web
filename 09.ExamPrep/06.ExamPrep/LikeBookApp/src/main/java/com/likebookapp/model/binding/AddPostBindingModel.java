package com.likebookapp.model.binding;

import com.likebookapp.model.entity.enums.MoodName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPostBindingModel {
    @Size(message = "Content length must be between 2 and 50 characters!")
    private String content;

    @NotNull(message = "You must select a mood!")
//    @Enumerated(EnumType.STRING)
    private MoodName mood;
}
