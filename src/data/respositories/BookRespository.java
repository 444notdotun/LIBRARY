package data.respositories;

import data.models.Book;

import java.util.ArrayList;


public interface BookRespository {


      long getcount();

      Book save(Book book);

    Book findById(int Id);

    boolean existsById(int Id);

    void delete(Book element);

    void deleteById(int Id);

    void deleteAll();

    ArrayList<Book> returnAllBooks();
}
