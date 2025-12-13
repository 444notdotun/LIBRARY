package data.respositories;

import data.models.Book;
import data.models.BorrowedBooks;

import java.util.ArrayList;
import java.util.List;

public class BorrowedRepositoryimpl  implements BorrowedRepository {



    private int count;
    private List<BorrowedBooks> books = new ArrayList<>();

    @Override
    public long getCount() {
        return books.size();
    }

    @Override
    public BorrowedBooks save(BorrowedBooks book) {
        if (book == null) {
            return null;
        }
        count++;book.setBorrowId(count);book.setReturned(false);books.add(book);return book;
    }

    @Override
    public BorrowedBooks findById(int id) {if(id <= 0 || id > count) return null;return books.get(id - 1);
    }

    @Override
    public boolean existsById(int id) {
        return id > 0 && id <= count;
    }

    @Override
    public void delete(BorrowedBooks element) {
        books.remove(element);

    }

    @Override
    public void deleteById(int id) {
        books.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        books.clear();
    }


}

