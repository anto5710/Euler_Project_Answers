package util;

import java.math.BigInteger;

/**
 * 아주 큰 수를 더하거나 곱하는데 사용하려고 만들었습니다.
 * 
 * @author anto5710
 *
 */
public class BigInt {

	/**
	 * 
	 * @param na
	 * @param nb
	 * @return
	 */
	public String add(String na, String nb  ) {
	BigInteger d = BigInteger.TEN;
		String result = "";
		int carry = 0;
		na = reverse (na);
		nb = reverse (nb);
		int index  = 0;
		
		while(index<=na.length()-1 || index <=nb.length()-1){
			String Current_na = "";
			String Current_nb = "";
			if(na.length()-1>=index){
				 Current_na = ""+na.charAt(index);
			}
			if(nb.length()-1>=index){
				 Current_nb = ""+nb.charAt(index);
			}
			
			if(Current_na!=null&&Current_nb!=null){
				int Num_na = 0 ;
				if(Current_na!=""){
				Num_na = Integer.parseInt(Current_na);
				}
				int Num_nb = 0;
				if(Current_nb!=""){
				Num_nb = Integer.parseInt(Current_nb);
				}
				int sum =Num_na+ Num_nb+carry;
				carry = 0;
				if(sum>=10){
					carry = sum/10;
					sum = sum - 10*carry;
				}
				result +=sum;
			}
			index++;
			
		}
		String final_String = result;
		if(carry>0){
			final_String = final_String+carry;
		}
		return reverse(final_String);
		
	}

	public String multipy(String sa, String sb  ) {
		String result = "0";
		String CurrentResult = "";
		int carry = 0;
		sa = reverse (sa);
		sb = reverse(sb);
		
		int naSize = sa.length();
		int nbSize = sb.length();
		for(int indexSb = 0; indexSb <nbSize ; indexSb++){
			CurrentResult = fill( "0", indexSb); //"";
			int nb = intAt ( sb, indexSb); //toInteger(Currentnb);
			
			for(int indexSa = 0; indexSa < naSize ; indexSa++){
				
				int na = intAt ( sa, indexSa); // toInteger(Currentna);
				
				int naXnb = na*nb;
				naXnb +=carry;
				
				carry = naXnb/10;
				naXnb = naXnb%10;
				
				CurrentResult+=naXnb ;
			}
			if(carry>0){
				CurrentResult+=carry;
				carry = 0;
			}
			
			result = add(reverse(result), reverse(CurrentResult));
			result = reverse(result);
		}
		
		
		
		
		
		return result = reverse(result);
		
	}

	/**
	 * 주어진 문자열을 n개 결합한 새로운 문자열로 만들어서 반환합니다.
	 * @param string
	 * @param n
	 * @return
	 */
	private String fill(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < n ; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

	private int intAt(String s, int idx) {
		char ch = s.charAt(idx);
		return ch - '0';
	}

	/**
	 * toInteger("d3");
	 * @param string
	 * @return
	 */
	public int toInteger(String string) {
		int num = 0;
		try {
			num = Integer.parseInt(string);
			return num;

		} catch (NumberFormatException e) {
			throw new RuntimeException("not a number: " + string , e);
		}
	}

	/**
	 * 주어진 문자열을 뒤집어서 반환합니다.
	 * ex) reverse("123") returns "321"
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String result = "";
		for(int index  = string.length()-1 ; index >=0 ; index-- ){
			result = result + string.charAt(index);
		}
		return result;
	}
}
