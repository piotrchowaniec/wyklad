package info.fingo.ioc.correct;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    boolean addUser(Account account);

    List<Account> getAll();

    Optional<Account> findByEmail(String email);
}
