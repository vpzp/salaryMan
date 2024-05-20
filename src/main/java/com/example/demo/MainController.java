package com.example.demo;

import com.example.demo.Post.Post;
import com.example.demo.Post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final PostService postService;

    @GetMapping("/")
    public String root() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Model model){
        List<Post> announcePost = postService.getPostByType("공지사항");
        List<Post> questionPost = postService.getPostByType("질문");
        model.addAttribute("announcePost", announcePost);
        model.addAttribute("questionPost", questionPost);
        return "main_form";
    }

}
