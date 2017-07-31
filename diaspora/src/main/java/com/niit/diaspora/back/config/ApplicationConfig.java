package com.niit.diaspora.back.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;

import com.niit.diaspora.back.model.Blog;
import com.niit.diaspora.back.model.BlogComment;
import com.niit.diaspora.back.model.Event;
import com.niit.diaspora.back.model.Forum;
import com.niit.diaspora.back.model.ForumPost;
import com.niit.diaspora.back.model.ForumPostComment;
import com.niit.diaspora.back.model.Friend;
import com.niit.diaspora.back.model.JobOpportunity;
import com.niit.diaspora.back.model.UserAuthorities;
import com.niit.diaspora.back.model.UserDetail;
import com.niit.diaspora.back.model.Users;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit.diaspora.back")
public class ApplicationConfig {


	@Bean(name = "datasource")
	public static DataSource getDatasource() {
		//DriverManagerDataSource datasource = new DriverManagerDataSource();
/*		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:oracledb");
		datasource.setUsername("system");
		datasource.setPassword("258741");*/
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("org.h2.Driver");
        datasource.setUrl("jdbc:h2:tcp://localhost/~/diaspora");
        datasource.setUsername("sa");
        datasource.setPassword("");		
		return datasource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		//properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());		
		sessionBuilder.addAnnotatedClass(UserDetail.class);
		sessionBuilder.addAnnotatedClass(Users.class);
		sessionBuilder.addAnnotatedClass(UserAuthorities.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumPost.class);
		sessionBuilder.addAnnotatedClass(ForumPostComment.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(JobOpportunity.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransctionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
	
	@Bean
	public MultipartResolver multipartResolver() {
	    org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.
	    		multipart.commons.CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(25000000);
	    return multipartResolver;
	}
	
	  
}
