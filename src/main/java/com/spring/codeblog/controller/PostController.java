package com.spring.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;

	@GetMapping(value = "/posts")
	public ModelAndView getPost() {

		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		mv.addObject("posts", posts);
		return mv;

	}
	
	@GetMapping(value = "/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = postService.findById(id);
		mv.addObject("post", post);
		return mv;
		
	}

}
