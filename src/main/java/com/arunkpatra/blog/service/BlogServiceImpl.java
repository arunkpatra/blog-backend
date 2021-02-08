package com.arunkpatra.blog.service;

import com.arunkpatra.blog.entity.PersonEntity;
import com.arunkpatra.blog.entity.PostEntity;
import com.arunkpatra.blog.exception.BlogException;
import com.arunkpatra.blog.model.Person;
import com.arunkpatra.blog.model.Post;
import com.arunkpatra.blog.repository.PersonRepository;
import com.arunkpatra.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private final PostRepository postRepository;
    private final PersonRepository personRepository;

    public BlogServiceImpl(PostRepository postRepository, PersonRepository personRepository) {
        this.postRepository = postRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Post getPost(long id) throws BlogException {

        Optional<PostEntity> p = postRepository.findById(id);
        if (p.isPresent()) {
            return new Post(p.get().getId(), p.get().getTitle(),
                    p.get().getBody());
        } else {
            throw new BlogException("Post not found");
        }
    }

    @Override
    public Person getPerson(long id) throws BlogException {
        Optional<PersonEntity> p = personRepository.findById(id);
        if (p.isPresent()) {
            return new Person(p.get().getId(), p.get().getFirstName(),
                    p.get().getLastName());
        } else {
            throw new BlogException("Person not found");
        }
    }
}
