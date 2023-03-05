package Models;

public class Book {
    private int idBook;
    private String title;
    private String description;
    private String author;
    private int releaseYear;

    public Book( String title, String description, String author, int releseYear) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.releaseYear = releseYear;
    }
    public Book(Integer id,String title, String description, String author, int releseYear){
        this(title,description,author,releseYear);
        this.idBook=id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", releseYear=" + releaseYear +
                '}';
    }
}
