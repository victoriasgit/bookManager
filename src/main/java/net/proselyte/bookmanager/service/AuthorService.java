package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.model.Author;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author);

    public void updateAuthor(Author author);

    public void removeAuthor(int authorId);

    public Author getAuthorById(int authorId);

    public List<Author> listAuthors();
}
