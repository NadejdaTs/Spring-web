package softuni.bg.shopping.model.entity.view;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.shopping.model.entity.dto.ProductsDTO;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class HomeViewModel {
    Set<ProductsDTO> products;

    public HomeViewModel(){
        this.products = new HashSet<>();
    }

    public HomeViewModel(Set<ProductsDTO> products) {
        this.products = products;
    }
}
