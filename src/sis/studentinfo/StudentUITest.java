/**
*@Title:StudentUITest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class StudentUITest {
	private static final String name= "Leo Xerces Schmoo";
	
	@Test
	public void testCreateStudent() throws IOException {
		StringBuilder expectedOutput = new StringBuilder();
		StringBuilder input = new StringBuilder();
		
		setup(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();
		
		InputStream inputStream =new ByteArrayInputStream(buffer);
		//BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		OutputStream outputStream = new ByteArrayOutputStream();
		//BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		
		//StudentUI ui = new StudentUI(reader, writer);
		InputStream consoleIn = System.in;
		PrintStream consoleOut = System.out;
		System.setIn(inputStream);
		System.setOut(new PrintStream(outputStream));
		try{
			StudentUI ui = new StudentUI();
			ui.run();
		}finally{
			System.setIn(consoleIn);
			System.setOut(consoleOut);
		}
		
		
		assertEquals(expectedOutput.toString(), outputStream.toString());
	}
	
	private String line(String input){
		return String.format("%s%n", input);
	}
	
	private void setup(StringBuilder expectedOutput, StringBuilder input){
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.ADD_OPTION));
		
		expectedOutput.append(StudentUI.NAME_PROMPT);
		input.append(line(name));
		
		expectedOutput.append(line(StudentUI.ADDED_MESSAGE));
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.QUIT_OPTION));
	}
	/*
	private void assertStudents(List<Student> students){
		assertEquals(1, students.size());
		Student student = students.get(0);
		assertEquals(name, student.getName());
	}*/
}
