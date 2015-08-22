package P0001.dohyun;

public class Multples {

	static int result = 0;
	static int i = 0;

	public static void main(String[] args) {
		sum(1000, 1);
	}

	private static void sum(int max, int i) {
		if (i == max) {
			System.out.println("배수들의 총 합:" + result);
			return;
		}

		if (i % 3 == 0 && i % 5 != 0) {
			result = result + i;
			System.out.println("3의 배수: " + i);

		}
		if (i % 5 == 0) {
			result = result + i;
			System.out.println("5의 배수: " + i);

		}
		i++;
		sum(max, i);
	}
}
