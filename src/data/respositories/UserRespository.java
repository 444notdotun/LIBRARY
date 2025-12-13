package data.respositories;

import data.models.BorrowedBooks;
import data.models.User;

public interface UserRespository {
    long getCount();

   User save(BorrowedBooks book);

    User findById(int Id);

    boolean existsById(int Id);

    void delete(User element);

    void deleteById(int Id);

    void deleteAll();
}
