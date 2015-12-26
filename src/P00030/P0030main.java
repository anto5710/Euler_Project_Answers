package P00030;

import java.util.ArrayList;
import java.util.List;



public class P0030main {
	
	
   /* 1234
	* 1234 != (1*2*3*4)^4   
	* 1634 == (1*6*3*4)^4
	* 
	* 35 => 3^4 + 5^4 = 81 + 625 = 706
	* 
	* 382 
	* 
	* 
	*
	*/
//	public static void c(){
//		for(int i=6  ; i<10; i++){
//			String max = "";
//			for(int c = 0; c< i ;c++){
//				max+="9";
//			}
//			int ic =Integer.parseInt(max);
//			System.out.println(String.format("[%d ~ %d] => [%d ~ %d] ", (int)Math.pow(10, i-1), ic, 1, (int)Math.pow(9, 5)*i));
//		}
//	}
//	
	
	public static void main(String[] args) {
//		int digit = 3;
//		int start = (int) Math.pow(10 , digit-1);
//		int end = (int)Math.pow(10, digit);
		int start = 100;
		int end = 354294; // 6자리 숫자 999999의 각 자릿수를 곱한 최대값. 7자리부터는 성립안됨.
		List<Integer>nums = new ArrayList<Integer>();
		for(int n =  start; n< end ; n++){
			if(n==getPowOfDigits(n, 5)){
				nums.add(n);
			}
		}
		long result =util.Uitl.getSumOfNumbers(nums);
		System.out.println("RESULT> "+ result );
	}
	/**
	 * num 의 각 자리숫자를 exp 만큼 제곱한 후에 더한 값을 반환합니다.
	 * 
	 * @param num
	 * @param exp
	 * @return
	 */
	private static int getPowOfDigits(int num, int exp) {
		int result=0;
		String number = num+"";
		for(int i = 0; i <number.length() ; i++){
			String cur = number.charAt(i)+"";
			int curNum = Integer.parseInt(cur);
			result+=Math.pow(curNum, exp);
		}
		return result;
	}
	
	
	
			
		
		
	
	

}
