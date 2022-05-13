package alex.fourtypes;

public class CustomerService {

    CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        System.out.println("setter ...");
        this.customerDao = customerDao;
    }

    public CustomerService(CustomerDao customerDao) {
        System.out.println("Customized constructor ....");
        this.customerDao = customerDao;
    }

    public CustomerService() {

        System.out.println("Default constructor ...."); ;
    }

    public CustomerDao getCustomerDao() {

        return customerDao;
    }
}
