package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Uitl {
	public static long getSumOfNumbers(Collection<Integer>list ){
		long total = 0;
		Iterator<Integer>iterator = list.iterator();
		while(iterator.hasNext()){
			Integer integer = iterator.next();
			total+=integer;
		}
		return total;
	}
	
	/**
	 *  src문자열에서 dest의 문자들을 모두 제거한 새로운 문자열을 반환합니다.
	 *  
	 *  String s = Util.strip("abcdef", "aef") ;
	 *  s.equals ( "bcd");
	 * @param src
	 * @param dest
	 * @return
	 */
	public static String strip( String src, String other) {
		for(int i = 0; i<other.length() ; i++){
			src = src.replace(other.charAt(i)+"", "");
		}
		return src;
	}
	
	/**
	 * 주어진 수가 소수(prime number)인지 판별합니다.
	 * @param num
	 * @return 소수이면 true반환합니다.
	 */
	public static boolean isPrime(long num){
		
		if (num <= 1) {
			return false;
		}
		else if(num==2){
			return true;
		}
		
		for (int i = 2; i < num - 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static long getFactorial(int last_n) {
		long result = 1;
		for(int n = 2 ; n<=last_n ; n++){
			result*=n;
		}
		return result;
	}

	public static boolean areAllSame(Collection<?> values) {
		Object object = values.toArray()[0];
		for(Object obj : values){
			if(object != obj){
				return false;
			}
		}
		return true;
	}

	public static long MultiplyLong(Collection<Long>nums) {
		long result =1;
		for(long integer : nums){
			result*=integer;
			
		}
		return result;
	}
	
	public static int MultiplyInteger(Collection<Integer>nums) {
		int result =1;
		for(Integer integer : nums){
			result*=integer;
			
		}
		return result;
	}
	public static int toInteger(String num){
		return Integer.parseInt(num);
	}

	public static Long getSumOfNumbers(List<Long> list) {
		long total = 0;
		Iterator<Long>iterator = list.iterator();
		while(iterator.hasNext()){
			Long l = iterator.next();
			total+=l;
		}
		return total;
	}
	
}
