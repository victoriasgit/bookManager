package net.proselyte.bookmanager.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
public class Author {
    @Id
    @Column(name = "AUTHOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "AUTHOR_SURNAME")
    private String authorSurname;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String  getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
        return "Author{" +
                "authorId=" + authorId +
                ", authorSurname='" + authorSurname + '\'' +
                ", authorName='" + authorName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorId != author.authorId) return false;
        if (authorSurname != null ? !authorSurname.equals(author.authorSurname) : author.authorSurname != null)
            return false;
        if (authorName != null ? !authorName.equals(author.authorName) : author.authorName != null) return false;
        return book != null ? book.equals(author.book) : author.book == null;
    }

    @Override
    public int hashCode() {
        int result = authorId;
        result = 31 * result + (authorSurname != null ? authorSurname.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }
}
