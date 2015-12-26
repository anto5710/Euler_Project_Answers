package P00028;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 	    21 22 23 24 25 26
 * 		20 07 08 09 10 27	
 * 		19 06 01 02 11 28
 * 		18 05 04 03	12 29
 * 		17 16 15 14 13 30
 *      36 35 34 33 32 31       
 * 
 * 
 */
public class P00028main {
	
	public static void main(String[]args){
		List<Integer> list = getDiagonals(1001);
		long sum =util.Uitl.getSumOfNumbers(list);
		System.out.println("[List] "+list);
		System.out.println("[Sum] "+sum);
	}
	public static List<Integer> getDiagonals(int max_size){
		List<Integer>diagonals = new ArrayList<Integer>();
		diagonals.add(1);
		int n= 1;
		int c = 0;
		for(int size = 2 ; size < max_size ; ){
			n+=size; 
			diagonals.add(n);
			c++;
			if(c==4){
				size+=2;
				c = 0;
			}
		}
		System.out.println("N: " + n);
		return diagonals;
	}
}
