/**
*@Title:StudentDirectory.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import java.util.*;
import java.io.*;
import sis.db.*;

public class StudentDirectory {
	//private Map<String, Student> students;
	private static final String DIR_BASENAME = "studentDir";
	private DataFile db;
	
	public StudentDirectory() throws IOException {
		//students = new HashMap<String, Student>();
		db = DataFile.open(DIR_BASENAME);
	}
	
	public void add(Student student) throws IOException{
		//students.put(student.getId(), student);
		db.add(student.getId(), student);
	}
	
	public Student findById(String id)throws IOException{
		return (Student)db.findById(id);
	}
	
	public void close() throws IOException{
		db.close();
	}
	
	public void remove(){
		db.deleteFiles();
	}
}
