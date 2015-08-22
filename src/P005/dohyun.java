package P005;

import java.util.ArrayList;
import java.util.List;

public class dohyun {
	public static void main(String[] args) {
		int min = 1;
		int max = 20;
		int lcm10 = findLCM (10); // 2520
		System.out.println(lcm10);

		int lcm20 = findLCM (20); // 2520
		System.out.println(lcm20);
		// int lcm20 = findLCM (12); // 2520
	}

	/**
	 * 1부터 num까지의 최소 공배수 구하기
	 * 
	 * @param num
	 * @return
	 */
	private static int findLCM(int num) {

		// ArrayList<Integer> primes = new ArrayList<Integer>();

		/*
		 *  num:= 2520 약수집합 [] --------------------- 
		 *  
		 *  primes  result
		 *             [] 
		 * 2 [2]       [2] 
		 * 3 [3]       [2,3]
		 * 4 [2,2]     [2,3,2]        12 
		 * 5 [5]       [2,3,2,5]      60 
		 * 6 [2,3]     [2,3,2,5] 
		 * 7 [7]       [2,3,2,5,7]    420 
		 * 8 [2,2,2]   [2,3,2,5,7,2]  840 
		 * 9 [3,3]}    [2,3,2,5,7,2,3] 2520
		 *  
		 * 10[2,5]                  2520 
		 * 
		 * 
		 * result - primes
		 * 
		 *   [2,3] - [2,2] = [3]
		 *   
		 *   result           -      primes  = [3]
		 *   [2, 3, 2, 5, 5]  - [2, 3, 3, 5] = [3]
		 *   [2, 3, 2, 5, 5, 3]
		 * 
		 * 
		 * . 20 [2,3,2,5,7,2,3, ...... ] ???????
		 */
		ArrayList<Integer> resultPrimes = new ArrayList<>(); // [2, 3, 2]\
		int total = 1;
		for (int i = 2; i < num; i++) {
			List<Integer> primes = getprime(i); // [2 ,3]
			List<Integer> remainig =  substract(primes , resultPrimes) ; // [2,3] - [2, 3, 2] => []
			resultPrimes.addAll(remainig); 

		}
		for(Integer c : resultPrimes){
			total = total*c;
		}
		return total;
	}

	public static List<Integer> substract(List<Integer> primes,
			List<Integer> resultPrimes) {
		// [2, 3, 2].removeAll( [ 3, 5] )   = [2, 2]
	
	   for(Integer value: resultPrimes){
		  primes.remove(value);
	   }
		// TODO Auto-generated method stub
		return primes;
	}

	public static ArrayList<Integer> getprime(int number) {
		ArrayList<Integer> list = new ArrayList<>();
		/*
		 * 12 -> 6        [2]
		 * 6 ->  3         [2, 2]
		 * 3 -> 
		 */
        getPrimeRecursion(number, list, 2);
		return list;
		// TODO Auto-generated method stub

	}
	/*
	 * recur ( 12, [], 2) -> recur( 6 [2], 2 ) 
	 *                    ->  recur(3, [2, 2], 2) 
	 *                    -> recur( 3, [2,2], 2+1) 
	 *                    -> recur (1, [2, 2, 3], 3)
	 * 
	 */
	private static void getPrimeRecursion ( int number, ArrayList<Integer> list , int divider) {
		if(number==1){
			return;
		}
		if ( number % divider == 0) {
			list.add(divider);
			getPrimeRecursion(number/divider, list, divider); // bug!
		} else {
			getPrimeRecursion(number, list,divider+1);
		}
	}

	public static boolean isPrime(int value) {
		// TODO Auto-generated method stub
		if (value == 1) {
			return false;
		}
		else if(value==2){
			return true;
		}
		
		for (int i = 2; i < value - 1; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
}
