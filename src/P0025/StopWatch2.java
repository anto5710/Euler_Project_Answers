package P0025;


public class StopWatch2 {

	public enum State{
		INIT, PAUSED , RUNNING , STOPPED 
	}
	/**
	 * 시작 시
	 */
	private long startTime = -1 ;
	
	/**
	 * 시간 누적하는 변수
	 */
	private long totalTime  =  0 ;
	
	private State state ;
	/**
	 * 스탑워치를 작동시킵니다.
	 */
	public StopWatch2() {
		state = State.INIT;
	}
	
	public void reset() {
		totalTime = 0;
		startTime = -1;
		state =  State.INIT;
	}
	public void startTimer() {
		if(state!=State.INIT&&state!=State.STOPPED){
			return;
		}
		startTime = System.currentTimeMillis();
		totalTime = 0;
		state =  State.RUNNING;
	}
	
	/**
	 * 스탑워치를 중지시키고, 현재까지 경과한 시간을 밀리세컨드 단위로 반환합니다.
	 * @return
	 */
	public long stopTimer() {
		// running, pause
//		if ( state == State.STOPPED ) {
//			return totalTime;
//		}
		if ( state == State.RUNNING) {
			totalTime += ( System.currentTimeMillis() - startTime);			
		}
		state = State.STOPPED;
		return totalTime;
	}

	/**
	 * 스탑 워치 일시 중지시킵니다.
	 */
	public void pause() {
		if(state == State.RUNNING){
			totalTime += ( System.currentTimeMillis() - startTime);
			state = State.PAUSED;
		}
	}

	/**
	 * 스탑 워치를 재시작합니다.
	 */
	public void restart() {
		if(state == State.PAUSED){
			startTime = System.currentTimeMillis();
			state = State.RUNNING;
		} else {
			// running, stop
//			throw new RuntimeException()
		}
	}
}
