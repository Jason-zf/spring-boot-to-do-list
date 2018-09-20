package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.Tag;
import com.thoughtworks.training.springboottodolist.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }
}
