package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.BookDao;
import net.proselyte.bookmanager.model.Book;
//import net.proselyte.bookmanager.model.ViewAllBook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int bookId) {
        this.bookDao.removeBook(bookId);
    }

    @Override
    @Transactional
    public Book getBookById(int bookId) {
        return this.bookDao.getBookById(bookId);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }

//    @Override
//    @Transactional
//    public List<ViewAllBook> listBooks() {
//        return this.bookDao.listBooks();
//    }
}
