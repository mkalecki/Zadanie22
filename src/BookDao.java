import java.sql.*;

public class BookDao {

    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC&characterEncoding\n" +
            "=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private Connection connection;

    public BookDao() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("błąd połączenia z bazą 'library'");
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void save(Book book) {
        String qry = "insert into books (title,author,year,isbn) values (?,?,?,?)";
        try {
            PreparedStatement prepStat = connection.prepareStatement(qry);

            prepStat.setString(1, book.getTitle());
            prepStat.setString(2, book.getAuthor());
            prepStat.setInt(3, book.getYear());
            prepStat.setInt(4, book.getIsbn());

            prepStat.executeUpdate(); //update bazy

        } catch (SQLException e) {
            System.out.println("Nie udało się zapisać danych");

            e.printStackTrace();
        }
    }

    public Book read(int isbn) {
        String qry = "select id, title, author, year, isbn from books where isbn=?";
        try {
            PreparedStatement prepStat = connection.prepareStatement(qry);
            prepStat.setInt(1, isbn);
            ResultSet result = prepStat.executeQuery();

            if (result.next()) {
                Book book = new Book();
                book.setId(result.getInt("id"));
                book.setAuthor(result.getString("author"));
                book.setTitle(result.getString("title"));
                book.setYear(result.getInt("year"));
                book.setIsbn(result.getInt("isbn"));
                return book;
            }

        } catch (SQLException e) {
            System.out.println("błąd odczytu z bazy");
            e.printStackTrace();
        }
        System.out.println("nie ma takiej książki");
        return null;
    }

    public void update (Book book){
        String qry = "update books set title=?, author=?, year=?, isbn=? where id=?";
        try {
            PreparedStatement prepStat = connection.prepareStatement(qry);

            prepStat.setString(1, book.getTitle());
            prepStat.setString(2, book.getAuthor());
            prepStat.setInt(3, book.getYear());
            prepStat.setInt(4, book.getIsbn());
            prepStat.setInt(5,book.getId());

            prepStat.executeUpdate(); //update bazy

        } catch (SQLException e) {
            System.out.println("Nie udało się zmodyfikować rekordu");

            e.printStackTrace();
        }
    }


    public void close () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
