package services;

import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import exceptions.ValidateBook;
import utils.Mapper;

public class BookServiceImpl implements BookService{
    BookRespository bookRespository = new BookRepositoryImpl();

    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        validateBook(request);
       return Mapper.mapBookDetailsToResponse(bookRespository.save( Mapper.mapRequestToBook(request)));
    }

    private void validateBook(AddBookRequest addBookRequest){
        if(addBookRequest == null)
            throw new ValidateBook("BOOK IS NULL");
    }
}
