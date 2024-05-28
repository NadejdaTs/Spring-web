package softuni.bg.shopping.model.entity.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginBindingModel {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    private String username;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    private String password;
}
