package softuni.bg.spotify.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.spotify.model.entity.Style;
import softuni.bg.spotify.model.entity.enums.StyleName;
import softuni.bg.spotify.repository.StyleRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StyleInit implements CommandLineRunner {
    private final StyleRepository styleRepository;

    public StyleInit(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        if(this.styleRepository.count() == 0){
//            List<Style> stylesList = new ArrayList<>();
//
//            Arrays.stream(StyleName.values()).forEach(styleName -> {
//                Style style = new Style();
//                style.setName(styleName);
//                style.setDescription(styleName.name());
//                stylesList.add(style);
//            });
//
//            this.styleRepository.saveAll(stylesList);
//        }
    }
}
