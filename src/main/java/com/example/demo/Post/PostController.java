package com.example.demo.Post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);

        return "post_detail";
    }
}
