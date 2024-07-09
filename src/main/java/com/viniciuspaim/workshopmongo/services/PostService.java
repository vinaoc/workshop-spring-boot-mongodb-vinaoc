package com.viniciuspaim.workshopmongo.services;


import com.viniciuspaim.workshopmongo.domain.Post;
import com.viniciuspaim.workshopmongo.repository.PostRepository;
import com.viniciuspaim.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public Post findById(String id) {
        Optional<Post> post = this.repo.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new ObjectNotFoundException("Post not found");
        }
    }

    public List<Post> findByTitle(String text) {
        return  repo.findByTitleContainingIgnoreCase(text);
    }
}
