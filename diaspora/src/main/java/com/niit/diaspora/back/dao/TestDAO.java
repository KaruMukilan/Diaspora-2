package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.Test;

public interface TestDAO {

	void saveOrUpdateTest(Test test);
	
	void delete(String testId);
	
	Test getTest(String testId);
	
	List<Test> listTest();
}
