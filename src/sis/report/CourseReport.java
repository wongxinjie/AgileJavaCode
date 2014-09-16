/**
*@Title:CourseReport.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
	private List<CourseSession> sessions;
	
	public CourseReport(){
		sessions = new ArrayList<CourseSession>();
	}
	
	public void add(CourseSession session){
		sessions.add(session);
	}
	
	public String text(){
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for(CourseSession session: sessions){
			builder.append(session.getDepartment()+" "+session.getNumber()+NEWLINE);
		}
		return builder.toString();
	}
}
