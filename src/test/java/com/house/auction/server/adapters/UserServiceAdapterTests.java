package com.house.auction.server.adapters;

import com.house.auction.server.auth.UserAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceAdapterTests {
    private UserServiceAdapter userServiceAdapter;

    @Before
    public void setup() {
        this.userServiceAdapter = new UserServiceAdapter();
    }

    @Test
    public void saveUser() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user_a");
        userAccount.setPassword("password123");

        userServiceAdapter.saveUser(userAccount);

        UserAccount userAccountSaved = userServiceAdapter.getUserByUsername("user_a");

        Assert.assertNotNull(userAccountSaved);
        Assert.assertEquals(1, userAccountSaved.getId());
        Assert.assertEquals("user_a", userAccountSaved.getUsername());
        Assert.assertEquals("password123", userAccountSaved.getPassword());
    }

    @Test
    public void getUserByUsername_UserNotExists_ReturnsNull() {
        UserAccount userAccount = userServiceAdapter.getUserByUsername("user_not_exists");

        Assert.assertNull(userAccount);
    }
}
