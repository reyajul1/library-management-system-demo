package model;

public class Book {
    private final String bookId;
    private final String title;
    private boolean isIssued;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.isIssued = false;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }
}