package victor.notebook.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("victor.notebook.configuration")
@EnableAspectJAutoProxy(proxyTargetClass=true) //開啟了Spring對AspectJ的支持
public class AopConfig {

}
