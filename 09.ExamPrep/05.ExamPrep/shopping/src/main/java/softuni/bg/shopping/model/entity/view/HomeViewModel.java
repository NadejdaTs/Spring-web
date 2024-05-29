package softuni.bg.shopping.model.entity.view;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.shopping.model.entity.dto.ProductsDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HomeViewModel {
    private List<ProductsDTO> foods;
    private List<ProductsDTO> drinks;
    private List<ProductsDTO> households;
    private List<ProductsDTO> other;
    private BigDecimal totalPrice;

    public HomeViewModel(){
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.households = new ArrayList<>();
        this.other = new ArrayList<>();
    }

    public HomeViewModel(List<ProductsDTO> foods, List<ProductsDTO> drinks, List<ProductsDTO> households, List<ProductsDTO> other, BigDecimal totalPrice) {
        this.foods = foods;
        this.drinks = drinks;
        this.households = households;
        this.other = other;
        this.totalPrice = totalPrice;
    }
}
