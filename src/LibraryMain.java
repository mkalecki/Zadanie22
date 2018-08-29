import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        String menu = "1-dodaj ksiązkę, 2-wyświetl książkę, 3-zmodyfikuj 0-wyjście z programu";
        Scanner scanner = new Scanner(System.in);
        BookDao bookDao = new BookDao();
        Book book = new Book();
        int option = 10;
        int isbn;
        do {
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    System.out.println("podaj tytuł:");
                    book.setTitle(scanner.nextLine());
                    System.out.println("autor:");
                    book.setAuthor(scanner.nextLine());
                    System.out.println("Rok:");
                    book.setYear(scanner.nextInt());
                    System.out.println("isbn:");
                    book.setIsbn(scanner.nextInt());
                    scanner.nextLine();
                    bookDao.save(book);
                    break;

                case 2:
                    System.out.println("Szukamy ksiązki o numarze ISBN: ");
                    isbn = scanner.nextInt();
                    scanner.nextLine();
                    book = bookDao.read(isbn);
                    if (book != null)
                        System.out.println("Znaleziono książkę: " + book.toString());
                    else
                        System.out.println("nie mamy takiej książki");
                    break;
                case 3:
                    System.out.println("Modyfikujemy ksiązkę o numarze ISBN: ");
                    isbn = scanner.nextInt();
                    scanner.nextLine();
                    book = bookDao.read(isbn);
                    if (book != null) {
                        System.out.println("Znaleziono książkę: " + book.toString());
                        System.out.println("podaj nowy tytuł");
                        book.setTitle(scanner.nextLine());
                        bookDao.update(book);
                        System.out.println("teraz ta książka to: ");
                        System.out.println(bookDao.read(isbn).toString());
                    } else System.out.println("nie mamy takiej ksiazki");
                    break;
                case 0:
                    bookDao.close();
                    System.out.println("no to kończymy na dzisiaj, papa");
                    break;
                default:
                    System.out.println("tego nie możemy zrobić, wybierz prawidłową opcję");
            }
        }
        while (option != 0);



    }
}
