/**
*@Title:ReportCard.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import java.util.*;

public class ReportCard {
	static final String A_MESSAGE = "Eccellent";
	static final String B_MESSAGE = "Very good";
	static final String C_MESSAGE = "Just OK";
	static final String D_MESSAGE = "You are not trying";
	static final String O_MESSAGE = "Loser";
	
	private Map<Student.Grade, String> messages = null;
	
	public String getMesaage(Student.Grade grade){
		return getMessages().get(grade);
	}
	
	/*
	 * 这里使用了延时初始化
	 */
	public Map<Student.Grade, String> getMessages(){
		if(messages == null){
			loadMessages();
		}
		return messages;
	}
	
	private void loadMessages(){
		//EnumMap 的用法
		messages = new EnumMap<Student.Grade, String>(Student.Grade.class);
		messages.put(Student.Grade.A, A_MESSAGE);
		messages.put(Student.Grade.B, B_MESSAGE);
		messages.put(Student.Grade.C, C_MESSAGE);
		messages.put(Student.Grade.D, D_MESSAGE);
		messages.put(Student.Grade.E, O_MESSAGE);
		messages.put(Student.Grade.F, O_MESSAGE);
	}
}
