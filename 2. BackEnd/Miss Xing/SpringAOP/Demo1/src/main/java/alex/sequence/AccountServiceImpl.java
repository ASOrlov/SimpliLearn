package alex.sequence;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Override
    public void deposit(double amount) {
        System.out.println("Deposit successful: "+amount);
    }
}
