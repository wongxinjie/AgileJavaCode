/**
*@Title:ScorerTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScorerTest {

	/*@Before
	public void setUp() throws Exception {
	}
	*/

	@Test
	public void testBadScoreEntered() {
		Scorer scorer = new Scorer();
		try{
			scorer.score("abdd");
			fail("expected NumberFormatException on bad input");
		}catch(NumberFormatException sussess){
			
		}
		
	}

}
