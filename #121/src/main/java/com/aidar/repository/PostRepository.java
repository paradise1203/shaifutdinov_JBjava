package com.aidar.repository;

import com.aidar.model.Post;
import com.aidar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    public List<Post> findByOwnerOrderByDateDesc(User user);

}
