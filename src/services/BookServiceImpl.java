package services;

import data.models.Book;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import utils.Mapper;

public class BookServiceImpl implements BookService{
    BookRespository bookRespository = new BookRepositoryImpl();
    Book book = new Book();
    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        Mapper.mapRequestToBook(request);
        bookRespository.save(book);
       return Mapper.mapBookDetailsToResponse(book);
    }
}
