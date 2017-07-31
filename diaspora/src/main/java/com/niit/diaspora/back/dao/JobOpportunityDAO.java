package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.JobOpportunity;

public interface JobOpportunityDAO {

	void saveOrUpdateJobOpportunity(JobOpportunity jobOpportunity);
	
	void deleteJobOpportunity(String jobOpportunityId);
	
	JobOpportunity getJobOpportunity(String jobOpportunityId);
	
	List<JobOpportunity> listJobOpportunities();
}
