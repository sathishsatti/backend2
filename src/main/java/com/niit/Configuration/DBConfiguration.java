package com.niit.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
import com.niit.model.BlogPostLikes;
import com.niit.model.CommentNotification;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.LikeNotification;
import com.niit.model.Notification;
import com.niit.model.ProfilePicture;
import com.niit.model.UsersDetails;



public class DBConfiguration {
	
	Logger logger =LoggerFactory.getLogger(DBConfiguration.class);
	
	@Bean(name = "dataSource")
		public DataSource getDataSource() {
		logger.info("Data Source Configuration ");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("PROJECT2");
		dataSource.setPassword("Password1");
		logger.info("Data Base Connected ");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		logger.info("========Hibernate Properties=========== ");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql","true");
		logger.info("========Hibernate Properties  has been set=========== ");
		return properties;

	}

	@Autowired
	
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		logger.info("========Hibernate Session Factory=========== ");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(UsersDetails.class);
		sessionBuilder.addAnnotatedClasses(BlogPost.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(BlogPostLikes.class);
		sessionBuilder.addAnnotatedClass(Notification.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		
		logger.info("========Hibernate SessionFactory Object created=========== ");
		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
 	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		logger.info("========Hibernate Transaction =========== ");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		logger.info("========Hibernate Transaction object created=========== ");
		return transactionManager;
	}
}