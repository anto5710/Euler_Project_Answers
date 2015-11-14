package util;

import java.util.Collection;
import java.util.Iterator;

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
	 * 주어진 수가 솟수(prime number)인지 판별합니다.
	 * @param num
	 * @return 솟수이면 true반환합니다.
	 */
	public static boolean isPrime(long num){
		if (num == 1) {
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
}
