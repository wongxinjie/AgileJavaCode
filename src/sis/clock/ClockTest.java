/**
*@Title:ClockTest.java
*@Description: 对Clock类的功能进行测试。
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.clock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ClockTest {
	private Clock clock;
	private Object monitor = new Object();
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testClock() throws Exception{
		final int seconds = 5;
		final List<Date> tics = new ArrayList<Date>();
		ClockListener listener = new ClockListener(){
			private int count = 0;
			@Override
			public void update(Date date) {
				tics.add(date);
				if(++count == seconds){
					synchronized(monitor){
						monitor.notifyAll();
					}
				}
			}	
		};
		clock = new Clock(listener);
		synchronized(monitor){
			monitor.wait();
		}
		clock.stop();
		verify(tics, seconds);
	}
	
	private void verify(List<Date> tics, int seconds){
		assertEquals(seconds, tics.size());
		for(int i=1; i < seconds; i++){
			assertEquals(1, getSecondsFromLast(tics, i));
		}
	}
	
	private long getSecondsFromLast(List<Date> tics, int i){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(tics.get(i));
		int now = calendar.get(Calendar.SECOND);
		calendar.setTime(tics.get(i-1));
		int then = calendar.get(Calendar.SECOND);
		if(now == 0)
			now = 60;
		return now - then;
	}
}
