/**
*@Title:HonorsGradingStrategy.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;


public class HonorsGradingStrategy extends BasicGradingStrategy {
	
	public double getGradePointsFor(Student.Grade grade){
		double points = super.basicGradePointsFor(grade);
		if( points > 0) points += 1.0;
		return points;
	}
	
}
