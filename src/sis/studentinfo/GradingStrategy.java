/**
*@Title:GradingStrategy.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

public interface GradingStrategy {
	public double getGradePointsFor(Student.Grade grade);
}
