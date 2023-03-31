package com.bookstore.mysql.repository;

import com.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface TodoRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a ")
//    + " WHERE 1=1 AND a.id < 40200")
    @QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "1000"))
    Stream<Author> streamAll();

    /* use this method if you add to JDBC URL the useCursorFetch=true setting
    @Query("SELECT a FROM Author a")
    @QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "30"))
    Stream<Author> streamAll();
    */

    @Query("SELECT a FROM Author a WHERE a.id > :idLeft")
    @QueryHints(value = @QueryHint(name = HINT_FETCH_SIZE, value = "1000"))// + Integer.MIN_VALUE))
    Stream<Author> findByIdBetween(Long idLeft);
}
