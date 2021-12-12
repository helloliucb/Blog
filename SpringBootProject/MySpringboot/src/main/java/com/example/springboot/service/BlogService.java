package com.example.springboot.service;

import com.example.springboot.entity.Blog;
import com.example.springboot.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BlogService{
    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Page<Blog> listBlog(String query,Pageable pageable);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();


    List<Blog> listRecommendBlogTop(Integer size);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
