package backend2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.model.JobDetails;
import com.niit.service.JobsService;


public class jobstest {
	
	@Autowired
	private static JobsService jobsService;
	
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		jobsService = (JobsService) context.getBean("jobsService");
	}

	
	@Test
	public void createJobsTest(){
		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		jobDetails.setJobTitle("Software Engineer");
		jobDetails.setSkillsRequired("B.Tech");
		jobDetails.setCompanyName("XYZ Pvt Ltd");
		jobDetails.setLocation("Hyderabad");
		jobDetails.setYrsOfExp("2+ Yrs");
		jobDetails.setSalary("250000");
		jobDetails.setPostedOn(new Date());
		
		assertTrue("Problem in storing Job details",jobsService.addJobs(jobDetails));
	}
	
  
	@Test
	public void updateJobsTest(){
		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setId(142);
		jobDetails.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		jobDetails.setJobTitle("Software Engineer");
		jobDetails.setSkillsRequired("B.Tech");
		jobDetails.setCompanyName("ABC Pvt Ltd");
		jobDetails.setLocation("Chennai");
		jobDetails.setYrsOfExp("4+ Yrs");
		jobDetails.setSalary("450000");
		jobDetails.setPostedOn(new Date());
		
		assertTrue("Problem in updating job details",jobsService.updateJobs(jobDetails));
	}
	
  
	@Test
	public void deleteJobsTest(){
		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setId(142);
		jobDetails.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		jobDetails.setJobTitle("Software Engineer");
		jobDetails.setSkillsRequired("B.Tech");
		jobDetails.setCompanyName("XYZ Pvt Ltd");
		jobDetails.setLocation("Hyderabad");
		jobDetails.setYrsOfExp("2+ Yrs");
		jobDetails.setSalary("250000");
		jobDetails.setPostedOn(new Date());
		
		assertTrue("Problem in deleting job details",jobsService.deleteJobs(jobDetails));
	}
	
	@Test
	public void getJobTest(){
		
		JobDetails jobDetails = jobsService.getJobs(141);
		assertNotNull("Problem in retrieving Job details",jobDetails);
		System.out.println("Job Id : "+jobDetails.getId()+"  Job Desc: "+jobDetails.getJobDesc()+"  Job Profile : "+jobDetails.getJobTitle()+"  Job Qualification : "+jobDetails.getSkillsRequired()+"  Job "+jobDetails.getPostedOn());
		
	}
	

	@Test
	public void getAllJobsTest(){
		
		List<JobDetails> jobsList = jobsService.getAllJobs();
		assertNotNull("Problem in retrieving All Jobs details",jobsList);
		showJobsDetails(jobsList);
		
	}

	private void showJobsDetails(List<JobDetails> jobsList) {
		
		for (JobDetails jobDetails : jobsList) {
			
			System.out.println(" Job Id : "+jobDetails.getId());
			System.out.println(" Job Desc : "+jobDetails.getJobDesc());
			System.out.println(" Job Profile : "+jobDetails.getJobTitle());
			System.out.println(" Job Qualification : "+jobDetails.getSkillsRequired());
			System.out.println(" Job Posted Date : "+jobDetails.getPostedOn());
			
		}
		
	}
}

