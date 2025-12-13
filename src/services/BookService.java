package services;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

import java.util.ArrayList;

public interface BookService {
    AddBookResponse addBook (AddBookRequest request);
    String viewAllBooks();
}
