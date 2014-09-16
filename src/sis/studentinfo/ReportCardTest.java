/**
*@Title:ReportCardTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ReportCardTest {
	private ReportCard card;
	
	@Before
	public void setUp() throws Exception {
		card = new ReportCard();
	}

	@Test
	public void testKeys() {
		Set<Student.Grade> exceptedGrades = EnumSet.allOf(Student.Grade.class);
		Set<Student.Grade> grades = EnumSet.noneOf(Student.Grade.class);
		
		for(Student.Grade grade: card.getMessages().keySet()){
			grades.add(grade);
		}
		assertEquals(exceptedGrades, grades);
	}

}
