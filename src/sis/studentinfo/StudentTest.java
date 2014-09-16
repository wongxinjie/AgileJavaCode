/**
*@Title:StudentTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	
	static double GRADE_TOLERANCE = 0.05;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCreate(){
		final String firstStudentName = "Jane Doe";
		Student student = new Student(firstStudentName);
		assertEquals(firstStudentName, student.getName());	
	}
	
	@Test
	public void testCalculateGpa(){
		Student student = new Student("A");
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 4.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student, 3.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student, 3.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student, 2.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student,2.0);
		
	}
	
	/*
	 * 浮点数的计算，可以在assertEquals指定可以忍受的精度损失
	 * 如在本函数中的GRADE_TOLERANCE
	 */
	
	@Test
	public void testCaluculateHonorsStudentGpa(){
		assertGpa(createHonorsStudent(), 0.0);
		assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
		assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
		assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
		assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
		assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
	}
	
	private Student createHonorsStudent(Student.Grade grade){
		Student student = createHonorsStudent();
		student.addGrade(grade);
		return student;
	}
	
	private Student createHonorsStudent(){
		Student student = new Student("A");
		student.setGradingStrategy(new HonorsGradingStrategy());
		return student;
	}
	
	private void assertGpa(Student student, double exceptedGpa){
		assertEquals(exceptedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
	
	
	@Test
	public void testBadlyFormattedName(){
		try{
			new Student("a b c d");
		}catch(StudentNameFormatException e){
			System.out.print(e.getMessage());
		}
	}
}
