import by.martysiuk.sanatoriumApp.models.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
    private static final double EPS = 1e-9;
    private static User user;

    @BeforeClass
    public static void createUser() {
        user = new User();
        user.setId(1);
        user.setUsername("Alex");
        user.setPassword("12345");
        user.setEnabled(true);
    }

    @Test
    public void shouldSetUserIdOne() {
        Assert.assertEquals(1, user.getId(), EPS);
    }

    @Test
    public void shouldSetUsernameAlex() {
        Assert.assertEquals("Alex", user.getUsername());
    }

    @Test
    public void shouldSetPassword12345() {
        Assert.assertEquals("12345", user.getPassword());
    }

    @Test
    public void shouldEnabledTrue() {
        Assert.assertTrue(user.isEnabled());
    }
}
