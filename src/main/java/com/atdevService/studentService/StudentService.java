package com.atdevService.studentService;

import java.util.List;
import java.util.Map;

import com.atdevService.module.Student;

public interface StudentService {

	Map<String, Object> saveStudentData(Student student);

	Map<String, Object> getStudentData();

	Map<String, Object> updateStudentData(Student student);

	Map<String, Object> deleteStudentData(long id);

}
