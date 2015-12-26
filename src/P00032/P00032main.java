package P00032;

import java.util.ArrayList;
import java.util.List;

/**
 *         A     B     C
 *case-1  1자리  4자리   4자리
 *case-2  2자리  3자리   4자리
 *
 *  [case-1]
 *  A - '1'
 *             -'2345'
 *             -'2346'
 *               ..
 *               ..
 *             - '6789'
 *    - '2'
 *    - '3'
 *    .
 *    .
 *    - '9' 
 * @author anto5710
 *
 */
public class P00032main {
	public static void main(String []args){
		String src = "123456789";
		List<Integer> cases = new ArrayList<>();
		combination(src,cases,  1, 4, 4);
		combination(src,cases,  2, 3, 4);

		System.out.println(util.Uitl.getSumOfNumbers(cases));
	}
	
	public static void combination(String s,List<Integer>result,int na ,int nb , int nc){
		
		List<String>list_a = new ArrayList<>();
		combination(list_a, s, na, "");
		
		for(String a : list_a){
			
			List<String>list_b = new ArrayList<>();
			combination(list_b, util.Uitl.strip(s, a), nb, "");
			
			for(String b : list_b){
				
				List<String>list_c = new ArrayList<>();
				combination(list_c, util.Uitl.strip(s, b + a), nc, "");

				for (String c : list_c) {
					if (s2i(a) * s2i(b) == s2i(c)) {
						if (!result.contains(s2i(c))) {
							result.add(s2i(c));
						}
					}
				}
			}
		}
	}
	public static int s2i ( String s) {
		return Integer.parseInt(s);
	}
	/**
	 * 
	 * target="23456789"
	 * n = 4;
	 * ["2345", "2346", "2347", ...... "6789"] 70개
	 * @param target
	 * @param n
	 * @return
	 */
	public static void combination(List<String> answers, String target, int n ,String cur ) {
		if(cur.length()==n){
			answers.add(cur);
			return ;
		}
		
		for(int i= 0; i <target.length();i++){
			String c = target.charAt(i)+"";
			combination(answers,target.replace(c, ""), n, cur+c);
		}
	}
}
