package bg.softuni.pathfinder.models.dto;

import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.models.enums.CategoryName;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AddRouteBindingModel {

    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private Set<CategoryName> categories;
}
