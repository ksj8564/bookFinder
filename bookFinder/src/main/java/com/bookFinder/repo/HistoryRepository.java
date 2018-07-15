package com.bookFinder.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bookFinder.model.History;

@Repository("historyRepository")
public interface HistoryRepository extends PagingAndSortingRepository<History, Integer>{
	@Query(value="select new com.bookFinder.model.History(query, target, dateCreated) from History order by date_created desc")
	List<History> findAllByUserId(int userId, Pageable topTen);
}
