package com.arunkpatra.blog.service;

import com.arunkpatra.blog.exception.BlogException;
import com.arunkpatra.blog.model.Person;
import com.arunkpatra.blog.model.Post;

public interface BlogService {

    Post getPost(long id) throws BlogException;

    Person getPerson(long id) throws BlogException;

}
