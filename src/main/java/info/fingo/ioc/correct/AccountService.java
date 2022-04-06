package info.fingo.ioc.correct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("db")
public class AccountService {

    private final AccountDAO accountDAO;


    public AccountService(
            AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    public boolean createAccount(String email, String firstName, String lastName) {
        if (accountDAO.findByEmail(email).isPresent()) {
            return false;
        }
        return accountDAO.addUser(new Account(email, firstName, lastName));
    }
}
