package softuni.bg.shopping.service;

import softuni.bg.shopping.model.entity.binding.AddProductBindingModel;
import softuni.bg.shopping.model.entity.view.HomeViewModel;

import java.math.BigDecimal;

public interface ProductService {
    HomeViewModel getHomeViewData();

    boolean addProduct(AddProductBindingModel addProductBindingModel);

    BigDecimal buy(String id);
}
