package data.models;

import java.util.ArrayList;

public class User {
    private String name;
    private int userId;
    private String number;
    private String address;
    private String eMail;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();


    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Book book) {
        borrowedBooks.add(book);
    }
}
