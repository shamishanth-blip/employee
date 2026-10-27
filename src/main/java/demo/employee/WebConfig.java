
package demo.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("demo.employee")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

    @Bean
    public AuditAspect auditAspect() {
        return new AuditAspect();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
