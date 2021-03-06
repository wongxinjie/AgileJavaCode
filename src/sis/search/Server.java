/**
*@Title:Server.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.search;

import java.util.*;

public class Server extends Thread {
	private List<Search> queue = new LinkedList<Search>();
	private ResultsListener listener;
	
	public Server(ResultsListener listener){
		this.listener = listener;
		start();
	}
	
	public void run(){
		while(true){
			if(!queue.isEmpty()){
				execute(queue.remove(0));
			}
			Thread.yield();
		}
	}
	
	public void shutDown() throws Exception{
		this.interrupt();
	}
	
	public void add(Search search){
		queue.add(search);
	}
	
	private void execute(Search search){
		search.execute();
		listener.executed(search);
	}
}
