package backend2;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.Configuration.DBConfiguration;
import com.niit.Dao.UsersDAO;
import com.niit.model.UsersDetails;

@ComponentScan("com.niit")
public class UsersTest {

static UsersDAO  usersDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.register(DBConfiguration.class);
		context.scan("com.niit");
		context.refresh();

		usersDAO=(UsersDAO)context.getBean("usersDAO");
	}
	
	@Test
	public void addUserTest()
	{
		UsersDetails user=new UsersDetails();
		//user.setUser_id(1);
		user.setFirstName("sathish");
		user.setLastName("kumar");
		user.setContact("9512368740");
		user.setEmail("sathish@gmail.com");
		user.setPassword("123");
		user.setRole("Admin");
		assertTrue("Problem in Inserting user", usersDAO.saveOrUpdate(user));	}

}
