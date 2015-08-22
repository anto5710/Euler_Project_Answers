package P003;

/**
 * 재귀 호출 개선한 버전
 * @author anto5710
 *
 */
public class LPM_V2 {

	public static void main(String[] args) {
        // 2, 3, 5, 7 11 13 15 17
		long N = 600851475143L;
		// 짝수로 나눠지지 않게 전처리를 해줍니다. 
		while ( N == 2 ) {
			N /= 2;
		}
		
		// N은 절.대.로 짝수로 나뉘지 않음.
        System.out.println( "LPM(600851475143, 2) : " + LPM(N, 3));
	}

	private static int LPM(long N, int prime) {
		
		if(N==prime) {
			return prime;
		} else if ( N % prime == 0 ) {
			return LPM ( N/prime, prime); 
		} else {
			return LPM( N, prime + 2);
		}
	}

}
