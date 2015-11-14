package P0023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P0023main {
	static ArrayList<Integer>abundant_numbers = new ArrayList<>();
	static int upper_limit = 28123;
	public static void main(String [] args){
		abundant_numbers =getabundant_numbers(upper_limit);
		System.out.println("# of abundant nums: " + abundant_numbers.size());
		
		List<Integer> sumOfANums =getSumOf_Abundant_Numbers(abundant_numbers);
		System.out.println("# of sum of abundant nums: " + sumOfANums.size());
		
//		List<Integer>positive_numbers =getListOfNum(1, upper_limit);
		long sum = 0;
		for ( int i = 1 ; i < upper_limit ; i++) {
			if ( ! sumOfANums.contains(i) ) {
				sum += i;
			}
		}
		
//		System.out.println("list of candidats : " + positive_numbers.size());
//		positive_numbers.removeAll(list);
//		System.out.println("all removed");
//		long sum =util.Uitl.getSumOfNumbers(positive_numbers);
		System.out.println(sum);
	}
	
	private static List<Integer> getListOfNum(int start, int end) {
		ArrayList<Integer>list = new ArrayList<>();
		for(; start<=end; start++){
			list.add(start);
		}
		return list;
	}

	private static List<Integer> getSumOf_Abundant_Numbers(List<Integer> nums) {
		List<Integer>list = new ArrayList<>();
		/*		c = 
		 * 
		 * 		n* (n-1)
		 * 	  ------------ + n
		 *         2
		 * 		
		 *        n0 n1 n2 n3  .... (28123)
		 *    n0  A     
		 *    n1  E B   
		 *    n2  F H  C
		 *    n3  G I  J  D
		 *   
		 */
			
//		for(int n= 24; n <=upper_limit; n++){
//			if(is_SumOf_Abundant_number(n)){
//				list.add(n);
//			}
//		}
		int len = nums.size();
		int v1, v2 ;
		Set<Integer> set = new HashSet<>();
		for ( int ir = 0 ; ir < len ; ir++) {
			v1 = nums.get(ir);
			if ( v1 > upper_limit ) {
				break;
			}
			for ( int ic = 0 ; ic <= ir ; ic ++ ) {
				v2 = nums.get(ic);
				if ( v2 > upper_limit) {
					break;
				}
				int result = v1 + v2;
				if(result<=upper_limit ){
					set.add(result);
				}
			}
		}
		System.out.println("OK");
		list.addAll(set);
		return list;
		
	}

	public static ArrayList<Integer> getabundant_numbers(int limit){
		ArrayList<Integer>list = new ArrayList<>();
		for(int n = 12; n <=limit ;n++){
			if(isAbundant_number(n)){
				list.add(n);
			}
		}
		return list;
	}

	public static boolean is_SumOf_Abundant_number(int n) {
		if(n<=12){
			return false;
		}
		for(int c =12 ; c <=n-12 ; c++){
			int c2 = n-c;
			if(abundant_numbers.contains(c)&& abundant_numbers.contains(c2)){
				return true;
			}
		}
		return false;
	}

	static boolean isAbundant_number(int n) {
		List<Integer>divisors = getProper_Divisors(n);
		long sum =util.Uitl.getSumOfNumbers(divisors);
		if(n<sum){
			return true;
		}
		return false;
	}
	
	public static ArrayList<Integer> getProper_Divisors(int n) {
		// n : 12
		ArrayList<Integer>list = new ArrayList<>();
		list.addAll(Arrays.asList(1));
		for(int i = 2 ; i<= n/2 ; i++){
			if(n%i==0){
				list.add(i);
			}
		}
		return list;
	}
	
}
