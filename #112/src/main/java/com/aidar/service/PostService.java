package com.aidar.service;

import com.aidar.model.Post;
import com.aidar.model.User;

import java.util.List;

public interface PostService {

    public List<Post> getPosts(User user);

    public void addPost(User user, String text);

    public void addPost(User author, User owner, String text);

}
