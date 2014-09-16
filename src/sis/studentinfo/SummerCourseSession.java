/**
*@Title:SummerCourseSession.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;
import java.util.*;

public class SummerCourseSession extends Session {
	
	public static SummerCourseSession create(Course course, Date startDate){
		return new SummerCourseSession(course, startDate);
	}
	
	private SummerCourseSession(Course course, Date startDate){
		super(course, startDate);
	}
	
	protected int getSessionLength(){
		int sessionLength = 8;
		return sessionLength;
	}
	
	public Date getEndDate(){
		final int sessionLength = 8;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		int numberOfDays = sessionLength*daysInWeek-daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		Date endDate = calendar.getTime();
		return endDate;
	}
	
}
