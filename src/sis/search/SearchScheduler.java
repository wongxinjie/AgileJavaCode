/**
*@Title:SearchScheduler.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.search;

import java.util.*;

public class SearchScheduler {
	private ResultsListener listener;
	private Timer timer;
	
	public SearchScheduler(ResultsListener listener){
		this.listener = listener;
	}
	
	/*
	 * interval是Timer的时延，单位是毫秒。
	 */
	public void repeat(final Search search, long interval){
		timer = new Timer();
		TimerTask task = new TimerTask(){
			@Override
			public void run() {
				search.execute();
				listener.executed(search);
			}	
		};
		timer.scheduleAtFixedRate(task, 0, interval);
	}
	
	public void stop(){
		timer.cancel();
	}
}
