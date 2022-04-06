package info.fingo.ioc.missing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InMemoryAccountDAO implements AccountDAO {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public boolean addUser(Account account) {
        return this.accounts.add(account);
    }

    @Override
    public List<Account> getAll() {
        return Collections.unmodifiableList(accounts);
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return this.accounts
                .stream()
                .filter(it -> it.email().equals(email))
                .findFirst();
    }
}
