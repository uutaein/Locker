package com.locker.blog.service.comment;

import com.locker.blog.domain.comment.Comment;
import com.locker.blog.repository.comment.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepo commentRepo;

    @Override
    public int insert(Comment comment) {
        return commentRepo.insert(comment);
    }

    @Override
    public int delete(Long pid) {
        return commentRepo.delete(pid);
    }

    @Override
    public List<Comment> selectAll() {
        return commentRepo.selectAll();
    }

    @Override
    public int update(Comment comment) {
        return commentRepo.update(comment);
    }


}
