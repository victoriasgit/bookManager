package net.proselyte.bookmanager.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GENRES")
public class Genre {
    @Id
    @Column(name = "GENRE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    @Column(name = "GENRE_TITLE")
    private String genreTitle;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    /* EXAMPLE One To Many */
    @OneToMany(targetEntity = Book.class)
    private Set<Book> book = new HashSet<Book>();

    public Set<Book> getBook() {
        return this.book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

//    public void addBook(Book book) {
//        book.setGenre(this);
//        getBook().add(book);
//    }
//
//    public void removeBook(Book book) {
//        getBook().remove(book);
//    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreTitle=" + genreTitle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (genreId != genre.genreId) return false;
        if (genreTitle != null ? !genreTitle.equals(genre.genreTitle) : genre.genreTitle != null) return false;
        return book != null ? book.equals(genre.book) : genre.book == null;
    }

    @Override
    public int hashCode() {
        int result = genreId;
        result = 31 * result + (genreTitle != null ? genreTitle.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }
}
