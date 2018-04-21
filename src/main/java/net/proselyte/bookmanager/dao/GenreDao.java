package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Genre;

import java.util.List;

public interface GenreDao {
    public void addGenre(Genre genre);

    public void updateGenre(Genre genre);

    public void removeGenre(int genreId);

    public Genre getGenreById(int genreId);

    public List<Genre> listGenres();
}
