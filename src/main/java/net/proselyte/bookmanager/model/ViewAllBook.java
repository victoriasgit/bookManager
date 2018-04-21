package net.proselyte.bookmanager.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity(name = "view_allbooks")
@Immutable
public class ViewAllBook {

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "BOOK_PRICE")
    private int price;

    @Column(name = "BOOK_GENRE")
    private String genreTitle;

    @Column(name = "BOOK_TITLE")
    private String bookTitle;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Column(name = "AUTHOR_SURNAME")
    private String authorSurname;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", price=" + price + '\'' +
                ", genre=" + genreTitle + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname +
                '}';
    }
}
