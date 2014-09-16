/**
*@Title:Course.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;
import java.io.*;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String department;
	private String number;
	
	public Course(String department, String number){
		this.department = department;
		this.number = number;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public String getNumber(){
		return number;
	}
	
	/*
	 * 用来实现对象相等性的判断
	 */
	@Override
	public boolean equals(Object object){
		//传入的对象为空，显然不相等。
		if(object == null) return false;
		 /* 
		 * 在这里可能会有另外一种写法，就是写出if(!(object instanceof Course))
		 * 但这种做法是不提倡的，因为要判断的是两个对象是否属于同一个类，而并非是否
		 * 同属于一个父类。
		 */
		if(this.getClass() != object.getClass()) return false;
		Course that = (Course) object;
		return this.department.equals(that.department)&&
				this.number.equals(that.number);
	}
	
	/*
	 * 假如不实现这个函数，那么即使是两个课程的department和number一模一样
	 * 新建的对象也有不同的hashCode，即视为两个不同的对象。
	 */
	@Override
	public int hashCode(){
		final int hashMultiplier = 41;
		int result = 7;
		result = result * hashMultiplier + department.hashCode();
		result = result * hashMultiplier + number.hashCode();
		return result;
	}
}
