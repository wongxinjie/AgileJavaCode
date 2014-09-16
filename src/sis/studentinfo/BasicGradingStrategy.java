/**
*@Title:BasicGradingStrategy.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

abstract public class BasicGradingStrategy implements GradingStrategy{
	abstract public double getGradePointsFor(Student.Grade grade);
	
	public double basicGradePointsFor(Student.Grade grade){
		return grade.getPoints();
	}
	
}
