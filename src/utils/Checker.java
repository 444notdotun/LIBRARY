package utils;

import data.models.Book;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.BorrowBookRequest;
import exceptions.ValidateBook;

public class Checker {
    public static int CheckForRequest(BorrowBookRequest request){
        BookRespository bookRespository = new BookRepositoryImpl();
        for( Book book :bookRespository.returnAllBooks()){
            if(book.getAuthor().equalsIgnoreCase(request.getAuthor())&&book.getName().equalsIgnoreCase(request.getBookname())&&book.getEdition().equalsIgnoreCase(request.getEdition())) {
                if(book.getQuantity()>=0){
                    return book.getId();
                }
               throw new ValidateBook("SORRY WE ARE OUT OF STOCK");
            }
        }
       throw  new ValidateBook("BOOK NOT FOUND");
    }


}
