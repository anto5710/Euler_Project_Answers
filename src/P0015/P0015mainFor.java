package P0015;

import java.util.HashMap;
import java.util.Map;

/**
 *     (2x3)
 *     
 *        T02
 *         | 
 *START c0 v c1  c2
 *   T0+---+---+---+
 *  r0 |   |   |   |    
 *  T01+---*---+---+
 *  r1 |   |   |   |
 *     +---+---+---+ END
 *     
 *     int [][] arr = new int [3,4];
 *     [n][0] = 1;
 *     [0][m] = 1;
 *     
 *     
 *         1
 *     1---1---1---1
 * 	   |   |   |   |    
   1   1-- 2---3---4
 * 	   |   |   |   |
 * 1   1---3---6---10 END
 *    
 *    

 * @author anto5710
 *
 */
public class P0015mainFor {
	/**
	 * 한 번 계산한 [ R..][C..]의 경로값을 맵에 저장해둡니다.
	 * 그러면 다음번에 또 동일한 경로를 방문했을때 다시 경로를 계산하러 재귀호출을 할 필요가 없습니다.
	 * (memoization - 메모해두기 )
	 * 
	 */
	HashMap<String, Integer> memoMap =new HashMap<>();
	static long Count = 1;
	static int row = 20;
	static int col = 20;
	static long[][]array = new long[row+1][col+1];
	
	public static void main (String []args){
		
		routes(Count,array.length, array[0].length);
//		printArray ( array);
		System.out.println(row+"x"+col+  " = "+Count);
		
//		routes(Count, 2, 3);
//		System.out.println("2x3 = " + Count); // 6
	}
	private static void printArray(int[][] array2) {
		System.out.println("====print array===");
		for ( int ir = 0 ;ir < array2.length; ir++ ) {
			for ( int ic = 0 ; ic < array2[ir].length; ic++) {
				System.out.print(array2[ir][ic] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	public static void routes(long count,int R , int C){

		for(int R_index = 0; R_index <R ; R_index++){
			for(int C_index = 0; C_index <C ; C_index++){
				long put = 1;
				if(R_index>0&&C_index > 0){
					
					
				
					long Up_Num = array[R_index-1][C_index];
					long leftNum = array[R_index][C_index-1];
					put = Up_Num + leftNum;
				}
				array[R_index][C_index] = put;
			}
		}
		Count = array[row][col];
	}
}
