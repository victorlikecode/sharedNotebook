package victor.notebook.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class GeneralConfig {

	/**
	 * 使用該bean帶出資料庫資訊
	 * @return
	 */
	@Bean
	public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer jdbc = new PropertyPlaceholderConfigurer();
		jdbc.setLocation(new ClassPathResource("jdbc.properties"));
		jdbc.setIgnoreUnresolvablePlaceholders(true);
		return jdbc;
	}
}
