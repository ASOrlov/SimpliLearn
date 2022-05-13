package alex.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

//    @Autowired(required = false)
    @Autowired
    @Qualifier("custDao")
    private CustomerDao customerDao;

    public CustomerService() {
        System.out.println("Default constructor");
    }

    //@Autowired
    public CustomerService(CustomerDao customerDao) {
        System.out.println("Customized constructor ...");
        this.customerDao = customerDao;
    }

//    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        System.out.println("setter ....");
        this.customerDao = customerDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }
}
