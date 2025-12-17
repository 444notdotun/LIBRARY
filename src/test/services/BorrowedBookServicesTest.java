package services;

import data.models.User;
import data.respositories.*;
import dtos.requests.AddBookRequest;
import dtos.requests.BorrowBookRequest;
import dtos.requests.UserRequest;
import exceptions.ValidateBook;
import exceptions.ValidateIdException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Checker;


import static org.junit.Assert.*;

public class BorrowedBookServicesTest {
AddBookRequest addBookRequest;
BookService bookService;
BorrowedBookServices borrowedBookServices;
BorrowBookRequest borrowBookRequest;
UserRepository userRepository= new userRepositoryImplementation();
UserRequest userRequest;
UserService userService;
BookRespository bookRespository;
BorrowedRepository borrowedRepository;
    @Before
    public void setUp() {
       addBookRequest = new AddBookRequest();
       bookService = new BookServiceImpl();
       borrowedBookServices = new BorrowedBookServices();
        userRequest = new UserRequest();
        userService = new UserServiceImplementation();
        bookRespository = new BookRepositoryImpl();
        borrowedRepository = new BorrowedRepositoryImpl();

    }

    @After
    public void teardown(){
        userRepository.deleteAll();
        borrowedRepository.deleteAll();
        bookRespository.deleteAll();
    }

    @Test
    public void BookCanBeBorrowed(){
        userRequest.seteMail("adeniyi@gmail.com");
        userRequest.setUserName("olamide");
        userService.RegisterUser(userRequest);
        addBookRequest.setBookName("life of dotun");
        addBookRequest.setDescription("all abut biography of dotun");
        addBookRequest.setAuthor("Adedotun");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(9);
        bookService.addBook(addBookRequest);
        borrowBookRequest = new BorrowBookRequest();
        borrowBookRequest.setAuthor("adedotun");
        borrowBookRequest.setEdition(1);
        borrowBookRequest.setBookname("life of dotun");
        borrowBookRequest.setUserId(1);
       assertNotNull(borrowedBookServices.BorrowBook(borrowBookRequest));
        assertEquals(1,userRepository.findById(1).getBorrowedBooks().size());

    }

    @Test
    public void BookCanNotBeBorrowedWhenTheQuantityIsZero(){
        addBookRequest.setBookName("life of dotun");
        addBookRequest.setDescription("all abut biography of dotun");
        addBookRequest.setAuthor("Adedotun");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(9);
        bookService.addBook(addBookRequest);
        for(int i = 1;i <=9;i++) {
            userRequest.seteMail("adeniyi@gmail.com");
            userRequest.setUserName("olamide");
            userService.RegisterUser(userRequest);
            borrowBookRequest = new BorrowBookRequest();
            borrowBookRequest.setAuthor("adedotun");
            borrowBookRequest.setEdition(1);
            borrowBookRequest.setBookname("life of dotun");
            borrowBookRequest.setUserId(i);
            borrowedBookServices.BorrowBook(borrowBookRequest);
        }
        assertEquals(9,userRepository.getCount());
        assertThrows(ValidateBook.class,()->borrowedBookServices.BorrowBook(borrowBookRequest));
    }

    @Test
    public  void BookThatDoesNOtExistCanNotBeBorrowed(){
        userRequest.seteMail("adeniyi@gmail.com");
        userRequest.setUserName("olamide");
        userService.RegisterUser(userRequest);
        borrowBookRequest = new BorrowBookRequest();
        borrowBookRequest.setAuthor("adedotun");
        borrowBookRequest.setEdition(1);
        borrowBookRequest.setBookname("life of dotun");
        borrowBookRequest.setUserId(1);
        assertThrows(ValidateBook.class,()->borrowedBookServices.BorrowBook(borrowBookRequest));
    }


@Test
    public void NonExistingUserCanNotBorrow(){
    userRequest.seteMail("adeniyi@gmail.com");
    userRequest.setUserName("olamide");
    userService.RegisterUser(userRequest);
    addBookRequest.setBookName("life of dotun");
    addBookRequest.setDescription("all abut biography of dotun");
    addBookRequest.setAuthor("Adedotun");
    addBookRequest.setEdition(1);
    addBookRequest.setQuantity(9);
    bookService.addBook(addBookRequest);
    borrowBookRequest = new BorrowBookRequest();
    borrowBookRequest.setAuthor("adedotun");
    borrowBookRequest.setEdition(1);
    borrowBookRequest.setBookname("life of dotun");
    borrowBookRequest.setUserId(2);
    assertThrows(ValidateIdException.class,()-> borrowedBookServices.BorrowBook(borrowBookRequest));
}
}