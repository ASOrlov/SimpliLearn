package alex.terms;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService{
    @Override
    public void doSomething() {
        System.out.println("Do something in CustomerServiceImpl ...");
    }
}
