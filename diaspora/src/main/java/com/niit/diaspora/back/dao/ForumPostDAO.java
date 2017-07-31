package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.ForumPost;

public interface ForumPostDAO {

	void saveOrUpdateForumPost(ForumPost forumPost);
	
	void deleteForumPost(String forumPostId);
	
	ForumPost getForumPost(String forumPostId);
	
	List<ForumPost> listForumPosts();
}
