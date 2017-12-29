package com.niit.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.Dao.BlogPostDao;
import com.niit.Dao.BlogPostDaoImpl;
import com.niit.Dao.JobDao;
import com.niit.Dao.JobDaoImpl;
import com.niit.Dao.UsersDAO;
import com.niit.Dao.UsersDAOImpl;
import com.niit.model.Job;
import com.niit.model.UsersDetails;


public class DBConfiguration {
	
Logger logger =LoggerFactory.getLogger(DBConfiguration.class);
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("PROJECT2");
		dataSource.setPassword("Password1");

		System.out.println("DataBase is connected.........!");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql","true");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(UsersDetails.class);

		sessionBuilder.addAnnotatedClasses(Job.class);

	//	sessionBuilder.addAnnotatedClasses(BlogPost.class);
		 
		System.out.println("Session is created................!");

		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is created............!");
		return transactionManager;
	}

	@Autowired
	@Bean(name = "usersDAO")
	public UsersDAO getUsersDAO(SessionFactory sessionFactory)
	{

		return new UsersDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "blogPostDao")
	public BlogPostDao getBlogPostDao(SessionFactory sessionFactory)
	{

		return new BlogPostDaoImpl(sessionFactory);
	}
	
	
	@Autowired
	@Bean(name = "jobDao")
	public JobDao getJobDao(SessionFactory sessionFactory)
	{

		return new JobDaoImpl(sessionFactory);
	}
	
	
}
	
