package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Book;
//import net.proselyte.bookmanager.model.ViewAllBook;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int bookId);

    public Book getBookById(int bookId);

    public List<Book> listBooks();

//    public List<ViewAllBook> listBooks();
}
