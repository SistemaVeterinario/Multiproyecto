package com.poli.servicebooking;

import com.poli.serviceuser.entities.User;
import com.poli.serviceuser.repository.UserRepository;
import com.poli.serviceuser.service.UserService;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
class ServiceUsersApplicationTests {

    @Test
    void contextLoads() {
    }

    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void testShouldListUsers(){
        List<User> users = new ArrayList<User>();
        getUsers(users);

        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<User> listUsers = userService.findAll();

        Assertions.assertFalse(listUsers.isEmpty());
    }

    static ResponseEntity<List<User>> getUsers(List<User> userList) {
        userList.add(new User(Long.valueOf(1),"Juan","López"));
        userList.add(new User(Long.valueOf(2),"Mateo","Gutierrez"));
        userList.add(new User(Long.valueOf(3),"Pablo","Diaz"));
        return ResponseEntity.ok(userList);
    }
}
