package victor.notebook.configuration;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
/**
 * 設定 spring 資料庫連線資訊
 * @author victortsai
 *
 */
public class JpaConfiguration {
	/**
	 * 設定DB連線資訊
	 * @return
	 * @throws Exception 
	 */
	
	@Value("${datasource.jdbc.driver.name}")
	private String driverClassName;
	@Value("${datasource.url0}")
	private String url;
	@Value("${datasource.username0}")
	private String username;
	@Value("${datasource.password0}")
	private String password;
	
	@Bean
	public DataSource dataSource() throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setLoginTimeout(20);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean emBean = new LocalContainerEntityManagerFactoryBean();
		emBean.setDataSource(dataSource());
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emBean.setJpaVendorAdapter(vendorAdapter);
		HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
		emBean.setJpaDialect(jpaDialect);
		return emBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	 
	    return transactionManager;
	}
	 
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	
}
