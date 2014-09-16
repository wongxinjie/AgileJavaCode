/**
*@Title:CourseCatalogTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class CourseCatalogTest {
	private CourseCatalog catalog;
	private Session sessionA;
	private Session sessionB;
	private Course courseA;
	private Course courseB;
	
	@Before
	public void setUp() throws Exception {
		catalog = new CourseCatalog();
		courseA = new Course("A", "1");
		courseB = new Course("A", "1");
		
		sessionA = CourseSession.create(courseA, DateUtil.createDate(2005, 1, 15));
		sessionA.setNumberOfCredits(3);
		
		sessionB = CourseSession.create(courseB, DateUtil.createDate(2005,  1,  17));
		sessionB.setNumberOfCredits(5);
		sessionB.enroll(new Student("Wong"));
		
		catalog.add(sessionA);
		catalog.add(sessionB);
	}

	@Test
	public void testStoreAndLoad() throws IOException, ClassNotFoundException{
		final String filename = "course_catalog.txt";
		catalog.store(filename);
		catalog.clearAll();
		assertEquals(0, catalog.getSessions().size());
		
		catalog.load(filename);
		List<Session> sessions = catalog.getSessions();
		assertEquals(2, sessions.size());
		
		assertSession(sessionA, sessions.get(0));
		assertSession(sessionB, sessions.get(1));
		
		//Session session = sessions.get(0);
		//assertSession(sessionB, session);
		//Student student = session.getAllStudents().get(0);
		//assertEquals("Wong", student.getLastName());
	}
	
	private void assertSession(Session expected, Session retrieved){
		assertNotSame(expected, retrieved);
		assertEquals(expected.getNumberOfCredits(), retrieved.getNumberOfCredits());
		assertEquals(expected.getStartDate(), retrieved.getStartDate());
		assertEquals(expected.getDepartment(), retrieved.getDepartment());
		assertEquals(expected.getNumber(), retrieved.getNumber());
	}

}
