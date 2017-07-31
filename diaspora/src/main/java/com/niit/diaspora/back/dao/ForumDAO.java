package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.Forum;

public interface ForumDAO {

	void saveOrUpdateForum(Forum forum);

	void deleteForum(String forumId);

	Forum getForum(String forumId);

	List<Forum> listForums();
	
	List<Forum> listForumByCreatedAt(char status);
}
