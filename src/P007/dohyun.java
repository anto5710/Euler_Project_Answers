package P007;

public class dohyun {
	public static void main(String[] args) {
		dohyun dh = new dohyun();
		int th = 10001;
		int Given = 2;
		int cnt = 0;
		int lastPrimeNum = -1;
		while (cnt != th ) {
			if (dh.returnPrime(Given)) {
				cnt ++ ;
				lastPrimeNum = Given;
			}
			Given ++ ;
			
		}
		System.out.println("[Result] " + lastPrimeNum);

	}

	public boolean returnPrime(final int number) {
		// boolean isPrime = false;
		if (number == 2) {
			return true;
		}
		if ( number % 2 == 0 ) {
			return false;
		}
		// 3, 5, 7, 9, 11, 13, 15, ....101 
		// root(15) = 3.xxxxx  1, 2, 3
		int upperBound = (int) Math.sqrt(number);
		for (int i = 3; i <= upperBound; i+=2 ) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
