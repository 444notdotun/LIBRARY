package data.respositories;

import data.models.Book;
import data.models.BorrowedBooks;

public interface BorrowedRepository {

    long getCount();

    BorrowedBooks save(BorrowedBooks book);

    BorrowedBooks findById(int Id);

    boolean existsById(int Id);

    void delete(BorrowedBooks element);

    void deleteById(int Id);

    void deleteAll();



}
