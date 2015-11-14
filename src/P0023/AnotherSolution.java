package P0023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnotherSolution {

	public static void main(String[] args) {
		// 1. 28123 보다 작은 모든 과잉수를 모음.
		List<Integer> abundantNums = listAllAbundantNums( 28123 );
//		System.out.println(abundantNums);
		System.out.println("# of abundant num: " + abundantNums.size());
		
		// 2. 과잉수들을 곱한 모든 숫자들을 모음.
		int SIZE = abundantNums.size();
		int [] suareOfAbundantNums = new int[SIZE*SIZE]; // 6965 * 6965
		int t = 0;
		for ( int i = 0 ; i < SIZE ; i++) {
			for( int k = 0 ; k < SIZE ; k++) {
				suareOfAbundantNums[t++] = abundantNums.get(i) + abundantNums.get(k);
			}
		}
		Arrays.sort(suareOfAbundantNums);
		System.out.println(suareOfAbundantNums[0] + " ~ " + suareOfAbundantNums[SIZE*SIZE-1]);
		System.out.println("STEP 3");
		// 3. 28123보다 작은 수들 중 과잉수로 표현되지 않는 숫자들을 모두 합함.
		long answer = 0;
		for ( int i = 1 ; i < 28123; i++ ) {
			if ( ! Helper.contains( i, suareOfAbundantNums )){
				answer += i;
			}
//			if ( i % 100== 0){
//				System.out.println( (i+1) + "th ...");
//			}
		}
		System.out.println("answer : " + answer);
		
	}

	/**
	 * 주어진 수 num 보다 작거나 같은 수 중에서 과잉수들을 반환함.
	 * @param num
	 * @return
	 */
	private static List<Integer> listAllAbundantNums(int num) {
		List<Integer> nums = new ArrayList<>();
		for ( int i = 1 ; i <= num ; i++) {
			if ( Helper.isAbundantNum(i)) {
				nums.add(i);
			}
		}
		return nums;
	}
}
