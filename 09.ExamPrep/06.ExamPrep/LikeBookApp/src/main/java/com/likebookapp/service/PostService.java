package com.likebookapp.service;

import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.model.view.HomeViewModel;

public interface PostService {
    void addPost(AddPostBindingModel addPostBindingModel);

    void likePost(String id);

    HomeViewModel getHomeViewData();

    void remove(String id);
}
