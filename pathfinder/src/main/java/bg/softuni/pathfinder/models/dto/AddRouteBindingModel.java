package bg.softuni.pathfinder.models.dto;

import bg.softuni.pathfinder.models.enums.Level;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRouteBindingModel {

    private String name;
    private String description;
    private Level level;
    private String videoUrl;

}
