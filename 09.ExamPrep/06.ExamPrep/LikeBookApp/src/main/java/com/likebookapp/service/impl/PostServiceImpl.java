package com.likebookapp.service.impl;

import com.likebookapp.model.LoggedUser;
import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.model.dto.AllOtherPostsDTO;
import com.likebookapp.model.dto.MyPostDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.model.view.HomeViewModel;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final LoggedUser loggedUser;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, MoodRepository moodRepository, LoggedUser loggedUser) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public void addPost(AddPostBindingModel addPostBindingModel) {
        Optional<Post> optPost = this.postRepository.findByContent(addPostBindingModel.getContent());
        if(!optPost.isPresent() && addPostBindingModel.getMood() != null){
            Post post = new Post();

            Mood mood = this.moodRepository.findByName(addPostBindingModel.getMood());
            Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());
            post.setContent(addPostBindingModel.getContent());
            post.setMood(mood);
            post.setUser(optUser.get());
            this.postRepository.save(post);
        }
    }

    @Override
    public HomeViewModel getHomeViewData() {
        Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());

        List<MyPostDTO> myPosts = this.postRepository.findByUser(optUser.get()).stream()
                .map(MyPostDTO::createFromTask)
                .toList();

        List<AllOtherPostsDTO> otherPosts = this.postRepository.findByUserNot(optUser.get()).stream()
                .map(AllOtherPostsDTO::createFromTask)
                .toList();


        return new HomeViewModel(myPosts, otherPosts);
    }

    @Override
    public void likePost(String id) {
        Optional<Post> optPost = this.postRepository.findById(id);
        Optional<User> optUser = this.userRepository.findByUsername(this.loggedUser.getUsername());

        User user = optUser.get();
        Post post = optPost.get();

        List<User> likes = post.getLikes();
        if(!likes.contains(user)){
            likes.add(user);
            post.setLikes(likes);
            this.postRepository.save(post);
        }
    }

    @Override
    public void remove(String id) {
        Optional<Post> optPost = this.postRepository.findById(id);
        this.postRepository.delete(optPost.get());
    }
}
