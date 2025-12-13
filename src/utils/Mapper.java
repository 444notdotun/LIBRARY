package utils;

import data.models.Book;
import data.models.BorrowedBooks;
import dtos.requests.AddBookRequest;
import dtos.requests.BorrowBookRequest;
import dtos.responses.AddBookResponse;

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

    public static BorrowedBooks mapBorrowedRequestToBorrowedBook(BorrowBookRequest request){
        BorrowedBooks borrowedBook = new BorrowedBooks();
        borrowedBook.setBookId(Checker.CheckForRequest(request));
        borrowedBook.setUserId(request.getUserId());
        return borrowedBook;
    }
}
