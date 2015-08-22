package P0002;

public class FibonacciLoop {

	public static void main(String[] args) {
		// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
		// 2 + 8 + 34 + 144 = 188
		sum(4000000);
	}

	private static void sum(int max) {
		int first = 1, second = 2, third = first + second;
		int sum = second;
		while (  third < max) {
			if (third % 2 == 0) {
				sum = sum + third;
				System.out.println("inter: " + sum + ", third: " + third);
			}
			first = second; // first : 2
			second = third; // sencond : 3
			third = first + second;
		}
		System.out.println(sum);
	}
	

}
