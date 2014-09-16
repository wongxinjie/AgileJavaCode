/**
*@Title:Performance.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

public class Performance {
	private int[] tests;
	
	public void setNumberOfTests(int numberOfTests){
		tests = new int[numberOfTests];
	}
	
	public void set(int testNumber, int score){
		tests[testNumber] = score;
	}
	
	public int get(int testNumber){
		return tests[testNumber];
	}
	
	public double average(){
		double total = 0.0;
		for(int score: tests){
			total += score;
		}
		return total/tests.length;
	}
	
}
