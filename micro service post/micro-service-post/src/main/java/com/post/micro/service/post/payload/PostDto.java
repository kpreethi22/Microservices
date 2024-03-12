package com.post.micro.service.post.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String postId;
    private String Title;
    private String Description;
    private String Content;
    List<Comment>comments;
}
