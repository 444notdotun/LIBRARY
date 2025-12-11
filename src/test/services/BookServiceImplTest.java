package services;


import data.models.Book;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookServiceImplTest {

    AddBookRequest addBookRequest;
    BookRespository bookRespository;
    BookService bookService;
    @Before
    public void setup(){
        addBookRequest = new AddBookRequest();
        bookService = new BookServiceImpl();
        bookRespository = new BookRepositoryImpl();
    }

    @Test
    public void addBookTest(){
        addBookRequest.setBookName("life of dotun");
        addBookRequest.setDescription("all abut biography of dotun");
        addBookRequest.setAuthor("Adedotun");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(9);
        bookService.addBook(addBookRequest);
        assertEquals(1,bookRespository.getcount());
    }

//    @Test
//    public void




}