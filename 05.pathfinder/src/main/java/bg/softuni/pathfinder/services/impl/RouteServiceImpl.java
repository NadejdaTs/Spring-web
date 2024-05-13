package bg.softuni.pathfinder.services.impl;

import bg.softuni.pathfinder.models.Category;
import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dto.AddRouteBindingModel;
import bg.softuni.pathfinder.repositories.CategoryRepository;
import bg.softuni.pathfinder.repositories.RouteRepository;
import bg.softuni.pathfinder.services.RouteService;
import bg.softuni.pathfinder.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final ModelMapper mapper;

    public RouteServiceImpl(RouteRepository routeRepository, CategoryRepository categoryRepository, UserService userService, ModelMapper mapper) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = this.mapper.map(addRouteBindingModel, Route.class);
        route.getCategories().clear();
        Set<Category> categories = categoryRepository.findByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);
        Optional<User> user = userService.getLoggedUser();
        route.setAuthor(user.get());
        routeRepository.save(route);
    }
}
