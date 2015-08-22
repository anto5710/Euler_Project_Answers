package P006;

public class dohyun {
	
	public static void main(String []args){
		// 1.1에서 N까지의 제곱의 합을 구하기 getSumOfPow(N); 
		int value = 100;
	      int squarenumberofall = getSumOfPow( value); // 1 + 4 + 9 
	      int squaretotal =  getPowOfSum(value);
	      int TotalResult = squaretotal-squarenumberofall;
	      System.out.println(squarenumberofall); // 14
	      System.out.println(TotalResult);
	}

	private static int getPowOfSum(int value) {
		int result = 0;
		for(int cnt = 1 ;cnt<=value;cnt++){
			result +=cnt;
		}
		// TODO Auto-generated method stub
		System.out.println("Result: "+result);
		return result*result;
	}

	private static int getSumOfPow(int N) {
		int result = 0;
		for(int v = 1 ; v<=N; v++){
			result+=v*v;
		}
		return result;
	}
	
	
}
