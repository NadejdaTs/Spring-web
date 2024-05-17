package bg.softuni.pathfinder.models.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RouteDetailsViewModel {
    private String description;
    private String videoUrl;
//    TODO pass coordinates
}
