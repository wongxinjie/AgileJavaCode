/**
*@Title:PasswordGeneratorTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.util;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class PasswordGeneratorTest {


	@Test
	public void testGeneratePassword() {
		PasswordGenerator generator = new PasswordGenerator();
		generator.setRandom(new MockRandom('A'));
		assertEquals("ABCDEFGH", generator.generatePassword());
	}
	
	class MockRandom extends Random{
		private int i;
		MockRandom(char startCharValue){
			i = startCharValue - PasswordGenerator.LOW_END_PASSWORD_CHAR;
		}
		protected int next(int bits){
			return i++;
		}
	}
}
