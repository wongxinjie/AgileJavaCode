/**
*@Title:SummerCourseSessionTest.java
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

public class SummerCourseSessionTest extends SessionTest{

	@Before
	public void setUp() throws Exception {
		//之前通不过的测试，添加这一行之后就好了，见鬼。
		super.setUp();
	}

	@Test
	public void testEndDate() {
		Date startDate = createDate(2003, 6, 9);
		Session session = createSession(new Course("ENGL", "200"), startDate);
		Date eightWeeksOut = createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}
	
	protected Session createSession(Course course, Date startDate){
		return SummerCourseSession.create(course, startDate);
	}

}
