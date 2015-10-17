package P00016;

import P0013.P0013Main;

public class Sum_Of_digits {
	static int roof = 1000;
	public static void main(String[]args){
		String Num = getNum(roof);
		System.out.println(Num);
		getSumOfDigits(Num);
	}
	private static void getSumOfDigits(String Num) {
		long result = 0;
			for(int index = 0;index<Num.length() ; index++){
				result+=P0013Main.toInteger(Num.charAt(index)+"");
			}
			System.out.println(result);
	}
	private static String getNum(int roof) {
//		
		String num ="1";
		for(int c = 0 ; c<roof ; c++){
			num=P0013Main.multipy(num, "2");
		}
		return num;
	}
}
