/*package backend2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.model.JobDetail;
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
		
		JobDetail jobDetail = new JobDetail();
		jobDetail.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		jobDetail.setJobTitle("Software Engineer");
		jobDetail.setSkillsRequired("B.Tech");
		jobDetail.setCompanyName("XYZ Pvt Ltd");
		jobDetail.setLocation("Hyderabad");
		jobDetail.setYrsOfExp("2+ Yrs");
		jobDetail.setSalary("250000");
		jobDetail.setPostedOn(new Date());
		
		assertTrue("Problem in storing Job details",jobsService.addJobs(jobDetail));
	}
	
  
	@Test
	public void updateJobsTest(){
		
		JobDetail jobDetail = new JobDetail();
		jobDetail.setId(142);
		jobDetail.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		jobDetail.setJobTitle("Software Engineer");
		jobDetail.setSkillsRequired("B.Tech");
		jobDetail.setCompanyName("ABC Pvt Ltd");
		jobDetail.setLocation("Chennai");
		jobDetail.setYrsOfExp("4+ Yrs");
		jobDetail.setSalary("450000");
		jobDetail.setPostedOn(new Date());
		
		assertTrue("Problem in updating job details",jobsService.updateJobs(jobDetail));
	}
	
  
	@Test
	public void deleteJobsTest(){
		
		JobDetail jobDetail = new JobDetail();
		jobDetail.setId(142);
		jobDetail.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
		jobDetail.setJobTitle("Software Engineer");
		jobDetail.setSkillsRequired("B.Tech");
		jobDetail.setCompanyName("XYZ Pvt Ltd");
		jobDetail.setLocation("Hyderabad");
		jobDetail.setYrsOfExp("2+ Yrs");
		jobDetail.setSalary("250000");
		jobDetail.setPostedOn(new Date());
		
		assertTrue("Problem in deleting job details",jobsService.deleteJobs(jobDetail));
	}
	
	@Test
	public void getJobTest(){
		
		JobDetail jobDetail = jobsService.getJobs(141);
		assertNotNull("Problem in retrieving Job details",jobDetail);
		System.out.println("Job Id : "+jobDetail.getId()+"  Job Desc: "+jobDetail.getJobDesc()+"  Job Profile : "+jobDetail.getJobTitle()+"  Job Qualification : "+jobDetail.getSkillsRequired()+"  Job "+jobDetail.getPostedOn());
		
	}
	

	@Test
	public void getAllJobsTest(){
		
		List<JobDetail> jobsList = jobsService.getAllJobs();
		assertNotNull("Problem in retrieving All Jobs details",jobsList);
		showJobsDetails(jobsList);
		
	}

	private void showJobsDetails(List<JobDetail> jobsList) {
		
		for (JobDetail jobDetails : jobsList) {
			
			System.out.println(" Job Id : "+jobDetails.getId());
			System.out.println(" Job Desc : "+jobDetails.getJobDesc());
			System.out.println(" Job Profile : "+jobDetails.getJobTitle());
			System.out.println(" Job Qualification : "+jobDetails.getSkillsRequired());
			System.out.println(" Job Posted Date : "+jobDetails.getPostedOn());
			
		}
		
	}
}

*/