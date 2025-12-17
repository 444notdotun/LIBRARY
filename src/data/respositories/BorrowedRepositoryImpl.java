package data.respositories;

import data.models.BorrowStatus;
import data.models.BorrowedBooks;

import java.util.ArrayList;
import java.util.List;

public class BorrowedRepositoryImpl implements BorrowedRepository {



    private int count;
    private List<BorrowedBooks> books = new ArrayList<>();

    @Override
    public long getCount() {
        return books.size();
    }

    @Override
    public BorrowedBooks save(BorrowedBooks book) {
        if(book == null) return null;
        if(isNew(book)){ saveNewBook(book);return book;}
        update(book);return book;
    }

private boolean isNew(BorrowedBooks book){return book.getBorrowId() == 0;}

private void saveNewBook(BorrowedBooks book) {count++;book.setBorrowId(count);book.setReturned(BorrowStatus.BORROWED);books.add(book);
}
private void update (BorrowedBooks book){deleteById((book.getBorrowId()));books.add(book);}

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

