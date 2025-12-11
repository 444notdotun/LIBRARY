package data.models;

import java.util.ArrayList;

public class User {
    private String name;
    private int id;
    private String number;
    private String address;
    private ArrayList<BorrowedBooks> books = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<BorrowedBooks> getBooks() {
        return books;
    }

    public void setBooks(BorrowedBooks book) {
        books.add(book);
    }
}
