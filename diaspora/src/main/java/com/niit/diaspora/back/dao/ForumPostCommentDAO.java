package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.ForumPostComment;

public interface ForumPostCommentDAO {

	void saveOrUpdateForumPostComment(ForumPostComment forumPostComment);

	void deleteForumPostComment(String forumPostCommentId);

	ForumPostComment getForumPostComment(String forumPostCommentId);

	List<ForumPostComment> listForumPostComments();
}
