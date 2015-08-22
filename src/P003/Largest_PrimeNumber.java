package P003;

public class Largest_PrimeNumber {
	public static void main(String[] args) {
         // 2, 3, 5, 7 11 13 15 17 
         System.out.println( "LPM(600851475143, 2) : " + LPM(600851475143L, 2));
	}

	private static int LPM(long N, int prime) {
		
//		while( N % prime!=0) {
//			prime++;
//		}
		
		if(N==prime) {
			return prime;
		} else if ( N % prime == 0 ) {
			return LPM ( N/prime, prime); 
		} else {
			return LPM( N, prime + 1);
		}
		
		/*return LPM ( N , prime+1);
		/*
		 *
		 * 2    10
		 * 2     5
		 * 2    18
		 * 3    9
		 *      3
		*/
	    
		
	}

}
