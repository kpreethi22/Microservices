package com.comment.micro.service.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")


public class Comment {
    @Id
    private String commentId;
    private String name;
    private String email;
    private String body;
    private String postId;

}
