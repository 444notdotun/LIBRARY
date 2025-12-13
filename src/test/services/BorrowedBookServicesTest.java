package services;

import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import dtos.requests.BorrowBookRequest;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BorrowedBookServicesTest {
AddBookRequest addBookRequest;
BookService bookService;
BorrowedBookServices borrowedBookServices;
BorrowBookRequest borrowBookRequest;
    @Before
    public void setUp() {
       addBookRequest = new AddBookRequest();
       bookService = new BookServiceImpl();
       borrowedBookServices = new BorrowedBookServices();

    }
    @Test
    public void BookCanBeBorrowed(){
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
       assertNotNull(borrowedBookServices.BorrowBook(borrowBookRequest));
    }

    @Test
    public void BookCanNotBeBorrowed(){
        addBookRequest.setBookName("life of dotun");
        addBookRequest.setDescription("all abut biography of dotun");
        addBookRequest.setAuthor("Adedotun");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(9);
        bookService.addBook(addBookRequest);
        for(int i = 0;i <9;i++) {
            borrowBookRequest = new BorrowBookRequest();
            borrowBookRequest.setAuthor("adedotun");
            borrowBookRequest.setEdition(1);
            borrowBookRequest.setBookname("life of dotun");
            borrowedBookServices.BorrowBook(borrowBookRequest);
        }
        assertNull(borrowedBookServices.BorrowBook(borrowBookRequest));
    }



}