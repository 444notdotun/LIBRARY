package data.respositories;

import data.models.Book;

import java.util.ArrayList;

public class BookRepositoryImpl implements BookRespository{
    private static ArrayList<Book> listOfBooks = new ArrayList<>();
    private int count;

    Book book = new Book();

    @Override
    public long getcount() {
        return listOfBooks.size();
    }

    @Override
    public Book save(Book book) {
        if(book == null) return null;
        if(isNew(book)){ saveNewBook(book);return book;}
        update(book);return book;}
   private boolean isNew(Book book){return book.getId() == 0;}

   private void saveNewBook(Book book) {count++;listOfBooks.add(book);listOfBooks.get(count - 1).setId(count);
    }
    private void update (Book book){deleteById((book.getId()));listOfBooks.add(book);
    }

    @Override
    public Book findById(int index){
        if(index <1||index > listOfBooks.size()) return null;
        return listOfBooks.get(index-1);}

    @Override
    public boolean existsById(int Id) {return Id > 0 && Id <= listOfBooks.size();}

    @Override
    public void delete(Book element){listOfBooks.remove(element);}

    @Override
    public void deleteById(int Id) {listOfBooks.remove(findById(Id));}

    @Override
    public void deleteAll() {listOfBooks.clear();}








}
