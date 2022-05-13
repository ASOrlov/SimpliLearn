package alex;

import alex.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //EmailService emailService=new EmailService();
        //BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("spring.xml"));
        //BeanFactory beanFactory=new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService=context.getBean("emailService",EmailService.class);

        System.out.println(emailService);
        emailService.SendEmail("test@gmail.com", "Hello from Alex");

        ApplicationContext context1=new AnnotationConfigApplicationContext(AppConfig.class);

        EmailService emailService1=context1.getBean("emailService",EmailService.class);
        System.out.println(emailService1);

        emailService1.SendEmail("test1@gmail.com", "H1");
    }

}
