package P0013;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 
 *  carry: 1 // 자리올림
 *   "927"
 * +  "86"
 *  ------
 *   1013
 *   
 *    carry: 0
 *          "1"
 *    "9999999"
 *   -----------
 *             
 *   
 *  
 * @author anto5710
 *
 */
public class P0013Main {

	public static void main(String[]args){
		InputStream in = loadInput();
		Scanner sc = new Scanner(in);
		List<String> numbers = new ArrayList<String>();
		while( sc.hasNextLine()) {
			String line = sc.nextLine();
			numbers.add(line);
		}
		sc.close();
		
		solve ( numbers);
	}

	/**
	 * 여기서 풀면 됩니다.
	 * @param numbers - 100개의 숫자가 담긴 리스트
	 */
	public static void solve(List<String> numbers) {
		Iterator<String>itretor  = numbers.iterator();
		String total = "0";
		while(itretor.hasNext()){
			total = add (total, itretor.next());
			System.out.println(":> " + total);
		}
		System.out.println(total);
	}
	
	/**
	 * 
	 * @param na
	 * @param nb
	 * @return
	 */
public static String add(String na, String nb  ) {
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

	public static String multipy(String sa, String sb  ) {
		String result = "0";
		String CurrentResult = "";
		int carry = 0;
		sa = reverse (sa);
		sb = reverse(sb);
		/*
		 * 1  - 1234000
		 * 2  -  123400
		 * 3  -   12340
		 * 4  -    1234
		 */
		/*
		 * 123 x 89
		 * 
		 * na :  3   2   1
		 *  
		 * nb :  9   8 
		 *      [0] [1] [2] [3]
		 */
		int naSize = sa.length();
		int nbSize = sb.length();
		for(int indexSb = 0; indexSb <nbSize ; indexSb++){
			CurrentResult = "";
			for(int c= 0 ; c< indexSb; c++){
				CurrentResult=CurrentResult+"0";
			}
			for(int indexSa = 0; indexSa < naSize ; indexSa++){
				String Currentna = sa.charAt(indexSa)+"";
				String Currentnb = sb.charAt(indexSb)+"";
				
				int na = toInteger(Currentna);
				int nb = toInteger(Currentnb);
				
				int naXnb = na*nb;
				naXnb +=carry;
				
//				if(naXnb>=10){
					carry = naXnb/10;
					naXnb = naXnb%10;
//				}
				
				CurrentResult+=naXnb+"";
			}
			// 7011, 0489
			if(carry>0){
				CurrentResult+=carry;
				carry = 0;
			}
//			System.out.println(CurrentResult);
			
			result = add(reverse(result), reverse(CurrentResult));
			
			result = reverse(result);
			
		}
		
		
		
		
		
		return result = reverse(result);
		
	}

	/**
	 * toInteger("d3");
	 * @param string
	 * @return
	 */
	public static int toInteger(String string) {
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
	public static String reverse(String string) {
		String result = "";
		for(int index  = string.length()-1 ; index >=0 ; index-- ){
			result = result + string.charAt(index);
		}
		return result;
	}

	private static InputStream loadInput() {
		return P0013Main.class.getResourceAsStream("input.txt");
	}
}
