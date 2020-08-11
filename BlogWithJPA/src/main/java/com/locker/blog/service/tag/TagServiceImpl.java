package com.locker.blog.service.tag;

import com.locker.blog.domain.post.Post;
import com.locker.blog.domain.tag.PostTag;
import com.locker.blog.domain.tag.Tag;
import com.locker.blog.repository.tag.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    TagRepo tagRepo;

    @Override
    public Tag isDuptag(String name) {
        return tagRepo.isDuptag(name);
    }

    @Override
    public int insertNewTag(Tag tag) {
        return tagRepo.insertNewTag(tag);
    }

    @Override
    public int connectTag(PostTag posttag) {
        return tagRepo.connectTag(posttag);
    }

    @Override
    public List<Post> selectAll(String name) {
        return tagRepo.selectAll(name);
    }
}