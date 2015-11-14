package P0020;

import util.BigInt;

public class P0020main {
	public static void main(String[] args) {
		String num = getFactorial(100);
		System.out.println(sum(num));
	}

	private static int sum(String num) {
		int result=0;
		for(int i = 0; i < num.length() ; i++){
			String  n= num.charAt(i)+"";
			result+=Integer.parseInt(n);
		}
		return result;
	}

	private static String getFactorial(int num) {
		String result = num+"";
		for(;num>=1;num-- ){
			result = BigInt.multipy(result, num+"");
		}
		return result;
	}
}
