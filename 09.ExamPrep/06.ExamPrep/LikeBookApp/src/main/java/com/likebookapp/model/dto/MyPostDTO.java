package com.likebookapp.model.dto;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.enums.MoodName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyPostDTO {
    private String id;
    private String mood;
    private int likes;
    private String content;

    public static MyPostDTO createFromTask(Post post){
        MyPostDTO myPostDTO = new MyPostDTO();

        myPostDTO.setId(post.getId());
        myPostDTO.setMood(post.getMood().getDescription());
        myPostDTO.setContent(post.getContent());
        myPostDTO.setLikes(post.getLikes().size());

        return myPostDTO;
    }
}
