/**
*@Title:CourseSessionTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest{
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testCourseDates(){
		Date startDate = createDate(2003, 1, 6);
		//Session session = createSession(new Course("ENGL", "200"), startDate);
		Session session =createSession(createCourse(), startDate);
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	@Test 
	public void testCount(){
		CourseSession.resetCount();
		createSession(createCourse(), new Date());
		assertEquals(1, CourseSession.getCount());
	}
	
	protected Session createSession(Course course, Date data){
		return CourseSession.create(course, data);
	}
	
	protected Course createCourse(){
		return new Course("ENGL", "101");
	}
	
}
