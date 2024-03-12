package com.post.micro.service.post.service;

import com.post.micro.service.post.config.RestTemplateConfig;
import com.post.micro.service.post.entity.Post;
import com.post.micro.service.post.payload.Comment;
import com.post.micro.service.post.payload.PostDto;
import com.post.micro.service.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class PostService {
    @Autowired
    public PostRepository postRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;
    public Post savePost(Post post) {
        String postId= UUID.randomUUID().toString();
        post.setId(postId);
        Post savedPost = postRepository.save(post);
        return savedPost;

    }

    public Post getByPostId(String postId) {
        Optional<Post> byId = postRepository.findById(postId);
        return byId.get();
    }

    public PostDto getPostWithComments(String postId) {
        Post post = postRepository.findById(postId).get();
        ArrayList comments = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8081/api/comments/" +postId, ArrayList.class);
    PostDto postDto=new PostDto();
    postDto.setPostId(post.getId());
    postDto.setTitle(post.getTitle());
    postDto.setDescription(post.getDescription());
    postDto.setContent(post.getContent());
    postDto.setComments(comments);
    return postDto;


    }
}
