import java.util.Scanner;

public class main {
    private static final BookManager bookManager = new BookManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Menu Główne:");
            System.out.println("[1] Dodaj książke");
            System.out.println("[2] Usuń książke");
            System.out.println("[3] Zaaktualizuj książke");
            System.out.println("[4] Lista książek");
            System.out.println("[5] Wyjście");

            System.out.print("Wybierz opcję: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Podaj autora: ");
        String author = scanner.nextLine();
        System.out.print("Podaj ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Podaj rok wydania: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        bookManager.addBook(new Book(title, author, isbn, year));
        System.out.println("Książka dodana.");
    }

    private static void removeBook() {
        System.out.print("Podaj tytuł książki do usunięcia: ");
        String title = scanner.nextLine();
        for (Book book : bookManager.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookManager.removeBook(book);
                System.out.println("Książka usunięta.");
                return;
            }
        }
        System.out.println("Książka nie znaleziona.");
    }

    private static void updateBook() {
        System.out.print("Podaj tytuł książki do zaktualizowania: ");
        String title = scanner.nextLine();
        for (Book book : bookManager.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Nowy tytuł: ");
                String newTitle = scanner.nextLine();
                System.out.print("Nowy autor: ");
                String newAuthor = scanner.nextLine();
                System.out.print("Nowy ISBN: ");
                String newIsbn = scanner.nextLine();
                System.out.print("Nowy rok wydania: ");
                int newYear = scanner.nextInt();
                scanner.nextLine();
                bookManager.updateBook(book, new Book(newTitle, newAuthor, newIsbn, newYear));
                System.out.println("Książka zaktualizowana.");
                return;
            }
        }
        System.out.println("Książka nie znaleziona.");
    }

    private static void listBooks() {
        System.out.println("Lista książek:");
        for (Book book : bookManager.getBooks()) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " - " + book.getIsbn() + " - " + book.getYear());
        }
    }
}
