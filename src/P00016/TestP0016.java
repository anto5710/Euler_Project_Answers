package P00016;

import static org.junit.Assert.*;

import org.junit.Test;

import P0013.P0013Main;
/**
 * 렉이 걸리는 이유 - 반복문은 죄가 없음.
 * 
 * Thread 맥도널드에서 주문할때
 * 
 * 주문하는 사람 - ThreadA
 * 만드는 사람   - ThreadB
 * 
 * throughtput
 * 
 * 비동기 프로그래밍으로 여러개의 스레드를 동시에 돌립니다.
 * 
 * Thread Programming을 해야 합니다.
 * 
 *   while ( true ) {
 *     Task t = queue.getTask();
 *   }
 * @author anto5710
 *
 */
public class TestP0016 {

	@Test
	public void test() {
		String result = P0013Main.multipy("123", "89");
		assertEquals ( "10947", result);
		
		result = P0013Main.multipy("10000", "11");
		assertEquals ( "110000", result);
		
		// 2^10
		int a = 10;
		result = "1";
		for(int c = 0 ; c<a ; c++){
			result = P0013Main.multipy(result, "2");
		}
		assertEquals ( "1024", result);
		
	}

}
