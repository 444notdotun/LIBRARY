package utils;

import data.models.Book;
import data.models.BorrowedBooks;
import data.models.User;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import dtos.requests.BorrowBookRequest;
import dtos.requests.UserRequest;
import dtos.responses.AddBookResponse;
import dtos.responses.BorrowBookResponse;
import dtos.responses.UserResponse;

import java.time.LocalDate;

public class Mapper {

    public static Book mapRequestToBook(AddBookRequest request){
        Book book = new Book();
        book.setName(request.getBookName());
        book.setEdition(request.getEdition());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setQuantity(request.getQuantity());
        book.setGenre(request.getGenre());
        return book;
    }


    public static AddBookResponse mapBookDetailsToResponse(Book book){
        AddBookResponse addBookResponse= new AddBookResponse();
        addBookResponse.setBookName(book.getName());
        addBookResponse.setQuantity(book.getQuantity());
        addBookResponse.setEdition(book.getEdition());
        addBookResponse.setDescription(book.getDescription());
        addBookResponse.setAuthor(book.getAuthor());
        addBookResponse.setGenre(book.getGenre());
        return addBookResponse;
    }

    public static User mapRequestToUser(UserRequest request){
        User user = new User();
        user.setName(request.getUserName());
        user.setAddress(request.getAddress());
        user.setNumber(request.getPhoneNumber());
        user.seteMail(request.geteMail());
        return user;
    }

    public static UserResponse mapUserToResponse(User user){
        UserResponse  userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setMessage("CONGRATULATIONS, WELCOME TO NISSEE'SBOOK LIBRARY");
        return userResponse;
    }

    public static BorrowedBooks mapBorrowedRequestToBorrowedBook(BorrowBookRequest request){
        BorrowedBooks borrowedBook = new BorrowedBooks();
        borrowedBook.setBookId(Checker.CheckForRequest(request));
        borrowedBook.setUserId(request.getUserId());
        borrowedBook.setBorrowedDate(LocalDate.now());
        borrowedBook.setReturnDate(LocalDate.now().plusDays(request.getDays()));
        return borrowedBook;
    }

    public static BorrowBookResponse mapResponse(BorrowedBooks books){
        BorrowBookResponse response = new BorrowBookResponse();
        BookRespository repo = new BookRepositoryImpl();
        response.setMessage("BOOK BORROWED SUCCESFULLY");
        response.setBorrowDate(books.getBorrowedDate());
        response.setReturnDate(books.getReturnDate());
        response.setBook(repo.findById(books.getBookId()));
        return response;

    }
}
