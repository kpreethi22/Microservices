package com.comment.micro.service.comment.service;

import com.comment.micro.service.comment.config.RestTemplateConfig;
import com.comment.micro.service.comment.entity.Comment;
import com.comment.micro.service.comment.payload.Post;
import com.comment.micro.service.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    public CommentRepository commentRepo;
    @Autowired
    private RestTemplateConfig restTemplate;
    public Comment saveComment(Comment comment){
        Post post = restTemplate.getRestTemplate().getForObject("http://localhost:8081/api/posts/" + comment.getPostId(), Post.class);
if(post!=null){
    String commentId = UUID.randomUUID().toString();
    comment.setCommentId(commentId);
    Comment savedComment = commentRepo.save(comment);
    return savedComment;
}else{
   return null;
}
    }

    public List<Comment> getCommentsByPostId(String postId) {
        List<Comment>comments=commentRepo.findByPostId(postId);
        return comments;
    }
}
