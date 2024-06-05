package softuni.bg.dictionaryapp.service;

import softuni.bg.dictionaryapp.model.binding.AddWordBindingModel;
import softuni.bg.dictionaryapp.model.view.HomeViewModel;

public interface WordService {
    HomeViewModel getHomeViewData();

    void addWord(AddWordBindingModel addPostBindingModel);
}
