package com.niit.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.JobDetails;

@Repository
public class JobsDaoImpl implements JobsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addJobs(JobDetails jobDetails) {
		try
		{
		    sessionFactory.getCurrentSession().save(jobDetails);
			return true;
		}catch(Exception e){
			System.out.println("Exception raised: "+e);
			return false;
		}
	}

	@Transactional
	public boolean updateJobs(JobDetails jobDetails) {
		try{
			sessionFactory.getCurrentSession().update(jobDetails);
			return true;
		}catch(Exception e){
			System.out.println("Exception raised: "+e);
			return false;
		}
	}

	@Transactional
	public boolean deleteJobs(JobDetails jobDetails) {
		try
		{
			sessionFactory.getCurrentSession().delete(jobDetails);
			return true;
			
		}catch(Exception e){
			
			System.out.println("Exception raised: "+e);
			return false;
		}
	}

	@Transactional
	public JobDetails getJobDetail(int jobId) {
		
		Session session = sessionFactory.openSession();
		
		JobDetails jobsObj = session.get(JobDetails.class, jobId);
		
		session.close();
		
		return jobsObj;
	}

	@Transactional
	public List<JobDetails> getAllJobDetails() {

		Session session = sessionFactory.openSession();
		
		List<JobDetails> jobsList= session.createQuery("from JobDetail",JobDetails.class).list();
		
		session.close();
		
		return jobsList;
	}


}
