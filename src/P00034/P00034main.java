package P00034;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.PortableInterceptor.INACTIVE;

import util.BigInt;

public class P00034main {
	
	static Map<Integer, Long>f = new HashMap<Integer, Long>();
	/* 어떤 수 n이 있을때,
	 *n의 (각자리 수)!의 합 = n인 수들의 합을 구하여라. 
	 *주의 : n!= 1 && n!=2 
	 *ex) 1! + 4! + 5!= 145 
	 *
	 * 	1자리수> 1! ~ 9! > 1 ~ 362880
		2자리수> 10! ~ 99! > 2 ~ 725760
		3자리수> 100! ~ 999! > 3 ~ 1088640
		4자리수> 1000! ~ 9999! > 4 ~ 1451520
		5자리수> 10000! ~ 99999! > 5 ~ 1814400
		6자리수> 100000! ~ 999999! > 6 ~ 2177280
		7자리수> 1000000! ~ 9999999! > 7 ~ 2540160
		8자리수> 10000000! ~ 99999999! > 8 ~ 2903040
		9자리수> 100000000! ~ 999999999! > 9 ~ 3265920
		10자리수> 1000000000! ~ 9999999999! > 10 ~ 3628800
		11자리수> 10000000000! ~ 99999999999! > 11 ~ 3991680
		12자리수> 100000000000! ~ 999999999999! > 12 ~ 4354560
		13자리수> 1000000000000! ~ 9999999999999! > 13 ~ 4717440
		14자리수> 10000000000000! ~ 99999999999999! > 14 ~ 5080320
	 *
	 * 	이때 8자리의 경우, (각자리 수)!의 합의 최대값이 가장 작은 8자리수인 1000000보다 작으므로,
	 *	8자리부터는 (각자리 수)!의 합 = n인 수가 더이상 나오지 않는다.
	 *	
	 *	따라서 1~7자리의 수들만 확인하여도 된다는 것을 알 수 있다.
	 */
	
	public static void put(){
		for(int n = 0; n<10;n++){
			f.put(n, util.Uitl.getFactorial(n));
		}
	}
	public static void main(String []args){
		put();
		
		List<Integer>nums = get(7);
		long result = util.Uitl.getSumOfNumbers(nums);
		
		System.out.println("RESULT> "+result);
	}
	public static List<Integer> get(int max_digit) {
		
		List<Integer> nums = new ArrayList<>();
		long max = (long) Math.pow(10, max_digit) - 1;
		for (int n = 3; n <= max; n++) {
			List<Long> f_min = getFactorialOfDigits(n);
			long result = util.Uitl.getSumOfNumbers(f_min);
			if (result == n) {
				nums.add(n);
			}
		}
		return nums;
	}
	
	public static void print(int max_digit){
		for(int d = 1; d<=max_digit; d++){
			long min = (long) Math.pow(10, d-1);
			long max = (long) Math.pow(10, d)-1;
		
			List<Long>f_min= getFactorialOfDigits(min);
			List<Long>f_max= getFactorialOfDigits(max);
			
			
			long result_min =util.Uitl.getSumOfNumbers(f_min);
			long result_max =util.Uitl.getSumOfNumbers(f_max);
			
			System.out.println(String.format("%d자리수> %d! ~ %d! > %d ~ %d", d, min , max, result_min, result_max));
		}
	}
	public static List<Long> getFactorialOfDigits(long n) {
		String n_s = n + "";
		ArrayList<Long> factorials = new ArrayList<>();

		for (int i = 0; i < n_s.length(); i++) {
			String chr = n_s.charAt(i) + "";
			int num = util.Uitl.toInteger(chr);
			Long l = f.get(num);
			factorials.add(l);
		}
		return factorials;
	}

}
