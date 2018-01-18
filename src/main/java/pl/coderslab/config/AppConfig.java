package pl.coderslab.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.coderslab.entities.ArticleConverter;
import pl.coderslab.entities.CategoryConverter;

@Configuration
@ComponentScan(basePackages = { "pl.coderslab.entities, pl.coderslab.controllers, pl.coderslab.repositories" })
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "pl.coderslab.repositories" })
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean(name = { "entityManagerFactory", "entityManagerFactoryBean" })
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("articlesCMSPersistenceUnit");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getCategoryConverter());
		registry.addConverter(getArticleConverter());
	}

	@Bean
	public CategoryConverter getCategoryConverter() {
		return new CategoryConverter();
	}
	
	@Bean
	public ArticleConverter getArticleConverter() {
		return new ArticleConverter();
	}
}