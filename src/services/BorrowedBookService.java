package services;

import data.models.Book;
import dtos.requests.BorrowBookRequest;
import dtos.responses.BorrowBookResponse;
import dtos.responses.ReturnBookResponse;

public interface BorrowedBookService {
    BorrowBookResponse BorrowBook(BorrowBookRequest request);

    ReturnBookResponse returnBorrowedBook(Book book);
}
