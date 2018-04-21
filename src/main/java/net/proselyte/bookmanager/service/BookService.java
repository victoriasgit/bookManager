package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.model.Book;
import net.proselyte.bookmanager.model.ViewAllBook;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int bookId);

    public Book getBookById(int bookId);

    public List<ViewAllBook> listBooks();
}
