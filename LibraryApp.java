import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
interface Library {
    void addBook(Book book);
    void listBooks();
    Book searchBook(String title);
}
class Book {
    private String title;
    private String author;
    private String isbn;
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public void displayBookInfo() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
    }
    public String getTitle() {
        return title;
    }
}
class LibraryImpl implements Library {
    private String name;
    private String address;
    private List<Book> books;
    public LibraryImpl(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }
    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }
    @Override
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nBooks in Library:");
            for (Book book : books) {
                book.displayBookInfo();
                System.out.println("------------------------");
            }
        }
    }
    @Override
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                book.displayBookInfo();
                return book;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
        return null;
    }
}
public class LibraryApp {
    public static void main(String[] args) {
        LibraryImpl library = new LibraryImpl("City Library", "123 Main Street");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1:
                    System.out.print("Enter title : ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN  : ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
