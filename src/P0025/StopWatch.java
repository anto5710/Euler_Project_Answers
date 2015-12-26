package P0025;



/**
 * start : 
 * stop : 
 * 
 * "상태"
 * 
 * 클래스는 상태를 가집니다.
 * 
 * @author anto5710
 *
 */

import P0025.Time;
public class StopWatch {
	private  Time time = new Time();
	private  State state = State.WAITING;
	private timer timer ;
		
	

	/**
	 * 스탑워치를 작동시킵니다.
	 */
	public void startTimer() {
		if(state!=State.WAITING&&state!=State.STOPPED){
			return;
		}
		timer = new timer();
		time = new Time();
		state = State.RUNNING;
	}
	
	/**
	 * 스탑워치를 중지시키고, 현재까지 경과한 시간을 밀리세컨드 단위로 반환합니다.
	 * @return
	 */
	public Time stopTimer() {
		if(state!=State.RUNNING&&state!=State.PAUSED){
			return null;
		}
		Time result = this.time;
		state = State.STOPPED;
		
		return result;
	}

	/**
	 * 스탑 워치 일시 중지시킵니다.
	 */
	public void pause() {
		if(state!=State.RUNNING){
			return;
		}
		this.state=State.PAUSED;
	}

	/**
	 * 스탑 워치를 재시작합니다.
	 */
	public void restart() {
		if(state!=State.PAUSED){
			return;
		}
		this.state = State.RUNNING;
	}
	
	
	
	
class timer extends Thread{
	
	public timer(){
		this.start();
	}
	@Override
	public void run() {
		while (state == P0025.StopWatch.State.RUNNING) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			time.add(0, 0,0,10);
		}
	}
}

public enum State{
	PAUSED , RUNNING , STOPPED , WAITING
}
}

