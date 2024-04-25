package ccs217_6.ex1;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class BookInventorySystem {
    private List<Book> availableBooks;

    public BookInventorySystem() {
        availableBooks = new ArrayList<>();
        availableBooks.add(new Book("Book 1"));
        availableBooks.add(new Book("Book 2"));
        availableBooks.add(new Book("Book 3"));
    }

    public boolean isBookAvailable(String bookTitle) {
        return availableBooks.stream().anyMatch(book -> book.getTitle().equalsIgnoreCase(bookTitle));
    }

    public void borrowBook(String bookTitle) {
        Book book = availableBooks.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(bookTitle))
                .findFirst()
                .orElse(null);

        if (book != null) {
            availableBooks.remove(book);
            System.out.println("Book '" + book.getTitle() + "' borrowed successfully.");
        } else {
            System.out.println("Sorry, book '" + bookTitle + "' is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        availableBooks.add(book);
        System.out.println("Book '" + book.getTitle() + "' returned successfully.");
    }
}

class LibraryFacade {
    private BookInventorySystem bookSystem;

    public LibraryFacade() {
        bookSystem = new BookInventorySystem();
    }

    public void borrowBook(String bookTitle) {
        if (bookSystem.isBookAvailable(bookTitle)) {
            bookSystem.borrowBook(bookTitle);
        } else {
            System.out.println("Book '" + bookTitle + "' is not available.");
        }
    }

    public void returnBook(String bookTitle) {
        Book book = new Book(bookTitle);
        bookSystem.returnBook(book);
    }

    public void searchBook(String bookTitle) {
        if (bookSystem.isBookAvailable(bookTitle)) {
            System.out.println("Book '" + bookTitle + "' is available.");
        } else {
            System.out.println("Book '" + bookTitle + "' is not available.");
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        LibraryFacade facade = new LibraryFacade();

        facade.borrowBook("Book 1");
        facade.borrowBook("Book 4");
        facade.returnBook("Book 1");
        facade.searchBook("Book 3");
    }
}
