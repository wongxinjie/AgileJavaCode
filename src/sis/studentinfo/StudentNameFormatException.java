/**
*@Title:StudentNameFormatException.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

public class StudentNameFormatException extends IllegalArgumentException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNameFormatException(String message){
		super(message);
	}
}
