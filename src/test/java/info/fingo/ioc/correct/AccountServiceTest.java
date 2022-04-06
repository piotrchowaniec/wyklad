package info.fingo.ioc.correct;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Test
    void createAccountShouldReturnFalseWhenAccountWithGivenEmailAlreadyExists() {
        //given
        String existingEmail = "some.account@gmail.com";
        AccountDAO accountDAO = new AccountDAO() {
            @Override
            public boolean addUser(Account account) {
                return true;
            }

            @Override
            public List<Account> getAll() {
                return Collections.emptyList();
            }

            @Override
            public Optional<Account> findByEmail(String email) {
                return Optional.of(new Account(existingEmail, "Jan", "Nowak"));
            }
        };
        AccountService accountService = new AccountService(accountDAO);

        //when
        boolean result = accountService.createAccount(existingEmail, "Adam", "Adamski");

        //then
        assertFalse(result, "AccountService was able to create second account with same email");
    }

    @Test
    void createAccountShouldReturnFalseWhenAccountWithGivenEmailAlreadyExistsMock() {
        //given
        String existingEmail = "some.account@gmail.com";
        AccountDAO accountDAO = mock(AccountDAO.class);
        when(accountDAO.findByEmail(existingEmail))
                .thenReturn(Optional.of(new Account(existingEmail, "Jan", "Nowak")));
        when(accountDAO.addUser(any())).thenReturn(true);


        AccountService accountService = new AccountService(accountDAO);

        //when
        boolean result = accountService.createAccount(existingEmail, "Adam", "Adamski");

        //then
        assertFalse(result, "AccountService was able to create second account with same email");
    }
}