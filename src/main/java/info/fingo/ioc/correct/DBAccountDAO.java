package info.fingo.ioc.correct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DBAccountDAO implements AccountDAO{

    @Override
    public boolean addUser(Account account) {
        return false;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return Optional.empty();
    }
}
