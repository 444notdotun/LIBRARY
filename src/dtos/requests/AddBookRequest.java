package dtos.requests;

import data.models.Genre;

public class AddBookRequest {
    private String bookName;
    private int edition;
    private String description;
    private int quantity;
    private String author;
    private String Isbn;
    private Genre genre;

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }



    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
