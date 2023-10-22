package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    static UserRepository repository;

    @BeforeAll
    static void setUp() {
        repository = new UserRepository();
    }

    @Test
    void testRepositoryAuthenticateUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void testRepositoryAuthenticateUserNegative() {
        String name = "name";
        String password = "password";
        String newPassword = "pppassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, newPassword);
        assertFalse(accept);
    }

    @Test
    void testRepositoryAddUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);
        int cnt = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size() > cnt);

        User ur = repository.data.get(repository.data.size() - 1);

        assertEquals(user, ur);
    }

    @Test
    void testRepositoryAddUserNegative() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int cnt = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size() == cnt);

    }
}