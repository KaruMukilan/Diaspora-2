package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.Blog;


public interface BlogDAO {

	void saveOrUpdateBlog(Blog blog);

	void deleteBlog(String blogId);

	Blog getBlog(String blogId);

	List<Blog> listBlogs();

	List<Blog> listBlogsByCreatedAt(char status);

//	List<Blog> listofPendingBlogs(char status);
}
