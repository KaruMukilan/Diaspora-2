package com.niit.diaspora.back.dao;

import com.niit.diaspora.back.model.Users;

public interface UserDAO {

	void saveOrUpdateUser(Users user);
	
	void deleteUser(String email);
	
	Users getUser(String userId);
	
}
