package com.project.CRUDoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class studentsImpl implements StudentsService {

	@Autowired
	private StudentsRepository studentrepo;

	// student creation method

	@SuppressWarnings("unused")
	@Override
	public ResponseEntity<StudentsDto> createStudent(StudentsDto studentdto) {

		StudentsDto response = new StudentsDto();

		if (studentdto.getStudentId() == null) {

			Students students = new Students();
			students.setStudentId(studentdto.getStudentId());
			students.setStudentName(studentdto.getStudentName());
			students.setEmail(studentdto.getEmail());
			students.setAddress(studentdto.getAddress());
			students.setMobile(studentdto.getMobile());
			students.setCreatedAt(studentdto.getCreatedAt());
			students.setUpdatedAt(studentdto.getUpdatedAt());
			// student created using repository
			Students created = studentrepo.save(students);

			// here was set response
			response.setStudentId(created.getStudentId());
			response.setStudentName(created.getStudentName());
			response.setEmail(created.getEmail());
			response.setAddress(created.getAddress());
			response.setMobile(created.getMobile());
			response.setCreatedAt(created.getCreatedAt());
			response.setUpdatedAt(created.getUpdatedAt());

		} else {

			throw new ValidationException(Constant.Resource_Not_f);

		}

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// student update method
	@SuppressWarnings({ "static-access", "unlikely-arg-type" })
	@Override
	public ResponseEntity<StudentsDto> updateStudents(Long studentsId, StudentsDto studentdto) {

		StudentsDto response = new StudentsDto();

		if (studentsId==null) {

			throw new ValidationException(Constant.Resource_Not_present);
		}

		Optional<Students> existstudent = studentrepo.findById(studentdto.getStudentId());

		if (!existstudent.isPresent()) {

			throw new ValidationException(Constant.Resource_Not_present);

		} else {

			Students updatestudent = existstudent.get();
			updatestudent.setStudentId(studentdto.getStudentId());
			updatestudent.setStudentName(studentdto.getStudentName());
			updatestudent.setEmail(studentdto.getEmail());
			updatestudent.setAddress(studentdto.getAddress());
			updatestudent.setMobile(studentdto.getMobile());
			updatestudent.setCreatedAt(studentdto.getCreatedAt());
			updatestudent.setUpdatedAt(studentdto.getUpdatedAt());
			// here student updated using repository
			Students updatedsuccess = studentrepo.save(updatestudent);
			// response setting
			response.setStudentId(updatedsuccess.getStudentId());
			response.setStudentName(updatedsuccess.getStudentName());
			response.setEmail(updatedsuccess.getEmail());
			response.setAddress(updatedsuccess.getAddress());
			response.setMobile(updatedsuccess.getMobile());
			response.setCreatedAt(updatedsuccess.getCreatedAt());
			response.setUpdatedAt(updatedsuccess.getUpdatedAt());

		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public List<Students> getAllstudents() {

		List<Students> searchAllStudent = studentrepo.findAll();
		return searchAllStudent;
	}

	@Override
	public Map<String, Long> deleteStudent(Long studentsId) {

		Map<String, Long> response = new HashMap<String, Long>();

		if (studentsId != null) {
			studentrepo.deleteById(studentsId);
			response.put("Delete success deleted id is :", studentsId);
		} else {

			throw new ValidationException(Constant.Resource_Not_present);
		}

		return response;
	}

	@Override
	public List<StudentsDto> search(String studentName, String email) {

		List<StudentsDto> searchlist = new ArrayList<StudentsDto>();

		List<Students> search;
		if (studentName != null) {
			search = studentrepo.findByStudentNameStartingWith(studentName);

			for (Students itr : search) {

				StudentsDto dto = new StudentsDto();
				dto.setStudentId(itr.getStudentId());
				dto.setStudentName(itr.getStudentName());
				dto.setEmail(itr.getEmail());
				dto.setMobile(itr.getMobile());
				dto.setCreatedAt(itr.getCreatedAt());
				dto.setUpdatedAt(itr.getUpdatedAt());
				searchlist.add(dto);
			}

		} else {

			search = studentrepo.findByEmail(email);
			for (Students itr : search) {

				StudentsDto dto = new StudentsDto();
				dto.setStudentId(itr.getStudentId());
				dto.setStudentName(itr.getStudentName());
				dto.setEmail(itr.getEmail());
				dto.setMobile(itr.getMobile());
				dto.setCreatedAt(itr.getCreatedAt());
				dto.setUpdatedAt(itr.getUpdatedAt());
				searchlist.add(dto);

			}

		}

		return searchlist;
	}

}
