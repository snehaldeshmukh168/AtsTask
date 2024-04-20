package com.atdevService.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atdevService.module.Student;
import com.atdevService.studentRepository.StudentRepository;
import com.atdevService.studentService.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Map<String, Object> saveStudentData(Student student) {
		Student studentData = null;
		Map<String, Object> result = new LinkedHashMap<>();
		if (student != null) {
			studentData = studentRepository.save(student);
			result.put("statusCode", "201");
			result.put("message", "Student Data Added");
			result.put("result", studentData);
		} else {
			result.put("statusCode", "404");
			result.put("message", "Student Data Not Added");
		}
		return result;
	}

	@Override
	public Map<String, Object> getStudentData() {
		List<Student> getData = studentRepository.findAll();
		Map<String, Object> result = new LinkedHashMap<>();
		if (getData != null) {
			result.put("statusCode", "200");
			result.put("message", "Student Data fetched");
			result.put("result", getData);
		} else {
			result.put("statusCode", "404");
			result.put("message", "Student Data Not Found");
		}
		return result;
	}

	@Override
	public Map<String, Object> updateStudentData(Student student) {
		Optional<Student> getId = studentRepository.findById(student.getId());

		Map<String, Object> result = new LinkedHashMap<>();
		if (getId.isPresent()) {
			Student studentData = getId.get();
			studentData.setStuId(student.getId());
			studentData.setStudName(student.getStudName());
			studentData.setStudAddress(student.getStudAddress());
			studentData.setStudMarks(student.getStudMarks());

			studentData = studentRepository.save(student);
			result.put("statusCode", "201");
			result.put("message", "Student Data Added");
			result.put("result", studentData);
		} else {
			result.put("statusCode", "404");
			result.put("message", "Student Id Not Found");
		}
		return result;
	}

	@Override
	public Map<String, Object> deleteStudentData(long id) {
		Optional<Student> getId = studentRepository.findById(id);

		Map<String, Object> result = new LinkedHashMap<>();
		if (getId.isPresent()) {
			studentRepository.deleteById(id);
			result.put("statusCode", "200");
			result.put("message", "Student Data Deleteed");
		} else {
			result.put("statusCode", "404");
			result.put("message", "Student Id Not Found");
		}
		return result;	}

}
