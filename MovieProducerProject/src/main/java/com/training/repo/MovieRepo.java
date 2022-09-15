package com.training.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.bean.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long>{

	/* get Movie List based on title pattern */
	List<Movie> findByTitleLike(String title);
	/* get all Movies based on a Genre */
	List<Movie> findByGenre(String genre);
	
	@Query(value="SELECT m FROM Movie e WHERE e.name LIKE :name ORDER BY e.id offset :offset limit :limit", nativeQuery = true)
    public List<Movie> findByNameAndMore(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);
	
}
