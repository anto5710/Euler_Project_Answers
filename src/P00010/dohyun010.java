package P00010;

import java.util.ArrayList;
import java.util.Iterator;

public class dohyun010 {
	
	static int max = 2000000; // 2, 3, 5, 7 , 11 , 13 , 17 , 19
	static ArrayList<Integer>list = new ArrayList<>() ;
	
	public static void main(String []args){
		put(list, max);
		// 1. 2에서 N까지 채워넣음.
	
		// 2. 에라토네스의 체로 걸러
		
		
		// 3. 이제 소수만 남았겠지?
		System.out.println("result:"+ getSumOfPrimes(max));
	}
	
	/**
	 * 이것은 망한 구현입니다. max가 일정 범위를 넘어서면 너무 오래 걸립니다.
	 * @param max
	 * @return
	 */
	public static long getSumOfPrimes(int max){
		long result = 0;
		
		
		for(long num: list){
			result+=num;
			
			}
	
		return result;
	}
	
	/**
	 * 에라토네스의 체!!
	 * @param numList
	 * @param max2
	 */
//	private static void DeleteMethod(ArrayList<Integer> numList) {
//		
//		ArrayList<Integer> clone = new ArrayList<>(numList); 
//		for(int i : list){
//		
//		}
//		
//	
//	}
	/**
	 * 주어진 소수의 2, 3, 4, ... k 배가 되는 모든 수를 list에서 제거합니다.
	 */
//	public static void filtering(ArrayList<Integer> list, int primeNum) {
//		
//		System.out.println("BEFORE: primeNum: " + primeNum + ", " + "filtered: " + list.get(0) + " .... " + list.get(list.size()-1));
////		ArrayList< Integer>clone = new ArrayList<>(list);
//		System.out.println("BEFORE: size of list:  "+list.size());
////		for(int num : list){ // 2, 3, 4, 5, 6, ......., 2_000_000
////			if(num % primeNum==0 ){
////				deleted = num;
////			  clone.remove(deleted);
////			  System.out.println("deleted: " + deleted);
////			}
////		}
//	
//		int multify = 3;
//		while(multify<max){
//			while(list.contains(primeNum*multify)){
//				list.remove(new Integer(primeNum*multify));
//			}
//			multify+=2;
//		}
//		
//		System.out.println("AFTER: size of list: " + list.size() + ", multiply: " + multify);
//		
//	}

	private static ArrayList<Integer> put(ArrayList<Integer> list, int end) {
		list.add(new Integer(2));
		for(int i = 3; i< end; i+=2){
			if(isPrime(i)){
				list.add(i);
			}
		}
		return list;
		
	}
	// 에라토네스틔 체를 구현하면 더 빨리 구할 수 있습니다.
	// List<Intger> nums = [3,  5,  ....... 199999]
	// 

	private static boolean isPrime(int number) {
		int maxDivider=((int) Math.sqrt(number)); // @@@@@ important num:200000,  1000
		for(int divider = 3 ; divider<=maxDivider; divider+=2){
			if(number%divider==0){
				return false;
			}
		}
		
		return true;
	}
}
