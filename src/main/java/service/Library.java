package service;
import model.Book;
import model.Member;
import java.util.ArrayList;
import java.util.List;
public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully!");
    }
    public void issueBook(String bookId, String memberId) {
        // বই ইস্যু করার লজিক
        Book book = findBook(bookId);
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book unavailable or not found.");
        }
    }
    public void returnBook(String bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Invalid return request.");
        }
    }

    public Book findBook(String bookId) {
        for (Book b : books) {
            if (b.getBookId().equalsIgnoreCase(bookId)) return b;
        }
        return null;
    }
}