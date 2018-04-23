package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Author;

import java.util.List;

public interface AuthorDao {
    public void addAuthor(Author author);

    public void updateAuthor(Author author);

    public void removeAuthor(int authorId);

    public Author getAuthorById(int authorId);

    public List<Author> listAuthors();
}
