package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.UserDetail;

public interface UserDetailDAO {

	void saveOrUpdateUserDetail(UserDetail userDetail);
	
	void deleteUserDetail(String userId);
	
	UserDetail getUserDetail(String userId);
	
	List<UserDetail> listUserDetails();
	
	UserDetail getUserByEmail(String email);
	
	UserDetail checkUser(String email,String password);
}
