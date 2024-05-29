package softuni.bg.shopping.model.entity.dto;

import lombok.Getter;
import lombok.Setter;
import softuni.bg.shopping.model.entity.Product;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductsDTO {
    private String id;
    private String name;
    private BigDecimal price;

    public static ProductsDTO createFromTask(Product product){
        ProductsDTO productsDTO = new ProductsDTO();

        productsDTO.setId(product.getId());
        productsDTO.setName(product.getName());
        productsDTO.setPrice(product.getPrice());

        return productsDTO;
    }
}
