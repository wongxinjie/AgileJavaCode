/**
*@Title:RegularGradingStrategy.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;


public class RegularGradingStrategy extends BasicGradingStrategy{
	@Override
	public double getGradePointsFor(Student.Grade grade){
		return basicGradePointsFor(grade);
	}
}
