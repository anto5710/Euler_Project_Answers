package P0014;



public class P0014Main {
	static int Num = 1_000_000;
	static int LargestCount = 0;
	static int LargestNum = 0;
	
	public static void main(String[]args){
		for(;Num>1 ; Num--){
			int num = Num;
			int Currentcount =getCount(num);
//			System.out.println(Num+"{Count}: "+Currentcount);
			if(Currentcount>LargestCount){
				LargestCount = Currentcount;
				LargestNum = Num;
				System.out.println(LargestNum + "  Count: "+ LargestCount);
			}
			
		}
		System.out.println(LargestNum + "  Count: "+ LargestCount);
	}
	/**
	 * 주어진 수가 1로 수렴할때까지 등장하는 Collatz Sequence의 갯수를 반환합니다.
	 * ex) getCount(8) : 4를 반환합니다.
	 *     getCount(45): 6을 반환합니다.
	 * @param num
	 * @return
	 */
	public static int getCount(long num) {
		
		int count = 1;
	
		while(num>1){
			if(num%2==0){
				num = sum_Even(num);
				count ++;
//				System.out.println("D"+num);
			}else {
				num = sum_Odd(num);
				count ++;
//				System.out.println("D"+num);
			}
		}
//		System.out.println("Count"+ count);
		return count;
	}

	public static long sum_Odd(long Num) {
		if ( Num*3 + 1 < Num ) {
			throw new RuntimeException("overflow!!!!! : 3n+1 = " + Num*3+1 + " of " + Num);
		}
		
		return Num*3 + 1;
	}
	public static long sum_Even(long Num){
		return Num/2;
	}
}
