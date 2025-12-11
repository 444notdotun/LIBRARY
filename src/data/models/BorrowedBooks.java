package data.models;

public class BorrowedBooks {
    private int bookId;
    private int userId;
    private String BorrowedDate;
    private  String ReturnData;
    private boolean isReturned;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBorrowedDate() {
        return BorrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        BorrowedDate = borrowedDate;
    }

    public String getReturnData() {
        return ReturnData;
    }

    public void setReturnData(String returnData) {
        ReturnData = returnData;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
