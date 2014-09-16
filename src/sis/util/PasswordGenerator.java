/**
*@Title:PasswordGenerator.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.util;
import java.util.*;

public class PasswordGenerator {
	private String password;
	private static final int PASSWORD_LENGTH = 8;
	private Random random;
	
	static final char LOW_END_PASSWORD_CHAR = 48;
	static final char HIGH_END_PASSWORD_CHAR = 122;
	
	public PasswordGenerator(){
		this.random = new Random();
	}
	
	void setRandom(Random random){
		this.random = random;
	}

	public String generatePassword(){
		StringBuilder buffer = new StringBuilder();
		for(int i=0; i < PASSWORD_LENGTH; i++){
			buffer.append(getRandomChar());
		}
		return buffer.toString();
	}
	
	private char getRandomChar(){
		final char max = HIGH_END_PASSWORD_CHAR - LOW_END_PASSWORD_CHAR;
		return (char)(random.nextInt(max)+LOW_END_PASSWORD_CHAR);
	}
	
	public String getPassword(){
		return password;
	}
	
}
