package com.spring.codeblog.utils;

import java.util.Comparator;

import com.spring.codeblog.model.Post;

public class SortByDate implements Comparator<Post>{
	public int compare(Post a, Post b) {
		return b.getData().compareTo(a.getData());
	}
}
