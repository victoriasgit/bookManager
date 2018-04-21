package net.proselyte.bookmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "BOOK_TITLE")
    private String bookTitle;

//    @Column(name = "AUTHOR_ID")
//    private int authorId;

    @Column(name = "BOOK_PRICE")
    private int price;

//    @Column(name = "GENRE_ID")
//    private int genreId;

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

//    public int getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(int authorId) {
//        this.authorId = authorId;
//    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public int getGenreId() {
//        return genreId;
//    }
//
//    public void setGenreId(int genreId) {
//        this.price = genreId;
//    }

//    /* EXAMPLE Many To One */
//    private int authorId;
//
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    public int getAuthorId() {
//        return this.authorId;
//    }
//
//    public void setAuthorId(int authorId) {
//        this.authorId = authorId;
//    }
//
//    /* EXAMPLE Many To One */
//    private int genreId;
//
//    @ManyToOne
//    @JoinColumn(name = "genre_id")
//    public int getGenreId() {
//        return this.genreId;
//    }
//
//    public void setGenreId(int genreId) {
//        this.genreId = genreId;
//    }

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "AUTHOR_ID")
    private Author authorId;

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    private Genre genreId;

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", authorId='" + authorId + '\'' +
                ", price=" + price + '\'' +

                ", genre=" + genreId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (price != book.price) return false;
        if (bookTitle != null ? !bookTitle.equals(book.bookTitle) : book.bookTitle != null) return false;
        if (authorId != null ? !authorId.equals(book.authorId) : book.authorId != null) return false;
        return genreId != null ? genreId.equals(book.genreId) : book.genreId == null;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (genreId != null ? genreId.hashCode() : 0);
        return result;
    }
}
