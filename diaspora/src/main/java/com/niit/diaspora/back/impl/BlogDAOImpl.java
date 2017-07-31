package com.niit.diaspora.back.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.diaspora.back.dao.BlogDAO;
import com.niit.diaspora.back.model.Blog;


@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void saveOrUpdateBlog(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);

	}

	@Transactional
	@Override
	public void deleteBlog(String blogId) {
		Blog blogTodelete = new Blog();
		blogTodelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogTodelete);

	}

	@Transactional
	@Override
	public Blog getBlog(String blogId) {
		String hql = "from Blog where blogId=:blogId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("blogId",blogId);
		List<Blog> gotBlog = query.getResultList();
		if (gotBlog != null && !gotBlog.isEmpty())
			return gotBlog.get(0);
		return null;
	}

	@Transactional
	@Override
	public List<Blog> listBlogs() {
		String hql = "from Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> listOfBlogs = query.getResultList();
		return listOfBlogs;
	}

	@Transactional
	@Override
	public List<Blog> listBlogsByCreatedAt(char status) {
		String hql = "from Blog  where status=:status ORDER BY createdAt desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("status", status);
		List<Blog> listOfBlogs = query.getResultList();
		return listOfBlogs;
		
	}

/*	@Transactional
	public List<Blog> listofPendingBlogs(char status){
		String hql ="from Blog where status=:status";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql).setParameter("status", status);
		List<Blog> listOfBlogs = query.getResultList();
		return listOfBlogs;
	}*/
	
}
