package P0002;

public class Fibonacci {

	/**
	 * 50 미만인 모든 항들을 다 더해봅시다.
	 * 
	 * @param args
	 * 
	 * 
	 * 
	 * 
	 * 
	 *            1 2 1 2 =3 3 2 =5 5 3 =8 8 5 =13 13 8 =21 = 53
	 */
	static int sum = 0;

	public static void main(String[] args) {
		int f0 = 1;
		int f1 = 2;
		System.out.println("current sum : " + sum); // 0
		sum = f0 + f1;
		System.out.println("current sum : " + sum); // 3

		recursive_sum(30, f0, f1);  // (30, 1, 2)
	}

	/*
	 * 1 sum:1 
	 * 2 sum:3 
	 * 3 sum:6 
	 * 5 sum:11 
	 * 8 sum:19
	 *  
	 * 13 sum:32 xxxxxxx
	 */
	private static void recursive_sum(int max, int first, int second) {
		// first:5, second:8
		// third: 8
//		final int third = first + second;
		if ((sum + first+second) >= max) {
			System.out.println("final result : " + sum);
			return;
		}

		System.out.println("final result : " + sum);
		sum = sum + first+second;
		recursive_sum(max, second, (first+second)); // (30, 5, 8)
	}

}
