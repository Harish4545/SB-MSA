package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{

	//books based on title
	public List<Book> findByTitle(String title);
	public List<Book> findByTitleLike(String titlePattern);
	
	// books which are stocked above 120
	public List<Book> findByStockGreaterThan(Long stock);
	
	@Query("from Book as b where b.stock>:stock")
	public List<Book> getBooksStockGt(@Param("stock") Long stock);
	
	// update stock of all books that have less than 120 by 50
	
	@Transactional
	@Modifying
	@Query("update Book b set b.stock=b.stock+:newstock where b.stock < :stock")
	public int updateStock(@Param("stock") Long stock,@Param("newstock") Long newStock);
}



