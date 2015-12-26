package P00029;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import util.BigInt;

public class P00029main {
		public static void main(String []args){
			
			ArrayList<String> list = new ArrayList<>(getTerms(9,9, 2, 10));
			
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					Double d1 = Double.parseDouble(s1);
					Double d2 = Double.parseDouble(s2);
					return d1.compareTo(d2);
//					return s1.compareTo(s2);
					
				}
			});
			for ( int i = 0 ; i < list.size() ; i++) {
				System.out.print( list.get(i) + " | " );
			}
			
			long before =System.currentTimeMillis();
			Set<String> result  = getTerms(2, 100, 2, 100);
			long after = System.currentTimeMillis();
			System.out.println(result.size());
			System.out.println((after-before)/1000 + "sec");
		}
		/**
		 * 무식하게 푼 방법입니다.
		 * 답은 나옵니다.
		 * @param min_a
		 * @param max_a
		 * @param min_b
		 * @param max_b
		 * @return
		 */
		public static Set<String> getTerms(int min_a , int max_a , int min_b , int max_b){
			Set<String> terms = new HashSet<>();
			for(int a = min_a ; a<= max_a;a++){
				for(int b = min_b ; b<=max_b ; b++){
					terms.add(BigInt.pow(a , b));
				}
			}
			return terms;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
