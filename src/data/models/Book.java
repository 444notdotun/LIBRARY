package data.models;


public class Book {
    private String name;
    private String author;
    private int isbn;
    private int page;
    private  String description;
    private int quantity;
    private int edition;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private int Id;

    public String getEdition() {
        if(edition ==12 ||edition==13||edition==14||edition==15) return edition+ "th" +"edition";
        if(edition%10==1)return edition+"st"+" edition";
        if(edition%10==2)return edition+"nd"+" edition";
        if(edition%10==3)return edition+"rd"+" edition";
        return edition+ "th" +"edition";
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuality() {
        return quantity;
    }

    public void setQuality(int quality) {
        this.quantity = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
