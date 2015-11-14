package P0023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Helper {

	/**
	 * base^exp
	 * ex) pow(3,2) = 3^2 = 9
	 * 
	 * @param base
	 * @param exp
	 * @return
	 */
	public static long pow(long base, int exp) {
		if ( exp == 0 ) {
			return 1;
		}
		long val = base;
		long tmp = 1;
		for ( int i = 0 ; i < exp ; i++) {
			tmp *= base;
			if ( tmp < val ) {
				throw new ArithmeticException("overflow occured : " + base + " ^ " + exp );
			}
			val = tmp;
			
		}
		return val;
	}

	/**
	 * 주어진 배열을 뒤집어서 반환함.
	 * @param va
	 * @return
	 */
	public static int [] reverse ( final int [] va, boolean clone) {
		int [] vb = clone ? Arrays.copyOf(va, va.length) : va;

		final int len = vb.length/2;
		for(int i = 0 ; i < len ; i++) {
			int tmp = vb[i];
			vb[i]  = vb[vb.length-1-i];
			vb[vb.length-1-i] = tmp;
		}
		
		return vb;
	}
	/**
	 * 주어진 수의 약수들을 반환함(num 자기 자신도 포함)
	 * @param num
	 * @param includeOne true 이면 1도 포함해서 반환함. false이면 1은 제외
	 * @return
	 */
	public static int[] getDivisors(final int num , boolean includeOne) {
		return divisors(num, includeOne, true);
	}
	
	/**
	 * proper divisor를 반환함
	 * 
	 * ex) 24 = [1, 2, 3, 4, 6, 8, 12]
	 * 
	 * @param num
	 * @return
	 */
	public static int[] getProperDivisors(final int num) {
//		return getProperDivisors(num, true);
		return divisors(num, true, false);
	}
	/**
	 * 
	 * @param num
	 * @param includeOne
	 * @return
	 */
	public static int[] getProperDivisors(final int num, boolean includeOne) {
		return divisors(num, includeOne, false);
	}
	/**
	 * 약수를 구함. 
	 * @param num
	 * @param includeMax - true이면 가장 큰 약수(num)도 포함시킴
	 * @param includeMin - true이면 가장 작은 약수(1)도 포함시킴.
	 * @return
	 */
	private static int [] divisors( final int num, boolean includeMin, boolean includeMax) {
		if ( num <= 0 ) {
			throw new RuntimeException("num should be greater than zero: " + num);
		}
		if ( num == 1) {
			return new int[0];
		}
		List<Integer> divisors = new ArrayList<>();		
		int div = 2;
		int margin = (int) Math.sqrt(num);
		while ( div <= margin ) {
			if ( num % div == 0 ) {
				divisors.add(div);
				int other =  num / div;
				divisors.add(other);
			}
			div ++ ;
		}
		if ( includeMin) {
			divisors.add(Integer.valueOf(1));
		}
		if ( includeMax){
			divisors.add(num);
		}
		Collections.sort(divisors);
		
		int [] answers = new int[divisors.size()];
		for (int i = 0; i < answers.length; i++) {
			answers[i] = divisors.get(i).intValue();
		}
		return answers;
	}
	
	public static int sums ( int [] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	/**
	 * 숫자 N에 대해서 N의 진약수들(proper divisors)의 합이 N보다 큰 수를 abundant number(과잉수)라고 함.
	 * 
	 *  ex) 20의 진약수의 합 : 1 +2 +4 +5 +10 = 22 > 20
	 * 
	 * @from P0023
	 * @param num
	 * @return
	 */
	public static boolean isAbundantNum( int num) {
		return sums(getProperDivisors(num)) > num ;
	}

	/**
	 * 배열 안에 주어진 숫자가 존재하는가?
	 * @param num 찾을 숫자
	 * @param arr 검색 대상 배열 (정렬되어 있어야 함)
	 * @return
	 */
	public static boolean contains(int num, int[] arr) {
		return Arrays.binarySearch(arr, num) >= 0 ;
	}

	/**
	 * 주어진 숫자의 자릿수를 구함. ex) 100 이면 3반환
	 * @param val
	 * @return
	 */
	public static int digit(int val) {
		int nDigit = 0;
		if ( val == 0 ) {
			return 1;
		}
		while ( val > 0) {
			nDigit ++;
			val /= 10;
		}
		return nDigit;
	}

	/**
	 * 주어진 수를 prime number들의 리스트로 반환함.
	 * 
	 * ex) 24 = 4*6 = 2*2*2*3 = [2, 2, 2, 3]
	 * @param num
	 * @return
	 */
	public static List<Integer> primeFactors(long num) {
		List<Integer> primes = new ArrayList<>();
		long v = num;
		int div = 2;
		while ( v > 1) {
			if ( v  % div == 0 ) {
				primes.add(div);
				v /= div ;
			} else {
				div ++;
			}
		}
		return primes;
	}
	
	public static int [] primeFactors2( long num  ) {
		List<Integer> l = primeFactors(num);
		int [] primes = new int[l.size()];
		for ( int i = 0 ; i < primes.length; i++) {
			primes[i] = l.get(i).intValue();
		}
		return primes;
	}

	public static <T extends Number> int sum(Collection<T> nums) {
		int total = 0;
		for (T integer : nums) {
			total += integer.longValue();
			
		}
		return total;
	}
	
	public static <T extends Number> long sumAsLong(Collection<T> nums) {
		long total = 0;
		for (T integer : nums) {
			total += integer.longValue();
			
		}
		return total;
	}
	

	/**
	 * <pre>
	 * 주어진 문자열 s에서 문자 ch들을 모두 제거한 새로운 문자열을 반환합니다. 
	 * ex) strip( "abcdeb" , 'b') : "acde"
	 * </pre>
	 * @param s
	 * @param ch
	 * @return 문자열 s에서 ch가 모두 제거된 문자열
	 */
	public static String strip(String s, char ch) {
		StringBuilder sb = new StringBuilder();
		char tmp;
		for ( int i = 0 ; i < s.length(); i++) {
			tmp = s.charAt(i);
			if ( tmp != ch ) {
				sb.append( tmp );
			}
		}
		return sb.toString();
	}

	/**
	 * 주어진 숫자가 prime number 인지 판단함.
	 * @param n
	 * @return
	 */
	public static boolean isPrimeNum(int n) {
		if ( n == 1 ){
			return false;
		}
		if ( n == 2) {
			return true;
		}
		if ( n % 2 == 0 ){
			// 2가 아닌 모든 짝수는 prime number가 아님
			return false;
		}
		int margin = (int) Math.sqrt(n);
		for ( int div = 3 ; div <= margin; div += 2) {
			if ( n % div == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrimeNum(long n ) {
		if ( n == 1 ){
			return false;
		}
		if ( n == 2) {
			return true;
		}
		if ( n % 2 == 0 ){
			// 2가 아닌 모든 짝수는 prime number가 아님
			return false;
		}
		long margin = (long) Math.sqrt(n);
		for ( long div = 3 ; div <= margin; div += 2) {
			if ( n % div == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome(String s) {
		final int sz = s.length()/2;
		for ( int i = 0 ; i < sz ; i++) {
			if ( s.charAt(i) != s.charAt(s.length()-1-i) ) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 주어진 num이 n-digits pandigital 형태인지 판별함.
	 * ex) isPanDigital ( 4321, 4) : true
	 *     isPanDigital ( 5432, 4) : false, because of 5
	 *     isPanDigital ( 135792468, 9 ) : true
	 * @param num
	 * @param nDigit 1에서 nDigit까지의 숫자범위를 나타냄
	 * @return
	 */
	public static boolean isPanDigital(int num, int nDigit) {
		String s = String.valueOf(num);
		if( s.length() != nDigit ) {
			return false;
		}
		if ( s.indexOf('0') >= 0 ) {
			return false;
		}
		
		for ( int i = 0 ; i < s.length(); i++) {
			char ch = s.charAt(i);
			for ( int k = i+1 ; k < s.length(); k++) {
				if ( s.charAt(k) == ch ) {
					return false;
				}
			}
			if ( ch-'0' > nDigit) {
				// nDigit보다 큰 숫자가 있음
				return false;
			}
		}
		return true;
	}

	/**
	 * 주어진 문자열의 각 문자를 element로 하는 조합을 반환함.
	 * ex) combinations("abc") : ["abc", "acb", "bac", "bca", "cab", "cba"]
	 * 
	 * @param elems
	 * @return
	 */
	public static List<String> combinations(String elems) {
		return combinations(elems, elems.length());
	}
	
	public static List<String> combinations(String elems, int size) {
		if ( elems.length() < size) {
			throw new RuntimeException(
					String.format("length of %d '%s' is less than size %d", elems.length(), elems, size));
		}
		List<String> comb = new ArrayList<>();
		Helper.comb_recursion(comb, "", elems, size) ;
		return comb;
	}

	private static void comb_recursion(List<String> answer, String current, String elems, int size) {
		if ( size == 0 ) {
			answer.add(current);
			return ;
		}
		if ( elems.isEmpty()) {
			//no more element usable
			return ;
		}
		char ch ;
		for ( int i = 0 ; i < size ; i++) {
			ch = elems.charAt(i);
			String remaining = strip(elems, ch);
			comb_recursion(answer, current + ch, remaining, size-1);
		}
	}

	

}
