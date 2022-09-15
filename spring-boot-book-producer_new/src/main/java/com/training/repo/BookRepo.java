package com.training.repo;

import java.lang.annotation.Native;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	// retrieve all C Books   based on title
	
	List<Book> findByTitleLike(String title);
	
	// stock > 100
	
	
	@Query("from Book b where b.stock > :stock")
	List<Book> getByStockGreaterThan(@Param("stock") Long stock);
	
	// update stock of all the books that are titled with pattern C
		
	@Transactional
	@Modifying
	@Query("update Book b set b.stock= b.stock + :newstock where b.title like :pattern")
	int updateStockTitle(@Param("pattern") String titlePattern,@Param("newstock") Long newStock);
		
}


