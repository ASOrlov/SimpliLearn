package alex.advices;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public double calculatePayment(double rate, int hours) {

        System.out.println("Rate: "+rate+" hours: "+hours);

        return hours*rate;
    }

    @Override
    public void doSomething() {
        System.out.println("Do Something in CustomerServiceImpl ...");
    }

    @Override
    public String getAge() {
        throw new MyException("exception ...");
    }

    public String getName(){
        return "ALexander Orlov";
    }


}
