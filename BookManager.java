import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
        books.add(new Book("Władca Pierścieni", "J.R.R. Tolkien", "9788373191723", 2019));
        books.add(new Book("Złodziejka książek", "Markus Zusak", "9788379858269", 2007));
        books.add(new Book("Opowieść podręcznej", "Margaret Atwood", "9788374694934", 2017));
        books.add(new Book("Wzgórze psów", "Cormac McCarthy", "9788375081541", 2008));
        books.add(new Book("Ciemność na skraju wszechświata", "Frank Schätzing", "9788379851956", 2018));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
        }
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
