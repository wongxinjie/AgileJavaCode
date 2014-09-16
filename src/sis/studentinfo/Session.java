/**
*@Title:Session.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import java.util.*;
import java.net.*;
import java.io.*;

abstract public class Session implements Comparable<Session>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Course course;
	private transient List<Student> students;
	private Date startDate;
	private int numberOfCredits;
	private URL url;
	
	
	protected Session(Course course, Date startDate){
		this.course = course;
		this.students = new ArrayList<Student>();
		this.startDate = startDate;
	}
	
	/*
	 * 重载compareTo函数实现CourseSession比较
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Session that){
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if( compare != 0)
			return compare;
		return this.getNumber().compareTo(that.getNumber());
	}
	
	void setNumberOfCredits(int numberOfCredits){
		this.numberOfCredits = numberOfCredits;
	}
	
	int getNumberOfCredits(){
		return numberOfCredits;
	}
	
	
	public String getDepartment(){
		return course.getDepartment();
	}
	
	public String getNumber(){
		return course.getNumber();
	}
	
	public int getNumberOfStudents(){
		return students.size();
	}
	
	public void enroll(Student student){
		student.addCredits(numberOfCredits);
		students.add(student);
	}
	
	public Student get(int index){
		return students.get(index);
	}
	
	protected Date getStartDate(){
		return startDate;
	}
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	public void setUrl(String urlString) throws SessionException{
		try{
			this.url = new URL(urlString);
		}catch(MalformedURLException exceptedException){
			log(exceptedException);
			throw new SessionException(exceptedException);
		}
	}
	
	private void log(Exception e){
		//leave for empty.
		//this  is for log action.
	}
	
	public URL getUrl(){
		return url;
	}
	
	abstract protected int getSessionLength();
	//abstract protected Session createSession(String department, String number, Date date);
	
	public Date getEndDate(){
		final int sessionLength = getSessionLength();
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		int numberOfDays = sessionLength*daysInWeek-daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		Date endDate = calendar.getTime();
		return endDate;
	}
	
	private void writeObject(ObjectOutputStream output)throws IOException{
		output.defaultWriteObject();
		output.writeInt(students.size());
		for(Student student: students){
			output.writeObject(student.getName());
		}
	}
	
	private void readObject(ObjectInputStream input) throws Exception{
		input.defaultReadObject();
		students = new ArrayList<Student>();
		int size = input.readInt();
		for(int i=0; i < size; i++){
			String lastName = (String)input.readObject();
			students.add(Student.findByLastName(lastName));
		}
	}
}
