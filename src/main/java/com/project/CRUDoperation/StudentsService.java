package com.project.CRUDoperation;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface StudentsService {

	public ResponseEntity<StudentsDto> createStudent(StudentsDto studentdto);

	public ResponseEntity<StudentsDto> updateStudents(Long studentsId, StudentsDto studentdto);

	public List<Students> getAllstudents();

	public Map<String, Long> deleteStudent(Long studentsId);
	
	public List<StudentsDto> search(String studentName,String email);

	

}
