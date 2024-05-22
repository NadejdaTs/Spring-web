package softuni.bg.Gira.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginBindingModel {
//    @Email
//    @NotNull(message = "Email cant be empty!")
//    @NotEmpty(message = "Email cant be empty!")
    @Size(min = 1, message = "Email cant be empty!")
    private String email;

    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;
}
