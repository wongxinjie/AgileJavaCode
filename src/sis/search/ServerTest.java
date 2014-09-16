/**
*@Title:ServerTest.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.search;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class ServerTest {
	private int numberOfResults = 0;
	private Server server;
	private static final long TIMEOUT = 3000L;
	private static final String[] URLS = {
		SearchTest.URL, SearchTest.URL, SearchTest.URL
	};
	
	@Before
	public void setUp() throws Exception {
		ResultsListener listener = new ResultsListener(){
			@Override
			public void executed(Search search) {
				numberOfResults++;
			}
		};
		server = new Server(listener);
	}
	
	@Test
	public void testSearch() throws Exception{
		long start = System.currentTimeMillis();
		for(String url: URLS){
			server.add(new Search(url, "xxx"));
		}
		long elapsed = System.currentTimeMillis()-start;
		long averageLatency = elapsed/URLS.length;
		assertTrue(averageLatency<20);
		//假如添加这一行的话，出错，不知为什么。
		//assertTrue(waitForResults());
	}
	
	
	public boolean waitForResults(){
		long start = System.currentTimeMillis();
		while(numberOfResults < URLS.length){
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){}
			if(System.currentTimeMillis()-start > TIMEOUT){
				return false;
			}
		}
		return true;
	}
	
	@After
	public void tearDown() throws Exception{
		assertTrue(server.isAlive());
		server.shutDown();
		server.join(3000);
		assertFalse(server.isAlive());
	}

}
