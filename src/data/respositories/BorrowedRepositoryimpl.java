package data.respositories;

import data.models.Book;

public class BorrowedRepositoryimpl  implements BorrowedRepository {


    @Override
    public long getCount() {
        return 0;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book findById(int Id) {
        return null;
    }

    @Override
    public boolean existsById(int Id) {
        return false;
    }

    @Override
    public void delete(Book element) {

    }

    @Override
    public void deleteById(int Id) {

    }

    @Override
    public void deleteAll() {

    }
}
