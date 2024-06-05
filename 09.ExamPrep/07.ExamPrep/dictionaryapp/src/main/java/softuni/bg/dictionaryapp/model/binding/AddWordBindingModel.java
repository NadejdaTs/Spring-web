package softuni.bg.dictionaryapp.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.dictionaryapp.validation.annotation.InputDateValidation;

import java.time.LocalDate;

@Getter
@Setter
public class AddWordBindingModel {
    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;

    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 80 characters!")
    private String translation;

    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")
    private String example;

    @InputDateValidation
    private String inputDate;

//    @NotNull(message = "You must select a language!")
    @NotBlank(message = "You must select a language!")
    private String language;
}
