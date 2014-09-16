/**
*@Title:SessionTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;
import java.net.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest {
	private Session session;
	private Date startDate;
	public static final int CREDITS =3;
	
	@Before
	public void setUp() throws Exception {
		startDate = createDate(2003, 1, 6);
		session = createSession(new Course("ENGL", "101"), startDate);
		session.setNumberOfCredits(CREDITS);
	}
	
	abstract protected Session createSession(Course course, Date startDate);
	
	@Test
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	
	@Test
	public void testEnrollStudents(){
		Student[] students = new Student[]{new Student("Cain Divoe"), new Student("Coralee DeVaugh")};
		
		session.enroll(students[0]);
		assertEquals(CREDITS, students[0].getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(students[0], session.get(0));
		
		session.enroll(students[1]);
		assertEquals(CREDITS, students[1].getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(students[1], session.get(1));
	}
	
	@Test
	public void testSessionUrl() throws SessionException{
		final String url = "http://course.langrsoft.com/cmcs300";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());
	}
	
	@Test
	public void testInvalidSessionUrl(){
		final String urlString = "httsp://course.langrsoft.com/cmcs300";
		try{
			session.setUrl(urlString);
			fail("excepted exception due to invalid protocal in URL");
		}catch(SessionException e){
			Throwable cause = e.getCause();
			assertEquals(MalformedURLException.class, cause.getClass());
		}
	}

}
