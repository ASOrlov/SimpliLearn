package alex.xml;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void doSomething() {
        System.out.println("Do Someting in CustomerServiceImpl ....");
    }
}
