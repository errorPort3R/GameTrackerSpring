package com.theironyard.services;

import com.theironyard.entities.Game;
import com.theironyard.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zach on 3/8/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    public Iterable<Game> findByUser(User user);
    public Iterable<Game> findByUserAndGenre(User user, String genre);
    public Iterable<Game> findByUserAndGenreAndReleaseYear(User user, String genre, int releaseYear);
    public Iterable<Game> findByUserAndGenreAndReleaseYearIsGreaterThanEqual(User user, String genre, int minReleaseYear);

    public Game findFirstByGenre(String genre);
    public int countByGenre(String genre);
    public List<Game> findByGenreOrderByNameAsc(String genre);

    @Query("SELECT g FROM Game g WHERE g.platform LIKE ?1%")
    public Iterable<Game> findByPlatformStartsWith(String platform);
}
