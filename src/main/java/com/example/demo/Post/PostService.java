package com.example.demo.Post;

import com.example.demo.DataNotFoundException;
import com.example.demo.SiteUser.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    public Post getPost(Long id){
        Optional<Post> post = this.postRepository.findById(id);
        if (post.isPresent()){
            return post.get();
        }else{
            throw new DataNotFoundException("postFindById의 값이 존재하지 않습니다.");
        }
    }

    public void create(String subject, String content, String type){
        Post post = new Post();
        post.setContent(content);
        post.setSubject(subject);
        post.setType(type);
        this.postRepository.save(post);
    }

    public List<Post> getPostByType(String type){
        return this.postRepository.findByType(type);
    }
}
