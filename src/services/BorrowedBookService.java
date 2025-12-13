package services;

import data.models.Book;
import dtos.requests.BorrowBookRequest;

public interface BorrowedBookService {
    Book BorrowBook(BorrowBookRequest request);
}
