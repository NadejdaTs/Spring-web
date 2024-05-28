package softuni.bg.shopping.service;

import softuni.bg.shopping.model.entity.view.HomeViewModel;

public interface ProductService {
    HomeViewModel getHomeViewData(String username);
}
