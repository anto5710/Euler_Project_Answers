package P0021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * 28 = [ 1, 2, 4, 7, 14, ] = 28
 * 
 * @author anto5710
 *
 */
public class Amicieble_Numbers {
	public static void main(String[] args) {

		List<Integer>list = get_Amicieble_Numbers(10000);
		System.out.println(list);
		System.out.println(getSumOfList(list));
	}
	private static List<Integer> get_Amicieble_Numbers(int max) {
		List<Integer>list = new ArrayList<>();
		for(int n = 1 ; n<=max ; n++){
			if(!util.Uitl.isPrime(n)){
				List<Integer>propel_divisors= getPropel_Divisors(n);
				long sum  = getSumOfList(propel_divisors);
				List<Integer>propel_divisors_of_sum= getPropel_Divisors(sum);
				long sum_II = getSumOfList(propel_divisors_of_sum);
				if(n == sum_II&&sum!=n){
					list.add(new Integer(n));
				}
			}
		}
		return list;
	}
	public static long getSumOfList(List<Integer>list)
	{
		return util.Uitl.getSumOfNumbers(list);
	}
	
	public static List<Integer> getPropel_Divisors(long sum){
		List<Integer>list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1 , 2));
		long Max_Num = sum/2;
		for(int n = 3 ; n <= Max_Num ; n++){
			if(sum%n==0){
				list.add(n);
			}
		}
		
		
		return list;
	}
}
