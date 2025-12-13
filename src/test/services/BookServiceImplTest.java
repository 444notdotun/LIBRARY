package services;



import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import exceptions.ValidateBook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @After
    public void teardown(){
        bookRespository.deleteAll();
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
        assertEquals("Adedotun",bookRespository.findById(1).getAuthor());
    }

    @Test
    public void  addBook_throwsErrorIfRequestIsNullTest(){
        addBookRequest = null;
      assertThrows(ValidateBook.class,()->  bookService.addBook(addBookRequest));

    }

    @Test
    public void ShowAllBooksIsNotNullWhenBookIsAdded(){ addBookRequest.setBookName("life of dotun");
        addBookRequest.setDescription("all abut biography of dotn");
        addBookRequest.setAuthor("Adedotun");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(9);
        bookService.addBook(addBookRequest);
        assertEquals(1,bookRespository.getcount());
        addBookRequest.setBookName("life of otun");
        addBookRequest.setDescription("all abut biography of dotun");
        addBookRequest.setAuthor("Adedotun");
        addBookRequest.setEdition(1);
        addBookRequest.setQuantity(9);
        bookService.addBook(addBookRequest);
        assertEquals(2,bookRespository.getcount());
        assertNotNull(bookRespository.returnAllBooks());
    }



}