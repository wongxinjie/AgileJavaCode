/**
*@Title:DateUtilTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DateUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateDate() {
		Date date = DateUtil.createDate(2005,  1, 1);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		assertEquals(2005, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DATE));
	}

}
