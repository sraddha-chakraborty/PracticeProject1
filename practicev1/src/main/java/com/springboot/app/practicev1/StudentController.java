package com.springboot.app.practicev1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	Map<String, List<Student>> studentList = new HashMap<String, List<Student>>();
	
	//http://localhost:8080/studentInfo
	@GetMapping("/topStudentInfo")
	public Student topSudentInfo()
	{
		return(new Student("Attyuttam","Saha"));
	}
	
	//http://localhost:8080/studentInfoList
	@GetMapping("/setStudentInfo")
	public Map<String, List<Student>> setStudentInfo()
	{
		List<Student> studentsUnderID001 = new ArrayList<Student>();
		studentsUnderID001.add(new Student("Sraddha","Chakraborty"));
		studentsUnderID001.add(new Student("Boo","Boy"));
		studentsUnderID001.add(new Student ("Blinky","Saha"));
		
		List<Student> studentsUnderID002 = new ArrayList<Student>();
		studentsUnderID002.add(new Student("Sraddha","Saha"));
		studentsUnderID002.add(new Student("Babushka","Catto"));
		
		studentList.put("ID001", studentsUnderID001);
		studentList.put("ID002", studentsUnderID002);
		
		return studentList;
	}
	
	//http://localhost:8080/getStudentInfoFromList/{teacherId}?firstName={value}
		@GetMapping("/getStudentInfoFromList/{teacherId}")
		public Student getStudentInfoFromList(@PathVariable String teacherId, @RequestParam String firstName)
		{
			setStudentInfo();
			List<Student> studentsUnderTeacherId = studentList.get(teacherId);
			Student studentInfo = null;
			for (Student student : studentsUnderTeacherId)
			{
				if (student.getFirstName().equalsIgnoreCase(firstName))
				{
					studentInfo = student;
					break;
				}
			}
			return studentInfo;
		}
}
