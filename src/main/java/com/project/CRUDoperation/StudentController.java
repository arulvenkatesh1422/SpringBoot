package com.project.CRUDoperation;

import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

@CrossOrigin
@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	private studentsImpl studentservice;

	// create API

	@PostMapping("/createStudents")
	public ResponseEntity<StudentsDto> createStudent(@RequestBody StudentsDto dto) {
		ResponseEntity<StudentsDto> created = studentservice.createStudent(dto);
		return created;

	}
	// Update Api

	@PutMapping("/{studentId}")
	public ResponseEntity<StudentsDto> updateStudent(@PathVariable(value = "studentId") Long studentId,
			@RequestBody StudentsDto dto) {
		ResponseEntity<StudentsDto> updatedsuccessfully = studentservice.updateStudents(studentId, dto);
		return updatedsuccessfully;

	}
	// search All students API

	@GetMapping("/searchStudents")
	public List<Students> searchAllstudents() {
		return studentservice.getAllstudents();

	}

	// Delete student API

	@DeleteMapping("/delete/{studentsId}")
	public Map<String, Long> deleteStudent(@PathVariable(value = "studentsId") Long studentsId) {
		Map<String, Long> deletesuccessfull = studentservice.deleteStudent(studentsId);
		return deletesuccessfull;

	}
	
	@GetMapping("/search")
	public List<StudentsDto> search(@RequestParam(required = false) String studentName,@RequestParam(required = false) String email) {
		List<StudentsDto> searched = studentservice.search(studentName, email);
		return searched;
	}
			

}
