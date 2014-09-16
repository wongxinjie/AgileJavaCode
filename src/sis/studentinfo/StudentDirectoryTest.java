/**
*@Title:StudentDirectoryTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.*;
import java.io.*;

public class StudentDirectoryTest {
	
	private StudentDirectory dir;
	
	@Before
	public void setUp() throws Exception {
		dir = new StudentDirectory();
	}
	
	@After
	public void tearDown() throws IOException{
		dir.close();
		dir.remove();
	}
	
	/*
	public void testStoreAndRetrieve() throws IOException{
		final int numberOfStudents = 10;
		for(int i=0; i < numberOfStudents; i++){
			addStudent(dir, i);
		}
		for(int i=0; i < numberOfStudents; i++){
			verifyStudentLookUp(dir, i);
		}
	}
	*/
	
	@Test
	public void testRandomAccess() throws IOException{
		final int numberOfStudents = 10;
		for(int i=0; i < numberOfStudents; i++){
			addStudent(dir, i);
		}
		dir.close();
		dir = new StudentDirectory();
		for(int i=0; i < numberOfStudents; i++){
			verifyStudentLookUp(dir, i);
		}
	}
	
	private void addStudent(StudentDirectory directory, int i) 
			throws IOException{
		String id = "Wong"+i;
		Student student = new Student(id);
		student.setId(id);
		student.addCredits(i);
		directory.add(student);
	}
	
	private void verifyStudentLookUp(StudentDirectory directory, int i) 
			throws IOException{
		String id = "Wong"+i;
		Student student = directory.findById(id);
		assertEquals(id,student.getLastName());
		assertEquals(id, student.getId());
		assertEquals(i, student.getCredits());
		
	}
	
	@Test
	public void testHashCode(){
		Course courseA = new Course("NURS", "201");
		Course courseB = new Course("NURS", "201");
		
		Map<Course, String> map = new HashMap<Course, String>();
		map.put(courseA, "Wong");
		assertTrue(map.containsKey(courseA));
		
		System.out.println(courseA.hashCode());
		System.out.println(courseB.hashCode());
		assertEquals(courseA.hashCode(), courseB.hashCode());
		assertEquals(courseA.hashCode(), courseA.hashCode());
		
	}
}
