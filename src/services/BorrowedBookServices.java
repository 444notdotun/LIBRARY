package services;

import data.models.Book;
import data.models.BorrowedBooks;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import data.respositories.BorrowedRepository;
import data.respositories.BorrowedRepositoryimpl;
import dtos.requests.BorrowBookRequest;
import utils.Checker;
import utils.Mapper;

public class BorrowedBookServices implements BorrowedBookService{
    BorrowedRepository borrowedRepository = new BorrowedRepositoryimpl();
    BookRespository bookRespository = new BookRepositoryImpl();


    @Override
    public Book BorrowBook(BorrowBookRequest request) {
        if(isAvailable(request)) return borrow(request);return null;
    }


    private boolean isAvailable(BorrowBookRequest request){
        return Checker.CheckForRequest(request) > 0;
    }
    private Book borrow(BorrowBookRequest request){
        borrowedRepository.save(Mapper.mapBorrowedRequestToBorrowedBook(request));
        bookRespository.findById(Checker.CheckForRequest(request)).setQuantity(bookRespository.findById(Checker.CheckForRequest(request)).getQuantity()-1);
        bookRespository.save(bookRespository.findById(Checker.CheckForRequest(request)));
        return bookRespository.findById(Checker.CheckForRequest(request));
    }
}
