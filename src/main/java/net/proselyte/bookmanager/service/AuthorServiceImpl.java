package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.AuthorDao;
import net.proselyte.bookmanager.model.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao;

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDao.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDao.updateAuthor(author);
    }

    @Override
    @Transactional
    public void removeAuthor(int authorId) {
        this.authorDao.removeAuthor(authorId);
    }

    @Override
    @Transactional
    public Author getAuthorById(int authorId) {
        return this.authorDao.getAuthorById(authorId);
    }

    @Override
    @Transactional
    public List<Author> listAuthors() {
        return this.authorDao.listAuthors();
    }
}

