/**
*@Title: CourseReportTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.report;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testReport(){
		final Date date = new Date();
		CourseReport report = new CourseReport();
		report.add(CourseSession.create(new Course("ENGL", "101"), date));
		report.add(CourseSession.create(new Course("CZEC", "200"), date));
		report.add(CourseSession.create(new Course("ITAL", "401"), date));
		final String exceptedText = "CZEC 200"+NEWLINE+"ENGL 101"+NEWLINE+
				"ITAL 401"+NEWLINE;
		assertEquals(exceptedText, report.text());
	}
	
	@Test
	public void tesSortStringsInPlace(){
		List<String> list = new ArrayList<String>();
		list.add("Heller");
		list.add("Kafak");
		list.add("Camus");
		list.add("Boyle");
		
		/*
		 * 就地排序的例子
		 * Java.util.Collecions中可以对列表进行排序。
		 */
		Collections.sort(list);
		assertEquals("Boyle", list.get(0));
		assertEquals("Camus", list.get(1));
		assertEquals("Heller", list.get(2));
		assertEquals("Kafak", list.get(3));
	}
	
	@Test
	public void testSortStringInNewList(){
		List<String> list = new ArrayList<String>();
		list.add("Heller");
		list.add("Kafak");
		list.add("Camus");
		list.add("Boyle");
		
		/*
		 * 有时候要求是不能改变原列表的顺序，那么新建一条列表，
		 * 然后对新建的列表进行排序。
		 */
		List<String> sortedList = new ArrayList<String>(list);
		Collections.sort(sortedList);
		assertEquals("Boyle", sortedList.get(0));
		assertEquals("Camus", sortedList.get(1));
		assertEquals("Heller", sortedList.get(2));
		assertEquals("Kafak", sortedList.get(3));
		
		assertEquals("Heller", list.get(0));
		assertEquals("Kafak", list.get(1));
		assertEquals("Camus", list.get(2));
		assertEquals("Boyle", list.get(3));
	}
	
}
