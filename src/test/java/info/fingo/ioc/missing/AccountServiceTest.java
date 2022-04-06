package info.fingo.ioc.missing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void createAccountShouldReturnFalseWhenAccountWithGivenEmailAlreadyExists() {
        //given
        AccountService accountService = new AccountService();
        String existingEmail = "some.account@gmail.com";

        boolean account = accountService.createAccount(existingEmail, "Jan", "Nowak");
        assertTrue(account, "Cannot create first account");

        //when
        boolean result = accountService.createAccount(existingEmail, "Adam", "Adamski");

        //then
        assertFalse(result, "AccountService was able to create second account with same email");
    }

}