package P0025;

import util.BigInt;


public class P0025main {
	public static void main(String[]args){
		int idx = getIndex(2);
		System.out.println("7 : " + idx);
		System.out.println("12 : " + getIndex(3));
		System.out.println("answer : " + getIndex(1000));
	}
	
	
	
	public static int getIndex(int digit  ){
		String fn_1 ="1";
		String fn_2 = "1";
		String cur = "0";
		int index =2;
		while(cur.length()<digit){
			cur = BigInt.add(fn_1, fn_2);
			fn_2 = fn_1;
			fn_1 = cur;
			index++;
			
		}
		return index;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
