/**
*@Title:Clock.java
*@Description:
*@coder: Xinjie Wong
*@date: 2014/09/15
*/
package sis.clock;

import java.util.*;

/*
*实现多线程的一个方法之一就是继承Runnable接口
*并实现Runable接口的run方法。
*/
public class Clock implements Runnable {
	private ClockListener listener;
	private boolean run = true;
	
	public Clock(ClockListener listener){
		this.listener = listener;
		new Thread(this).start();
	}
	
	public void stop(){
		run = false;
	}

	
	@Override
	public void run(){
		long lastTime = System.currentTimeMillis();
		while(run){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
			long now = System.currentTimeMillis();
			if((now/1000)-(lastTime/1000)>=1){
				listener.update(new Date());
				lastTime = now;
			}
		}
	}
}
