package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao{
    private static final Logger logger = LoggerFactory.getLogger(GenreDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGenre(Genre genre) {
        Session session = this.sessionFactory.getCurrentSession();
        genre.setGenreId(0);
        session.persist(genre);
        logger.info("Genre successfully saved. Genre details: " + genre);
    }

    @Override
    public void updateGenre(Genre genre) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(genre);
        logger.info("Genre successfully update. Genre details: " + genre);
    }

    @Override
    public void removeGenre(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Genre genre = (Genre) session.load(Genre.class, new Integer(id));

        if(genre!=null){
            session.delete(genre);
        }
        logger.info("Genre successfully removed. Genre details: " + genre);
    }

    @Override
    public Genre getGenreById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Genre genre = (Genre) session.load(Genre.class, new Integer(id));
        logger.info("Genre successfully loaded. Genre details: " + genre);

        return genre;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> listGenres() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Genre> genreList = session.createQuery("from Genre").list();

        for(Genre genre: genreList){
            logger.info("Genre list: " + genre);
        }

        return genreList;
    }
}
