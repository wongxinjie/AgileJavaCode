/**
*@Title:CourseSession.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import java.util.Date;


public class CourseSession extends Session{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int count;
	
	protected CourseSession(Course course, Date startDate){
		super(course, startDate);
		CourseSession.incrementCount();
	}
	
	/*
	 * 工厂方法的应用。
	 */
	public static CourseSession create(Course course, Date startDate){
		return new CourseSession(course, startDate);
	}
	
	public static void resetCount(){
		count = 0;
	}
	
	public static int getCount(){
		return count;
	}
	
	private static void incrementCount(){
		++count;
	}
	
	protected int getSessionLength(){
		int sessionLength = 16;
		return sessionLength;
	}
}
