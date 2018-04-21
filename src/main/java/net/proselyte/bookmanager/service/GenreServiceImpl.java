package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.GenreDao;
import net.proselyte.bookmanager.model.Genre;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreDao genreDao;

    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    @Transactional
    public void addGenre(Genre genre) {
        this.genreDao.addGenre(genre);
    }

    @Override
    @Transactional
    public void updateGenre(Genre genre) {
        this.genreDao.updateGenre(genre);
    }

    @Override
    @Transactional
    public void removeGenre(int genreId) {
        this.genreDao.removeGenre(genreId);
    }

    @Override
    @Transactional
    public Genre getGenreById(int genreId) {
        return this.genreDao.getGenreById(genreId);
    }

    @Override
    @Transactional
    public List<Genre> listGenres() {
        return this.genreDao.listGenres();
    }
}

