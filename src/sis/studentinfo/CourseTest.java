/**
*@Title:CourseTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {
	
	@Test
	public void testEquality(){
		Course courseA = new Course("NURS", "101");
		Course courseB = new Course("NURS", "101");
		Course courseC = new Course("ENGL", "201");
		assertEquals(courseA, courseB);
		assertTrue(courseA != courseC);
	}

}
