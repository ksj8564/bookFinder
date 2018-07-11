package com.bookFinder.repo;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookFinder.model.Student;
 

@Repository
public interface BookFinderRepository extends CrudRepository<Student, String> {}


