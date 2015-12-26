package P0025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(10);
		ints.add(8);
		ints.add(34);
		ints.add(20);
		ints.add(82);
		ints.add(8);
		System.out.println("before: " + ints);
		
		// 내림 차순 정렬
		Collections.sort(ints, new Comparator<Integer>() {

			/* (( 오름차순으로 정렬함. ascending ))
			 * 
			 * compare (o1 : 10,  o2 : 33)
			 *  o1이 잎에 와야함 - return o1 - o2 ; 0보다 작은 값을 반환해야함.
			 * 
			 * (( 내림 차순 : descending ))
			 * compare (o1 : 10,  o2 : 33)
			 *  return o2-o1;
			 *
			 */
			@Override
			public int compare(Integer o1, Integer o2) {
				/*
				 * o1이 o2보다 우선 순위가 높으면0보다 작은 값을 반환!!
				 * 
				 * 그게 아니라,o2가 o1보다 우선순위가 높으면 0보다 큰 값을 반환!!
				 * 
				 * o1과 o2가 똑같으면 0을 반환!!!
				 * 
				 */
				System.out.println("o1: " + o1 + ", o2: " + o2);
				return o2-o1;
			}
		});
		
		System.out.println("descending: " + ints);
		
		List<String> names = new ArrayList<>(Arrays.asList("Bill Gates", "Obama", "Jame", "Jack", "Mike", "Kim"));
		System.out.println("before: " + names);
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int result = o1.length()-o2.length();
				if(result ==0){
					result = o1.compareTo(o2);
				}
				return result;
			}
		});
		
		System.out.println("오름차순: " + names);
		
		// 1. 이름이 가장 짧은 사람
		// 2. 이름 길이가 똑같으면 알파멧 순서로...
		// [Kim, Jack, Jane, Mike, Obama, Bill Gates]
		
	}

}