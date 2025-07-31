package com.project.CRUDoperation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long>{

	List<Students> findByEmail(String email);
	
	Students findByStudentId(Long studentdto);

	List<Students> findByStudentNameStartingWith(String studentName);

}
