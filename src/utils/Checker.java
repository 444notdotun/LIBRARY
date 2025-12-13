package utils;

import data.models.Book;
import data.respositories.BookRepositoryImpl;
import data.respositories.BookRespository;
import dtos.requests.BorrowBookRequest;

public class Checker {
    public static int CheckForRequest(BorrowBookRequest request){
        BookRespository bookRespository = new BookRepositoryImpl();
        for( Book book :bookRespository.returnAllBooks()){
            if(book.getAuthor().equalsIgnoreCase(request.getAuthor())&&book.getName().equalsIgnoreCase(request.getBookname())&&book.getEdition().equalsIgnoreCase(request.getEdition())) {
                if(book.getQuantity()>0){
                    return book.getId();
                }
               return -1;
            }
        }
        return 0;
    }
}
