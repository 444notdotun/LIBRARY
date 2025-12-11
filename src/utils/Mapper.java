package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public class Mapper {
    public static Book mapRequestToBook(AddBookRequest request){
        Book book = new Book();
        book.setName(request.getBookName());
        book.setEdition(request.getEdition());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setQuality(request.getQuantity());
        return book;
    }


    public static AddBookResponse mapBookDetailsToResponse(Book book){
        AddBookResponse addBookResponse= new AddBookResponse();
        addBookResponse.setBookName(book.getName());
        addBookResponse.setQuantity(book.getQuality());
        addBookResponse.setEdition(book.getEdition());
        addBookResponse.setDescription(book.getDescription());
        addBookResponse.setAuthor(book.getAuthor());
        return addBookResponse;
    }
}
