package com.devsenior.alara.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.alara.model.Post;

@Repository
public class PostRepository {

    private List<Post> posts = new ArrayList<>();
    private Long idCounter = 1L;

    public Post guardar(Post post){
        this.idCounter++;
        post.setId(idCounter);
        return post;
    }

    public List<Post> findAll(){
        return this.posts;
    }


}
