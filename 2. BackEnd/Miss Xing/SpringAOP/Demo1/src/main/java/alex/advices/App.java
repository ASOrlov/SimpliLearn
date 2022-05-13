package alex.advices;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        CustomerService customerService=context.getBean(CustomerService.class);
//        customerService.doSomething();
//
//        System.out.println("\n");
//        customerService.getName();
//
//        System.out.println("\n");
//        customerService.getAge();
//
//        System.out.println("\n");
//        AccountService accountService=context.getBean(AccountService.class);
//        accountService.deposit(100);

        double payment=customerService.calculatePayment(20,5);

        System.out.println("payment: "+payment);

    }
}
