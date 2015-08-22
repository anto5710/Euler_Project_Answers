package P004;

public class Palidrome {

	public static void main(String[] args) {
	   
		getBiggestPalNum(3);
	}

	public static void getBiggestPalNum(int digit) {
		int first = -1;
	
//		int value =(10^(digit+1))-1;
		int value = (int) Math.pow(10, digit) - 1; // n자리 숫자 중에서 가장 큰 수를 구하는 공식 //n자리 숫자중에 가장 작은 수 구하기
		int min =  (int) Math.pow(10, digit-1) ; 
		System.out.println(value + " "+ min);
		System.out.println(isPalindrome(1001));
	    for(int k = 1; k <=value; k ++) {
		for( int i= min; i<= k; i++) {
			if(isPalindrome(k*i)) {
				if ( k * i > first ) {
					first = k * i ;
				}
				System.out.println("!!!! : " + k*i+"   value: " + k + "   i: " + i);
			}
	
			
		}
	    }
	    System.out.println(first);
	}
	/**
	 * 주어진 숫자가 회문 형태이면 true를 반환합니다.
	 * @param value
	 * @return
	 */
	private static boolean isPalindrome(int value) {
		// TODO Auto-generated method stub
		String val = String.valueOf(value);
		String val2= ""; // empty string 
		for(int i = val.length()-1;i+1 > 0; i--) {
			val2 = val2+ val.charAt(i);
		}
		// System.out.println("val: "+ val + "val2: " + val2);		
		if(val2.equals(val) ) {
			return true;
		}
		else {
			return false;
		}
	}

}
