package data.respositories;

import data.models.BorrowStatus;
import data.models.BorrowedBooks;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BorrowedRespositoryTest {
    BorrowedRepository borrowedBookRepositoryImplementation;
    @Before
    public void setUp() {
        borrowedBookRepositoryImplementation = new BorrowedRepositoryImpl();
    }

    @Test
    public void repositoryIsEmptyUponCreation(){
        assertEquals(0L,borrowedBookRepositoryImplementation.getCount());
    }

    @Test
    public void saveBook_CountIncreases(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        assertEquals(1L,borrowedBookRepositoryImplementation.getCount());
    }

    @Test
    public void saveBook_BookIsReturned(){
        BorrowedBooks book = new BorrowedBooks();
        assertEquals(book, borrowedBookRepositoryImplementation.save(book));
        assertEquals(book, borrowedBookRepositoryImplementation.findById(1));
    }

    @Test
    public void saveBook_BookIdIsSet(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        assertEquals(1,book.getBorrowId());
    }



    @Test
    public void findByIdWithNumberGreaterThanCount_ReturnNull(){
        assertNull(borrowedBookRepositoryImplementation.findById(1));
    }

    @Test
    public void findByIdWithNumberEqualTo0OrLessThan0_ReturnNull(){
        assertNull(borrowedBookRepositoryImplementation.findById(0));
        assertNull(borrowedBookRepositoryImplementation.findById(-1));
    }

    @Test
    public void existsByIdTest(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        assertTrue(borrowedBookRepositoryImplementation.existsById(1));
    }

    @Test
    public void existsByIdWithInvalidIdTest(){
        assertFalse(borrowedBookRepositoryImplementation.existsById(1));
        assertFalse(borrowedBookRepositoryImplementation.existsById(-1));
        assertFalse(borrowedBookRepositoryImplementation.existsById(0));
    }

    @Test
    public void deleteById_BookIsDeleted_CountDecreases(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        borrowedBookRepositoryImplementation.deleteById(1);
        assertEquals(0L, borrowedBookRepositoryImplementation.getCount());
    }

    @Test
    public void deleteAll_CountIs0(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        borrowedBookRepositoryImplementation.deleteAll();
        assertEquals(0L, borrowedBookRepositoryImplementation.getCount());
    }

    @Test
    public void saveBorrowedBook_IsReturnedValueIsFalse(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        assertEquals(BorrowStatus.BORROWED,book.isReturned());
    }

    @Test
    public void BorrowedBookCanBeDeleted(){
        BorrowedBooks book = new BorrowedBooks();
        borrowedBookRepositoryImplementation.save(book);
        borrowedBookRepositoryImplementation.delete(book);
        assertEquals(0,borrowedBookRepositoryImplementation.getCount());

    }



}