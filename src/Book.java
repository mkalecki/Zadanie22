public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private int isbn;

    public Book() {}

    public Book(String title, String autor, int year, int isbn) {
        this.title = title;
        this.author = autor;
        this.year = year;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + author + '\'' +
                ", year=" + year +
                ", isbn=" + isbn +
                '}';
    }
}
