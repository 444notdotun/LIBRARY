package data.respositories;

import data.models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookRepositoryTest {
   BookRespository bookRespository;
    Book book;
    @Before
    public void setUp(){
      bookRespository = new BookRepositoryImpl();

    }
    @After
    public void resetup(){
        bookRespository.deleteAll();
    }
    @Test
    public void book_testThatNewBookRepoIsEmpty(){
        assertEquals(0,bookRespository.getcount());

    }

    @Test
    public void booksCAnBeSaved(){
        book =new Book();
        bookRespository.save(book);
        assertEquals( 1L, bookRespository.getcount());
    }

    @Test
    public void  save_throwsErrorWhenANullParameterIsPassed(){
        book = null;
        assertNull(bookRespository.save(book));
    }

    @Test
    public void books_canBeFoundById(){
        book= new Book();
        bookRespository.save(book);
       Book book1=new Book();
        bookRespository.save(book1);
        assertEquals(2L,bookRespository.getcount());
        assertEquals(book1,bookRespository.findById(2));
    }

    @Test
    public void books_canNotBeFoundWithWrongId(){
        book= new Book();
        bookRespository.save(book);
        Book book1=new Book();
        bookRespository.save(book1);
        assertEquals(2L,bookRespository.getcount());
        assertNull( bookRespository.findById(3));
    }

    @Test
    public void books_existsById(){
        book= new Book();
        Book book1 = new Book();
        bookRespository.save(book1);
        bookRespository.save(book);
        assertTrue(bookRespository.existsById(2));
    }

    @Test
    public void books_returnsFalseIfIdDoesntExist(){
        book = new Book();
        bookRespository.save(book);
        assertFalse(bookRespository.existsById(2));
    }

    @Test
    public void books_canBeDeleted(){
        book = new Book();
        Book newOba = new Book();
        bookRespository.save(book);
        bookRespository.save(newOba);
        bookRespository.delete(newOba);
        assertEquals(1L,bookRespository.getcount());
    }

    @Test
    public void books_canBeDeletedById(){
        book = new Book();
        Book newOba = new Book();
        bookRespository.save(book);
        bookRespository.save(newOba);
        bookRespository.deleteById(2);
        assertEquals(1L,bookRespository.getcount());

    }




    @Test
    public void books_canDeleteAll(){
        book = new Book();
        Book newOba = new Book();
        bookRespository.save(book);
        bookRespository.save(newOba);
        bookRespository.deleteAll();
        assertEquals(0,bookRespository.getcount());


    }

}