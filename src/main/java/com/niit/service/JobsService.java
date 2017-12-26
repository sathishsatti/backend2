package com.niit.service;

import java.util.List;

import com.niit.model.JobDetails;

public interface JobsService {

	public boolean addJobs(JobDetails jobDetails);
	
	public boolean updateJobs(JobDetails jobDetails);
	
	public boolean deleteJobs(JobDetails jobDetails);
	
	public JobDetails getJobs(int jobId);
	
	public List<JobDetails> getAllJobs();
	
}
