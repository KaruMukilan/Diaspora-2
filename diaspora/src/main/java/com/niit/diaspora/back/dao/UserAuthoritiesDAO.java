package com.niit.diaspora.back.dao;



import com.niit.diaspora.back.model.UserAuthorities;

public interface UserAuthoritiesDAO {

	void saveOrUpdateUserAuthority(UserAuthorities userAuthorities);
	
	void deleteUserAuthority(String email);
	
	UserAuthorities getUserAuthority(String userId);
}
