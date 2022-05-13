package alex.terms;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("alex.terms")
@EnableAspectJAutoProxy
public class Config {
}
