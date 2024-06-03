package com.likebookapp.model.dto;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.enums.MoodName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOtherPostsDTO {
    private String id;
    private String username;
    private String content;
    private String mood;
    private int likes;

    public static AllOtherPostsDTO createFromTask(Post post){
        AllOtherPostsDTO allOtherPostsDTO = new AllOtherPostsDTO();

        allOtherPostsDTO.setId(post.getId());
        allOtherPostsDTO.setUsername(post.getUser().getUsername());
        allOtherPostsDTO.setContent(post.getContent());
        allOtherPostsDTO.setMood(post.getMood().getDescription());
        allOtherPostsDTO.setLikes(post.getLikes().size());

        return allOtherPostsDTO;
    }
}
