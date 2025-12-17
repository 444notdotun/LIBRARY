package services;

import data.models.Book;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import exceptions.ValidateBook;
import utils.Mapper;

import java.util.ArrayList;

public class BookServiceImpl implements BookService{
    BookRespository bookRespository = new BookRepositoryImpl();

    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        validateBook(request);
        Book book = Mapper.mapRequestToBook(request);
        bookRespository.save(book);
       return Mapper.mapBookDetailsToResponse(book);
    }

    @Override
    public String viewAllBooks() {
        int count = 0;
        StringBuilder allBooks = new StringBuilder();
        for(Book book:bookRespository.returnAllBooks()) allBooks.append(String.format("BOOK%d%n AUTHOR:%s%n DESCRIPTION:%s%n TITLE:%s%n EDITION:%s%n QUANTITY:%s%n GENRE:%s%n TOTAL PAGE:%s%n ISBN:%s%n%n",++count ,book.getAuthor(),book.getDescription(),book.getName(),book.getEdition(),book.getQuantity(),book.getGenre(),book.getPage(),book.getIsbn()));
        return allBooks.toString();
    }

    private void validateBook(AddBookRequest addBookRequest){
        if(addBookRequest == null)
            throw new ValidateBook("BOOK IS NULL");
    }
}
