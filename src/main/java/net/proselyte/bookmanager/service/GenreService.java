package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.model.Genre;

import java.util.List;

public interface GenreService {
    public void addGenre(Genre genre);

    public void updateGenre(Genre genre);

    public void removeGenre(int genreId);

    public Genre getGenreById(int genreId);

    public List<Genre> listGenres();
}
