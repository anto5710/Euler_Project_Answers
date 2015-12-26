package P0025;

public class StopwatchTester {

	public static void main(String[] args) {
		StopWatch2 watch = new StopWatch2();
		watch.startTimer();; // 시작시킴
		
			//
			for ( int i = 1 ; i <= 10 ; i++) {
				try {
					Thread.sleep(1000);
					if ( i % 2 == 1 ) {
						watch.pause();
						System.out.println("stopped");
					} else {
						watch.restart();
						System.out.println("restarted");
					}
					System.out.println("tick"); // 미세한 시간이 더 추가됩니다.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		long elapsed = watch.stopTimer();
		
		System.out.println("경과 시간: " + elapsed); // 5000과 비슷한 값이 나와야 합니다.
		
	}
}
