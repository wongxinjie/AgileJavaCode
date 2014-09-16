/**
*@Title:SearchTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.search;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

public class SearchTest {
	public static final String URL="http://www.langrsoft.com";
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCreate() throws IOException{
		Search search = new Search(URL, "x");
		assertEquals(URL, search.getUrl());
		assertEquals("x", search.getText());
	}
	
	@Test
	public void testPositiveSearch() throws IOException{
		Search search = new Search(URL, "Jeff Langr");
		search.execute();
		assertTrue(search.matches()>= 1);
		assertFalse(search.errored());
	}
	
	@Test
	public void testNegativeSearch() throws IOException{
		final String unlikelyText = "mama cass elliott";
		Search search = new Search(URL, unlikelyText);
		search.execute();
		assertEquals(0, search.matches());
		assertFalse(search.errored());
	}
	
	//This didn't work, and I don't know why!
	@Test
	public void testErroredSearch() throws IOException{
		final String badUrl = URL+"/z2468.html";
		Search search = new Search(badUrl, "whatever");
		search.execute();
		assertTrue(search.errored());
		assertEquals(FileNotFoundException.class, search.getError().getClass());
	}

}
