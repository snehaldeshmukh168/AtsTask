package com.atdevService.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atdevService.module.Student;
import com.atdevService.studentService.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addData")
	private ResponseEntity<Map<String, Object>> addStudentData(@RequestBody Student student) {
		Map<String, Object> studentData = null;

		studentData = studentService.saveStudentData(student);

		if (studentData != null && studentData.get("statusCode").equals("201")) {
			return new ResponseEntity<Map<String, Object>>(studentData, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Map<String, Object>>(studentData, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getData")
	private ResponseEntity<Map<String, Object>> getStudentData() {
		Map<String, Object> getStudentData = null;
		getStudentData = studentService.getStudentData();
		if (getStudentData != null && getStudentData.get("statusCode").equals("200")) {
			return new ResponseEntity<Map<String, Object>>(getStudentData, HttpStatus.OK);
		} else {
			return new ResponseEntity<Map<String, Object>>(getStudentData, HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/updateData")
	private ResponseEntity<Map<String, Object>> updateStudentData(@RequestBody Student student) {
		Map<String, Object> studentData = null;

		studentData = studentService.updateStudentData(student);

		if (studentData != null && studentData.get("statusCode").equals("201")) {
			return new ResponseEntity<Map<String, Object>>(studentData, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Map<String, Object>>(studentData, HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteData/{id}")
	private ResponseEntity<Map<String, Object>> deletStudentData(@PathVariable long id) {
		Map<String, Object> studentData = null;

		studentData = studentService.deleteStudentData(id);

		if (studentData != null && studentData.get("statusCode").equals("200")) {
			return new ResponseEntity<Map<String, Object>>(studentData, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Map<String, Object>>(studentData, HttpStatus.NOT_FOUND);
		}
	}
}
