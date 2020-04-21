package victor.notebook.configuration;

import java.sql.SQLException;
import java.util.Properties;

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
@EnableTransactionManagement(proxyTargetClass=true)
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
	@Value("${datasource.url}")
	private String url;
	@Value("${datasource.username}")
	private String username;
	@Value("${datasource.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource dataSource() throws Exception{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager() throws Exception {
		LocalContainerEntityManagerFactoryBean emBean = new LocalContainerEntityManagerFactoryBean();
		emBean.setDataSource(dataSource());
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emBean.setJpaVendorAdapter(vendorAdapter);
		HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
		emBean.setJpaDialect(jpaDialect);
		emBean.setPersistenceUnitName("unitName");
		emBean.setPackagesToScan("victor.notebook.domain");
		emBean.setJpaProperties(additionalProperties());
		return emBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManager().getObject());
	    
	    return transactionManager;
	}
	 
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	
	final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","false");
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
        
    
        return hibernateProperties;
    }
	
}
