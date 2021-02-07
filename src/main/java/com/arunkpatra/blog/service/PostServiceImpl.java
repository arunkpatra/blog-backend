package com.arunkpatra.blog.service;

import com.arunkpatra.blog.model.Post;
import com.arunkpatra.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getPost(long id) {
        return postRepository.findById(id).map(postEntity -> new Post(postEntity.getId(), postEntity.getTitle(),
                postEntity.getBody())).orElse(null);
    }
}
