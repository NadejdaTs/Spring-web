package bg.softuni.pathfinder.models.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@SuperBuilder
public class UserProfileViewModel {
    private String fullName;
    private String username;
    private int age;
}
