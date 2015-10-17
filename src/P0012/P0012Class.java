package P0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class P0012Class {
	static int DivisorCount = 500;
	public static void main( String[]args){
		System.out.println(getNum(DivisorCount));
	}
	
	public static int getNum(int FirstNumsDivisor){
		int num = 1;
		int sumNum = 2;
		int nDivisors = 0;
		 while(countDivisors(num) < FirstNumsDivisor){
			 num+= sumNum;
			 sumNum++;
			 nDivisors = countDivisors(num);
			 System.out.println(String.format("%d divisors of num %d", nDivisors, num));
		 }
		 return num;
		
	}
	/**
	 * Num:12 [2,2,3] = (1, 2, 3, 4, 6, 12)
	 * 2^2
	 * 3^1
	 * (2+1)*(1+1)=6개 
	 * @param Num
	 * @return
	 */
	public static int countDivisors(int Num){
		int result = 1;
		List<Integer>primes = getPrimeNums(Num);
		HashMap<Integer, Integer>primeMap = getCount(primes);
		for(int prime : primeMap.keySet()){
			int count = primeMap.get(prime);
			result *= count+1;
		}
		return result;
	}

	public static HashMap<Integer, Integer> getCount(List<Integer> primes) {
		HashMap<Integer, Integer>map = new HashMap<>();
		Iterator<Integer> iterator = primes.iterator();
		while(iterator.hasNext()){
			int Num = iterator.next();
			if(map.containsKey(Num)){
				map.put(Num, map.get(Num)+1);
			}else{
				map.put(Num, 1);
			}
		}
		return map;
	}

	public static ArrayList<Integer> getPrimeNums(int num) {
		int a  = 2;
		ArrayList<Integer> ListPrimes = new ArrayList<>();
		if(isPrime(num)){
			ListPrimes.add(num);
			
		}else{
			while(!isPrime(num)){
				if(num%a==0){
					ListPrimes.add(a);
					num = num/a;
					if(isPrime(num)){
						ListPrimes.add(num);
						break;
					}
				}
				else{
					//while(isPrime(a)&&(num%a+1)==0){
						a++;
					//}
					
				}
			}
		}
		return ListPrimes;
	}
	
	public static  boolean isPrime(final int number) {
		if (number == 2) {
			return true;
		}
		if ( number % 2 == 0 ) {
			return false;
		}
		
		int upperBound = (int) Math.sqrt(number);
		for (int i = 3; i <= upperBound; i+=2 ) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
