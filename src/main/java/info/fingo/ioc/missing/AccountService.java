package info.fingo.ioc.missing;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new InMemoryAccountDAO();
    }

    public boolean createAccount(String email, String firstName, String lastName) {
        if (accountDAO.findByEmail(email).isPresent()) {
            return false;
        }
        return accountDAO.addUser(new Account(email, firstName, lastName));
    }
}
