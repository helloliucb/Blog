package com.example.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springboot.entity.Comment;
import com.example.springboot.service.BlogService;
import com.example.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;


    @GetMapping("/comments/{blogId}")
    public String Comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment){
        Long blogId= comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        comment.setAvatar("${comment.avatar}");
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }


}
