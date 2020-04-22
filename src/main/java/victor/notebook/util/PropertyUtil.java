package victor.notebook.util;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * 用於讀取properties file
 * @author victortsai
 *
 */
@Component
public class PropertyUtil {

	private Properties props;
	
	@PostConstruct
	public void init() {
		
	}
}
