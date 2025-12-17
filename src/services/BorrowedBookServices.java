package services;

import data.models.Book;
import data.respositories.*;
import dtos.requests.BorrowBookRequest;
import dtos.responses.BorrowBookResponse;
import dtos.responses.ReturnBookResponse;
import exceptions.ValidateIdException;
import utils.Checker;
import utils.Mapper;

public class BorrowedBookServices implements BorrowedBookService{
    BorrowedRepository borrowedRepository = new BorrowedRepositoryImpl();
    BookRespository bookRespository = new BookRepositoryImpl();
    UserRepository userRepository = new userRepositoryImplementation();


    @Override
    public BorrowBookResponse BorrowBook(BorrowBookRequest request) {
        if(isAvailable(request)) return borrow(request);return null;
    }

    @Override
    public ReturnBookResponse returnBorrowedBook(Book book) {
        return null;
    }


    private boolean isAvailable(BorrowBookRequest request){
        return Checker.CheckForRequest(request) > 0;
    }

    private BorrowBookResponse borrow(BorrowBookRequest request){
        checkForUser(request);
        borrowedRepository.save(Mapper.mapBorrowedRequestToBorrowedBook(request));
        bookRespository.findById(Checker.CheckForRequest(request)).setQuantity(bookRespository.findById(Checker.CheckForRequest(request)).getQuantity()-1);
        userRepository.findById(request.getUserId()).setBorrowedBooks(bookRespository.findById(Checker.CheckForRequest(request)));
        return Mapper.mapResponse(Mapper.mapBorrowedRequestToBorrowedBook(request));
    }

    private  void  checkForUser(BorrowBookRequest request){
        if(request.getUserId()<=0||request.getUserId()>userRepository.getCount()){
            throw new ValidateIdException("INVALID USER ID");
        }
    }

}
