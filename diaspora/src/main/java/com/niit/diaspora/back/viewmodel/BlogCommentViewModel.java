package com.niit.diaspora.back.viewmodel;

import com.niit.diaspora.back.model.Blog;
import com.niit.diaspora.back.model.BlogComment;

public class BlogCommentViewModel {

	private Blog blog;
	private BlogComment blogComment;
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public BlogComment getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(BlogComment blogComment) {
		this.blogComment = blogComment;
	}
	
	
	
	
}
