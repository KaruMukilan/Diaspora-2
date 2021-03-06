package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.Friend;

public interface FriendDAO {

	List<Friend> getOfFriends(String userId, char status);
	
	Friend getFriend(String user1,String user2,char status);
	
	List<Friend> getUnFriends(String userId,char status);

	void sendRequest(Friend friend);

	void acceptRequest(Friend friend);

	void rejectRequest(Friend friend);
	
	List<Friend> getFriends(String userId,char status);
	
	List<Friend> listFriends();
	
	 List<Friend> getRequested(String userId, char status);
}
