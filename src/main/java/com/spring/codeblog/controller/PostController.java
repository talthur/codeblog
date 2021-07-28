package com.spring.codeblog.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.PostService;
import com.spring.codeblog.utils.SortByDate;

@Controller
public class PostController {

	@Autowired
	PostService postService;

	@GetMapping(value = {"/posts", "/"})
	public ModelAndView getPost() {

		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		Collections.sort(posts, new SortByDate());
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
	
	
	@GetMapping(value = "/newpost")
	public String getPostForm() {
		return "postForm";
	}
	
	@PostMapping(value = "/newpost")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("mensagem", "Verifique se todos os campos obrigatórios foram preenchidos");
			return "redirect:/newpost";
		}
			post.setData(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		postService.save(post);
		return "redirect:/posts";
	} 
	
	@DeleteMapping(value = "/posts/{id}")
	public String deletePost(@PathVariable("id") long id) {
		System.out.println("entrou aqui");
		Post postToBeDeleted = postService.findById(id);
		postService.delete(postToBeDeleted);
		return "redirect:/posts";
	}

}
