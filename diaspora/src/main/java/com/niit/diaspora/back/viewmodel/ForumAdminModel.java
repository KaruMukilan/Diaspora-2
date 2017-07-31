package com.niit.diaspora.back.viewmodel;

import com.niit.diaspora.back.model.Forum;

public class ForumAdminModel {

	private Forum forum;
	private String email;
	private String name;
	private String role;
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
