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
	 * ����ʵ�ֶ�������Ե��ж�
	 */
	@Override
	public boolean equals(Object object){
		//����Ķ���Ϊ�գ���Ȼ����ȡ�
		if(object == null) return false;
		 /* 
		 * ��������ܻ�������һ��д��������д��if(!(object instanceof Course))
		 * �����������ǲ��ᳫ�ģ���ΪҪ�жϵ������������Ƿ�����ͬһ���࣬�������Ƿ�
		 * ͬ����һ�����ࡣ
		 */
		if(this.getClass() != object.getClass()) return false;
		Course that = (Course) object;
		return this.department.equals(that.department)&&
				this.number.equals(that.number);
	}
	
	/*
	 * ���粻ʵ�������������ô��ʹ�������γ̵�department��numberһģһ��
	 * �½��Ķ���Ҳ�в�ͬ��hashCode������Ϊ������ͬ�Ķ���
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
