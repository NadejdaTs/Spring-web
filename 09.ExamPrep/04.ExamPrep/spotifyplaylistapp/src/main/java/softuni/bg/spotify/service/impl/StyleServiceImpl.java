package softuni.bg.spotify.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.spotify.model.entity.Style;
import softuni.bg.spotify.model.entity.enums.StyleName;
import softuni.bg.spotify.repository.StyleRepository;
import softuni.bg.spotify.service.StyleService;

@Service
public class StyleServiceImpl implements StyleService {
    private StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

//    @Override
//    public Style findStyleByName(StyleName styleName) {
//        return this.styleRepository.findByStyle(styleName).orElseThrow();
//    }
}
