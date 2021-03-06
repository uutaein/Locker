package com.locker.blog.repository.post;

import com.locker.blog.domain.post.PagingPost;
import com.locker.blog.domain.post.Post;
import com.locker.blog.domain.repository.HotRepository;
import com.locker.blog.domain.tag.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PostDAO {
    public int insert(Post p);
    public int delete(String post_id);
    public List<PagingPost> selectAll(Map<String,Long> pageMap);
    public Post selectOne(String post_id);
    public int update(Post post);
    public List<Post> selectAllByWriter(Long usrId);
    public int addLike(Long pid);
    public List<Post> commonSearch(Map pageMap);
    public List<Post> tagSearch(Map pageMap);
    public Long getNextpid();
    public Long getPrevPage(Long pid);
    public Long getNextPage(Long pid);
    public List<HotRepository> getHotRepos();
    public int updatePicture(Post post);
    public List<Post> getALLRepoPost(Long repo_id);
    public List<Post> getHotRepoPosts(Long repo_id);
}
