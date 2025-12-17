package services;

import data.respositories.UserRepository;
import data.respositories.userRepositoryImplementation;
import dtos.requests.UserRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplementationTest {
    UserRequest userRequest;
    UserService userService;
    UserRepository userRepository;
    @Before
    public void setUp(){
        userRequest = new UserRequest();
        userService = new UserServiceImplementation();
        userRepository = new userRepositoryImplementation();
    }
    @Test
    public void userCanRegister(){
        userRequest.seteMail("adeniyi@gmail.com");
        userRequest.setUserName("olamide");
        userRequest.setPhoneNumber("081469874635");
        userRequest.setAddress("312 sabo yaba");
        userService.RegisterUser(userRequest);
        assertEquals(1,userRepository.getCount());
        assertEquals("olamide",userRepository.findById(1).getName());
    }

}