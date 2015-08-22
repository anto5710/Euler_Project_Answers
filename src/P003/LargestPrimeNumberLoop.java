package P003;

public class LargestPrimeNumberLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(LPM(42)); // 3

	}

	private static int LPM(int N) {
		int prime = 2;
		while(N!=prime) {
			
			 if(N%prime!=0) {
				 while(N%prime!=0) {
					 prime++;
				 }
			 }
			 if(N==prime){
				 break;
			 }
			 N=N/prime;
		}
		return prime;
	}
	
	/**
	 * 간결한 버전
	 * @param N
	 * @return
	 */
	private static int LPM2(int N) {
		int prime = 2;
		while( N > 1 ) {
			
			while(N%prime!=0) {
				prime++;
			}
			N=N/prime;
		}
		return prime;
	}

	private static int LPM3(int N) {
		int prime = 2;
		while( N > 1 ) {
			
			if ( N % prime!=0) {
				prime++;
			} else {
				N=N/prime;
			}
		}
		return prime;
	}
}
