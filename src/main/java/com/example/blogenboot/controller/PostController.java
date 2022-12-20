package com.example.blogenboot.controller;

import com.example.blogenboot.ds.Category;
import com.example.blogenboot.ds.Post;
import com.example.blogenboot.ds.User;
import com.example.blogenboot.service.BlogenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PostController {
    @Autowired
    private BlogenService blogenService;

    @GetMapping(value = {"/","/home"})
    public String index(Model model){
        model.addAttribute("category",new Category());
        model.addAttribute("user",new User());
        model.addAttribute("post",new Post());
        return "dashboard";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result){
        if (result.hasErrors()){
            return "dashboard";
        }
        System.out.println(category);
        blogenService.saveCategory(category);
        return "redirect:/";
    }
    @GetMapping("/list-categories")
    public String listAllCategories(Model model){
        model.addAttribute("categories",blogenService.findAllCategories());
        return "list-categories";
    }
    @PostMapping("/save-user")
    public String saveUser(User user, BindingResult result){
        if (result.hasErrors()){
            return "dashboard";
        }
        System.out.println(user);
        blogenService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/list-users")
    public String listAllUser(Model model){
        model.addAttribute("users",blogenService.findAllUsers());
        return "list-users";
    }
    @PostMapping("/save-post")
    public String savePost(Post post, BindingResult result){
        if (result.hasErrors()){
            return "dashboard";
        }
        System.out.println(post);
        blogenService.savePost(post);
        return "redirect:/";
    }
    @GetMapping("/list-posts")
    public String listAllPost(Model model){
        model.addAttribute("posts",blogenService.findAllPosts());
        return "list-posts";
    }
}
