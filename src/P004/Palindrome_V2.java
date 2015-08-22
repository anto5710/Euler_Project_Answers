package P004;

public class Palindrome_V2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getBiggestPalNum(2);
	}

	public static void getBiggestPalNum(int digit) {
		int answer = -1;
		int min =  (int) Math.pow(10, digit-1) ; 
		int max = (int) Math.pow(10, digit) - 1; // n자리 숫자 중에서 가장 큰 수를 구하는 공식
													// //n자리 숫자중에 가장 작은 수 구하기
		int start = max * max;  // 가장 큰 수
		
		while(start>min) {
			if(isPalindrome(start)!=true) {
				start--;
			} else if(isPalindrome(start)==true && isMultiplyable( start, digit )) {
				System.out.println(start);			
				break;
				
				
			}
			
		}
	
	}

	/**
	 * 주어진 숫자 start가 digit 자릿수수 숫자 두개의 곱으로 표현할 수 있는지 판단합니다.
	 * 
	 * start : 120
	 * digit : 2
	 * 12 x 10 
	 * @param start
	 * @param digit
	 * @return
	 */
	private static boolean isMultiplyable(int start, int digit) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 주어진 숫자가 회문 형태이면 true를 반환합니다.
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isPalindrome(int value) {
		String val = String.valueOf(value);
		String val2 = ""; // empty string
		for (int i = val.length() - 1; i + 1 > 0; i--) {
			val2 = val2 + val.charAt(i);
		}
		return val2.equals(val);
	}

}
