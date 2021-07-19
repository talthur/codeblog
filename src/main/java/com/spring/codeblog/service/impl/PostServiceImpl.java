package com.spring.codeblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.ModelRepository;
import com.spring.codeblog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	ModelRepository modelRepository;
	
	@Override
	public List<Post> findAll() {
		return modelRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return modelRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return modelRepository.save(post);
	}

	
}
