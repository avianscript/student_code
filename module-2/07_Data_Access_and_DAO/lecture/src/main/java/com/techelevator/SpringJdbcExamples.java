package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class SpringJdbcExamples {

    private BasicDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public SpringJdbcExamples() {

        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/MovieDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        jdbcTemplate = new JdbcTemplate(dataSource);

    }



    /**
     *
     * Uses jdbcTemplate.queryForRowSet
     *
     */

    public void listMovies() {
        SqlRowSet movies = jdbcTemplate.queryForRowSet("SELECT movie_id, title FROM movie");

        while(movies.next()) {
            String title = movies.getString("title");
            Long id = movies.getLong("movie_id");
            System.out.println(id + " " + title);
        }
    }


    /**
     *
     * Uses jdbcTemplate.queryForRowSet w/query param
     *
     */

    public void printTitleById(Integer movieId) {
        SqlRowSet movies = jdbcTemplate.queryForRowSet("SELECT title "
                + "FROM movie WHERE movie_id = ?", movieId);

        while (movies.next()) {
            System.out.println(movies.getString("title"));
        }
    }

    /**
     *
     * Uses jdbcTemplate.queryForObject
     *
     */
    public void printStateCount() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM state", Integer.class);
        if (count != null) {
            System.out.println(String.format("State count: %d", count));
        }
    }

    public void printMovieCount() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM movie", Integer.class);

        if (count != null) {
            System.out.println(String.format("Movie count: %d", count));
        }
    }

    /**
     *
     * Uses jdbcTemplate.queryForObject w/query param
     *
     */

    public void printMovieTitle(Integer movieId) {
        String stateName = jdbcTemplate.queryForObject("SELECT title FROM movie WHERE movie_id = ?",
                String.class, movieId);
        System.out.println(stateName);
    }

    public void printMoviesStartingWith(String startsWith) {
        SqlRowSet movies = jdbcTemplate.queryForRowSet("SELECT title FROM movie WHERE title ILIKE ?",
                startsWith + "%");
        while (movies.next()) {
            String title = movies.getString("title");
            System.out.println(title);
        }
    }
}