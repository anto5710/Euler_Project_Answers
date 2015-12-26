package P00033;

import java.util.ArrayList;
import java.util.List;

public class P00033main {
	//분자와 분모 중 하나 이상 합성수여야한다.
	//분모
	public static void main(String []args){
		List<Fraction> fourFractions = find_nonTravialFraction();
		
		Fraction answer = new Fraction ( 1, 1) ;
		for ( Fraction f : fourFractions) {
			answer.mutiply ( f );
		}
		answer.reduct();
		System.out.println("result: " + answer);
	}
	
	
	
	public static List<Fraction> find_nonTravialFraction(){
		List<Fraction> fourFactions = new ArrayList<>();
		
		int minA = 10;
		int maxA = 99 - 1;
		
		for (int a = minA; a <= maxA; a++) {
			System.out.println("-------------");
			for (int b = a + 1; b <= maxA + 1; b++) {
				System.out.println( String.format("bunja: %d, bunmo: %d", a, b));
				Fraction fr = new Fraction(a, b);
				System.out.println("origin fraction: " + fr);
				fr.reduct();
				System.out.println("reduced fraction: " + fr);
				Fraction replaced = replaceFraction(a, b);
				System.out.println("replaced fraction: " + replaced);
				replaced.reduct();
				if ( fr.equals(replaced) ) {
					fourFactions.add(new Fraction(a, b));
				}
			}
		}

		return fourFactions;
	}
	/**
	 * 
	 * 이 구현의 문제점
	 * 14/46 => 1/6
	 * 25/85 => 5
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	
	public static String findCommonNum(int a, int b){
		String sa10 = (""+a).charAt(1)+"";
		String sb10 = (""+b).charAt(1)+"";
		
		String sa1 = (""+a).charAt(0)+"";
		String sb1 = (""+b).charAt(0)+"";
		
		String commonN = "";
		
		if(sa1.equals(sb10)){
			commonN = sa1;
		}else if(sb1.equals(sa10)){
			commonN = sb1;
		}
		
		return commonN;
	}
	
	public static Fraction replaceFraction( int bunja, int bunmo) {
		// bunja : 44, bunmo : 45 -> 4/5
		String commonString = findCommonNum(bunja, bunmo);
		if(commonString.equals("")){
			return new Fraction(0,0);
		}
		int commonNum = util.Uitl.toInteger(commonString);
		
		
		bunja = remove(bunja, commonNum);
		bunmo = remove(bunmo, commonNum);
		return new Fraction(bunja, bunmo);
	}

	public static int remove(int num, int remove) {
		String n  = String.valueOf(num).replaceFirst(remove+"", "");
		return Integer.parseInt(n); 
	}
	
	
	
	/* psudo code(의사코드)
	 * 
	 *List<fraction>fractions = new ArrayList<>();
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * int mina = ;
	 * int maxa 
	 * int maxb
	 * 
	 * for(int a=mina;a <= maxa; a++){
	 *	
	 *	  boolean isPrime = a가 소수인지 
	 *
	 *	  for(int b=a+1;b<=maxb;b++){
	 *		if(!(a와 b가 모두 prime number|| a와 b가 모두 10의 배수)){
	 *			if ( fraction(a,b)가 non trivial) {
	 *             찾았음. fractions에 추가함.
	 *          }	
	 *		}
	 *	 } 
	 * 
	 * } 
	 * 
	 * 
	 * 
	 * 
	 */
}
