/**
*@Title:RosterReporterTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.report;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import java.io.*;
import sis.studentinfo.*;

public class RosterReporterTest {
	private Session session;
	
	@Before
	public void setUp() throws Exception {
		session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}

	@Test
	public void testRosterReport() throws IOException{
		Writer writer = new StringWriter();
		new RosterReporter(session).writeReport(writer);
		assertReportContents(writer.toString());
	}
	
	private void assertReportContents(String rosterReport){
		String exceptedRosterReport = String.format(RosterReporter.ROSTER_REPORT_HEADER+
				"A%n"+
				"B%n"+
				RosterReporter.ROSTER_REPORT_FOOTER, 2);
		assertEquals(exceptedRosterReport, rosterReport);
	}
	
	@Test
	public void testFileReport() throws IOException{
		final String filename = "student.txt";
		try{
			delete(filename);
			new RosterReporter(session).writeReport(filename);
			
			StringBuilder buffer = new StringBuilder();
			String line;
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while((line = reader.readLine())!= null){
				buffer.append(String.format(line+"%n"));
			}
			reader.close();
			assertReportContents(buffer.toString());
		}finally{
			delete(filename);
		}
		
	}
	
	private void delete(String filename){
		File file = new File(filename);
		if(file.exists()){
			assertTrue("Unabel to delete"+filename, file.delete());
		}
	}
}

