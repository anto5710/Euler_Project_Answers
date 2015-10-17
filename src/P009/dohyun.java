package P009;

public class dohyun {
	
	static int max =1000;

	
	
	public static void main (String[]args){
		int MaxOfB = max/2;
		// 조건 0 : a > 0 , b > 0, c > 0
		
		// 조건 1 :  a < b < c
		// 조건 2 : a*a + b*b = c*c
		// 
		// 조건 3 : a + b + c = 1000
		// a , b ,c <= 998
		
		// 가장 무식한 방법으로 풀어봤습니다.
		for(int a = 2; a<= max; a++){ // a: 999
			 for(int b = a+1; b <=MaxOfB; b++){ // b:996
				 int c =max- a - b;
				 if ( c < b ){
					 break;
				 }
				 // c:995
					 if(a*a+b*b == c*c&& a<b&&b<c){
						System.out.println("A:" +a+" B: "+b+ " C: "+c+" Product: "+a*b*c);
						
					 }
				 
			 }
		}
	}
}
