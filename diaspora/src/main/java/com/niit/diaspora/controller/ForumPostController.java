package com.niit.diaspora.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.diaspora.back.dao.ForumDAO;
import com.niit.diaspora.back.dao.ForumPostDAO;
import com.niit.diaspora.back.model.Forum;
import com.niit.diaspora.back.model.ForumPost;
import com.niit.diaspora.back.utility.IdGenerator;
import com.niit.diaspora.back.viewmodel.ForumModel;

@RestController
public class ForumPostController {
	
	@Autowired
	ForumDAO forumDAO;
	@Autowired 
	ForumPostDAO forumPostDAO;
	
	@Autowired
	Forum forum;
	
	@Autowired
	ForumPost forumPost;
	

	@PostMapping("/forumPost")
	public ResponseEntity<ForumPost> addPost(@RequestBody ForumModel forumModel,UriComponentsBuilder ucBuilder){
//		forumModel.setForum(forumModel.getForum());
//		forumModel.setForumPost(forumModel.getForumPost());
		//forumModel.getForumPost().setForumPostContent(forumModel.getForumPost().getForumPostContent());
		
		
		forumPost.setForumPostId(IdGenerator.generateId("FRMPOST"));
		forumPost.setForumPostContent(forumModel.getPost());
		/*forumPost.setForumPostContent(forumPost.get);*/
		//forumModel.getForumPost().setForumPostContent(forumPost.setForumPostContent(forumPostContent););
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		forumPost.setPostedAt(timestamp);
		forumPost.setUserId("USR001");
		forumPost.setForum(forumModel.getForum());
		forumPostDAO.saveOrUpdateForumPost(forumPost);
		
		this.forum = forumDAO.getForum(forumModel.getForum().getForumId());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/forumPost/{forumPostId}").buildAndExpand(forumPost.getForumPostId()).toUri());
		return new ResponseEntity<ForumPost>(forumPost,httpHeaders,HttpStatus.OK);
	}
	
}
