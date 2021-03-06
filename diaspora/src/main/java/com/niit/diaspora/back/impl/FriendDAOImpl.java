package com.niit.diaspora.back.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.diaspora.back.dao.FriendDAO;
import com.niit.diaspora.back.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Friend> getOfFriends(String userId, char status) {
		String hql = "from Friend where friendUser=:userId and status=:status";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId)
				.setParameter("status", status);
		List<Friend> listOfFriends = query.getResultList();
		return listOfFriends;
	}

	@Override
	public Friend getFriend(String user1, String user2, char status) {
		String hql = "from Friend where user1=:user1 and friendUser=:user2 and status=:status";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("user1", user1)
				.setParameter("user2", user2).setParameter("status", status);
		List<Friend> listOfFriend = query.getResultList();
		if (listOfFriend != null && !listOfFriend.isEmpty())
			return listOfFriend.get(0);
		return null;
	}

	@Override
	public void sendRequest(Friend friend) {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);

	}

	@Override
	public void acceptRequest(Friend friend) {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);

	}

	@Override
	public void rejectRequest(Friend friend) {
		sessionFactory.getCurrentSession().delete(friend);

	}

	@Override
	public List<Friend> getUnFriends(String userId, char status) {
		String hql = "from Friend where user1=:userId and status!=:status";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId)
				.setParameter("status", status);
		List<Friend> listOfFriends = query.getResultList();
		return listOfFriends;
	}

	@Override
	public List<Friend> getFriends(String userId, char status) {
		String hql = "from Friend where user1=:userId and status=:status";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId)
				.setParameter("status", status);
		List<Friend> listOfFriends = query.getResultList();
		return listOfFriends;
		
	}
	
	@Override
	public List<Friend> getRequested(String userId, char status) {
		String hql = "from Friend where friendUser=:userId and status=:status";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId)
				.setParameter("status", status);
		List<Friend> listOfFriends = query.getResultList();
		return listOfFriends;
		
	}
	
	

	@Override
	public List<Friend> listFriends() {
		String hql = "from Friend ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> listOfFriends = query.getResultList();
		return listOfFriends;
	
	}

}
