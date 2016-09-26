package com.niit.collaboration.config;

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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.Role;
import com.niit.collaboration.model.UserDetails;
import com.niit.collaboration.model.UserRole;

@EnableWebMvc
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{

	@Bean(name = "datasource")
	public DataSource getOracleDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		dataSource.setUsername("COLB_DB");
		dataSource.setPassword("root");
		
		Properties connectionProperties = new Properties();
		connectionProperties.put("hibernate.show_sql", "true");
		connectionProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		dataSource.setConnectionProperties(connectionProperties);
		return dataSource;
	}

//	private Properties getHibernateProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.show_sql", "true");
//		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//		return properties;
//	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	//	sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(UserRole.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
	
//	@Bean
//	  public MappingJackson2HttpMessageConverter converter() {
//	      MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//	      converter.setObjectMapper(mapper());
//	      return converter;
//	  }
//
//	@Bean
//	private ObjectMapper mapper() {
//		// TODO Auto-generated method stub
//		return new ObjectMapper();
//	}


}
