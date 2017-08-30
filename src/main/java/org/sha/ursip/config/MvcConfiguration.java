package org.sha.ursip.config;


import org.sha.ursip.dao.*;
import org.sha.ursip.model.Articles;
import org.sha.ursip.validator.TypeValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages="org.sha.ursip")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/testdb");
        dataSource.setUsername("test");
        dataSource.setPassword("12345");
		
		return dataSource;
	}

	@Bean
	public TypesDAO getTypesDAO() {
		return new TypesDaoImpl(getDataSource());
	}
	@Bean
	public ArticlesDAO getArticlesDAO() {return new ArticlesDaoImpl(getDataSource());}
	@Bean
	public ArticleLinkDAO getArticleLinkDAO() {return new ArticleLinkDaoImpl(getDataSource());}
	@Bean
	public TypeValidator typeValidator() {
		return new TypeValidator();
	}
	@Bean
	public MessageSource messageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename("validation");

		return messageSource;
	}


	
}
