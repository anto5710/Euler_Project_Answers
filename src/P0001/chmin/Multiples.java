package P0001.chmin;

public class Multiples {

	public static void main(String[] args) {
		int sum = 0;
		for ( int i = 1; i < 1000; i++) {
			if ( i %3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		System.out.println("1. 반복문 버전 : " + sum);
		
		recursive_sum(1000, 1, 0 );
	}
	
	static void recursive_sum( int max, int value, int sum ) {
		
		if ( value == max) {
			System.out.println("2. 재귀 버전: " + sum);
			return ;
		}
		int inc = 0;
		if ( value %3 == 0 || value%5 == 0 ) {
			inc = value;
		}
		
		recursive_sum(max, value+1, sum + inc);
		
	}
}
