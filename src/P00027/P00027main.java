package P00027;

import java.util.ArrayList;
import java.util.List;

public class P00027main {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		long answer = getQuardN();
		long end = System.currentTimeMillis();
		
		System.out.println("answer: " + answer + ", " + (end-start)/1000.0 + "sec");
	}
	public static long getQuardN ( ){
		int A = 0 ;
		int B = 0 ; 
		int m = 0 ;
		//집에서 해봅시다.
		//1000이하의 소수들을 구한 뒤 , b 값으로차례로 넣어줍니다.
			for(int b = 2 ; b< 1000 ; b+=1){
				
				for(int a = - 999 ;a< 1000; a +=2){
				int size = countPrimes(a, b);
				if(size>m){
					m = size;
					A = a;
					B = b;
				}
			}
		}
		System.out.println("a : " + A  + ", b : " + B + ", size: " + m );
		return A*B;
	}
	
	public static int countPrimes(int a , int b){
//		List<Integer>primeNums = new ArrayList<Integer>();
		int n = 0; 
		while(util.Uitl.isPrime(n*n +a*n+b)){
			n++;
			
		}
		return n;
		
	}
	

}
