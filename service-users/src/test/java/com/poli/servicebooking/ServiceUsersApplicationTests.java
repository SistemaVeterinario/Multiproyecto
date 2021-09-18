package com.poli.servicebooking;

import com.poli.serviceuser.entities.User;
import com.poli.serviceuser.repository.UserRepository;
import com.poli.serviceuser.service.UserService;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = User.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ServiceUsersApplicationTests {

    @Test
    void contextLoads() {
    }

    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UserService userService;

    @Test
    public void testShouldListUsers(){
        List<User> users = new ArrayList<User>();
        getUsers(users);

        Mockito.when(userService.findAll()).thenReturn(users);
        List<User> listUsers = userService.findAll();

        Assertions.assertTrue(listUsers.size() > 0);
    }

    static List<User> getUsers(List<User> userList) {
        userList.add(new User(Long.valueOf(1),"Juan","López"));
        userList.add(new User(Long.valueOf(2),"Mateo","Gutierrez"));
        userList.add(new User(Long.valueOf(3),"Pablo","Diaz"));
        return userList;
    }

    @Test
    public void testShouldByIdUser() {
        User user = new User(Long.valueOf(1), "Juan", "López");

        Mockito.when(userService.findById(Long.valueOf(1))).thenReturn(user);
        User userData = userService.findById(Long.valueOf(1));

        User userComparar = new User(Long.valueOf(1), "Juan", "López");

        Assertions.assertTrue(userComparar.equals(userData));
    }


}
