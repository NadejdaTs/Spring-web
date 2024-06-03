package com.likebookapp.model.view;

import com.likebookapp.model.dto.AllOtherPostsDTO;
import com.likebookapp.model.dto.MyPostDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HomeViewModel {
    private List<MyPostDTO> myPosts;
    private List<AllOtherPostsDTO> otherPosts;
    private int allOtherPosts;

    public HomeViewModel(){
        this.myPosts = new ArrayList<>();
        this.otherPosts = new ArrayList<>();
        this.allOtherPosts = 0;
    }

    public HomeViewModel(List<MyPostDTO> myPosts, List<AllOtherPostsDTO> otherPosts){
        this.myPosts = myPosts;
        this.otherPosts = otherPosts;
        this.allOtherPosts = otherPosts.size();
    }
}
