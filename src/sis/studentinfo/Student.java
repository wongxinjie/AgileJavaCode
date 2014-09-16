/**
*@Title:Student.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import java.util.List;
import java.util.ArrayList;

public class Student {
	
	/*
	 * 增强版的枚举变量！
	 */
	static enum Grade {
		A(4.0), B(3.0), C(2.0), D(1.0), E(0), F(0);
		private double points;
		
		Grade(double points){
			this.points = points;
		}
		
		double getPoints(){
			return points;
		}
	}
	
	/*
	 *枚举变量的又一用法，反正我是看不大懂。
	 */
	public enum Flag{
		ON_CAMPUS(1), TAX_EXEMPT(2), MIMOR(4), TROUBLEMAKER(8);
		private int mask;
		
		Flag(int mask){
			this.mask = mask;
		}
	}
	
	private int settings = 0x0;
	
	public void set(Flag...flags){
		for(Flag flag: flags){
			settings |= flag.mask;
		}
	}
	
	public void unset(Flag...flags){
		for(Flag flag: flags){
			settings &= ~flag.mask;
		}
	}
	
	public boolean isOn(Flag flag){
		return(settings & flag.mask) == flag.mask;
	}
	
	public boolean isOff(Flag flag){
		return !isOn(flag);
	}
	
	/*
	 * 
	 */
	
	private static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	
	private String name;
	private int credits;
	private List<Grade> grades;
	private String state;
	private String firstName;
	private String middleName;
	private String lastName;
	private String id;
	private List<Integer> charges;
	GradingStrategy gradingStrategy;
	
	public static final String IN_STATE="CO";
	public Student(String fullName){
		this.name = fullName;
		this.credits =0;
		this.grades = new ArrayList<Grade>();
		this.charges = new ArrayList<Integer>();
		this.state ="";
		this.firstName ="";
		this.middleName ="";
		this.id = "";
		this.gradingStrategy = new RegularGradingStrategy();
		List<String> nameParts = split(name);
		final int maxNumberOfNameParts = 3;
		if( nameParts.size() > maxNumberOfNameParts){
			String message = "Student name '"+ fullName +"' contains more than "+
		maxNumberOfNameParts+" parts";
			throw new StudentNameFormatException(message);
		}	
		setName(nameParts);
	}
	
	public  String getName(){
		return this.name;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	
	private void setName(List<String> nameParts){
		this.lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if(nameParts.isEmpty()){
			this.firstName = name;
		}else{
			this.middleName = name;
			this.firstName = removeLast(nameParts);
		}
	}
	
	private String removeLast(List<String> list){
		if (list.isEmpty()) return "";
		return list.remove(list.size()-1);
	}
	
	private List<String> split(String name){
		List<String> result = new ArrayList<String>();
		
		String[] nameStrings = name.split("\\s+");
		for(String singleName: nameStrings){
			result.add(singleName);
		}
		return result;
	}
	public void setGradingStrategy(GradingStrategy gradingStrategy){
		this.gradingStrategy = gradingStrategy;
	}
	
	public void addCharge(int charge){
		charges.add(charge);
	}
	
	public int totalCharges(){
		int total = 0;
		for(int charge: charges){
			total += charge;
		}
		return total;
	}
	
	public boolean isFullTime(){
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}
	
	public int getCredits(){
		return credits;
	}
	
	public void addCredits(int credit){
		credits += credit;
	}
	
	public void setState(String state){
		this.state = state.toUpperCase();
	}
	
	public boolean isInState(){
		return state.equals(IN_STATE);
	}
	
	public void addGrade(Grade grade){
		grades.add(grade);
	}
	
	public double getGpa(){
		double total = 0.0;
		if(grades.isEmpty()) return total;
		for(Grade grade: grades){
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total/grades.size();
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getMiddleName(){
		return middleName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public static Student findByLastName(String lastName){
		return new Student(lastName);
	}
}
