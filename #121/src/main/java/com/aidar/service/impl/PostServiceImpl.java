package com.aidar.service.impl;

import com.aidar.model.Post;
import com.aidar.model.User;
import com.aidar.repository.PostRepository;
import com.aidar.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getPosts(User user) {
        return (List<Post>) postRepository.findByOwnerOrderByDateDesc(user);
    }

    @Override
    public void addPost(User user, String text) {
        postRepository.save(new Post(text, new Date(), user, user));
    }

    @Override
    public void addPost(User author, User owner, String text) {
        postRepository.save(new Post(text, new Date(), author, owner));
    }

}
