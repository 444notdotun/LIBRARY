package dtos.requests;

public class BorrowBookRequest {
    private String bookname;
    private String Author;
    private  int edition;
    private int userId;
    private int days;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getBookname(){
        return bookname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookname(String bookname){
        this.bookname = bookname;
    }

    public String getAuthor(){
        return Author;
    }

    public void setAuthor(String author){
        Author = author;
    }

    public String getEdition(){
        if(edition ==12 ||edition==13||edition==14||edition==15) return edition+ "th" +"edition";
        if(edition%10==1)return edition+"st"+" edition";
        if(edition%10==2)return edition+"nd"+" edition";
        if(edition%10==3)return edition+"rd"+" edition";
        return edition+ "th" +"edition";
    }

    public void setEdition(int edition){
        this.edition = edition;
    }
}
