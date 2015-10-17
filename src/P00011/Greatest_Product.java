package P00011;

import java.io.PrintStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
"01 02 03 04 05  "
"06 07 08 09 10 "+
"11 12 13 14 15 "+
"16 17 18 19 20 "+
"21 22 23 24 25 ";

	 
"01 02 03 04 05"   -> max0
"06 07 08 09 10"   -> max1
"11 12 13 14 15"   -> max2
"16 17 18 19 20"
"21 22 23 24 25"
"01 06 11 16 21"
..
"05 10 15 20 25"
"01"
"02 06"
"03 07 11"
...
"05 09 13 17 21"
...
"25"
"05"
"04 10"
..
"01 07 13 19 21"
..
"21"                 maxN-1




 * @author anto5710
 *
 */
public class Greatest_Product {
	/*
	 * N 개라고 할때 K개씩 묶었을때 전체 반복 횟수는 얼마가 될 것인가?
	 * 1. N = 20 , K=1 => LOOP: 20
	 * 2. N = 20,  K=2 => LOOP: 19
	 * ..
	 * ..
	 * 
	 * LOOP = N - K + 1
	 * 
	 */
	static String source =
			"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "+
			"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "+
			"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "+
			"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "+
			"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "+
			"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "+
			"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "+
			"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "+
			"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "+
			"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "+
			"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "+
			"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "+
			"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "+
			"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "+
			"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "+
			"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "+
			"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "+
			"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "+
			"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "+
			"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48 ";
	static int ARR_LENTH = 20;
	// 행(row), 열(column, col)
//	static String source =
//				   "01 02 03 04 05  "
//			     + "06 07 08 09 10 "+
//			       "11 12 13 14 15 "+
//			       "16 17 18 19 20 "+
//			       "21 22 23 24 25 ";
	
	static int [][] array  = new int[ARR_LENTH][ARR_LENTH];
	

	public static void main(String[]args){
		put(source , array);
		
		int CurrentResult = 0;
		int result = 0;
		int rowMax = 0, colMax = 0;
		for(int irow = 0 ; irow< ARR_LENTH ; irow++){
			
			for(int icol = 0; icol< ARR_LENTH;icol++){
				
//				getUpDown(array, length , x , y );
				List<Integer> list = getLineProductions(array, 4, irow, icol);
				CurrentResult =findMax(list);
				if(CurrentResult> result){
					result = CurrentResult;
					rowMax = irow;
					colMax = icol;
				}
				
			}
			
		}
		
		System.out.println(result+" at "  + rowMax + ", " + colMax);
	}

	private static int findMax(List<Integer> list) {
		int result = 0;
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			int index = iterator.next();
			if(index>result){
				result= index;
			}
		}
		return result;
	}

	/**
	 * 행렬의 대각선 방향에서 최대값을 구하는 메소드.
	 * 
	 * 
	 * int [][] arry = {
	 *  	{1 1 1 1 1 1}, 
	 *  	{1 1 1 1 1 1}
	 *  	{1 1 1 1 1 1}
	 *  };
	
	 *  A B C D E F
	 *  G H I J K L
	 *  M N O P Q R
	 *  S T U V W X
	 *  Y Z @ # $ %
	 *  [ 5 x 6 ] 
	 *  
	 *   C(X:0, Y =2) 
	 *  [ 3 x 5 ] nRow: 3, nCol : 5
	 *  
	 *    O(X,Y)
	 *X    *------ R  OR 
	 *   / |\
	 * /   |  \
	 S     C   B
	OS    OC    OB
	 *     
	 * A 
	 * 
	 *    Y
	 *    ^  x1, x2, x3
	 *  y |          
	 *    |    
	 *    |    
	 *    |       
	 *    +------------> X
	 *  (0,0)
	 *  
	 *    {
	 *    * ---------> Y
	 *    | { .... },
	 *    | { .....},
	 *    v { .....},
	 *    X { .....},
	 *    }
	 * @param array
	 * @param index
	 */
	public static ArrayList<Integer> getLineProductions(int[][] array, int length,int irow , int icol) {
		ArrayList<Integer> localList  = new ArrayList<>();
		int nRow = array.length;    // X
		int nCol = array[0].length; // Y
		
		int result = 1;
		System.out.println(irow +" :: " + length + " :: "+ nRow);
		// 선분 OR
		if( icol + length <= nCol  ){
			for(int num = 0; num < length ; num++){
				result*= array[irow][icol+num];
			}
			localList.add(result);
		}
		result = 1;
		// 선분 OC
		if( irow + length <= nRow ){
			for(int num = 0 ; num < length ;num++){
				result*= array[irow+num][icol];
			}
			localList.add(result);
		}
		result = 1;
		// 선분 OB
		if ( (irow+length<=nRow) && (icol+length<=nCol)  ) {
			for(int num = 0 ; num < length ;num++){
				result*= array[irow +num][icol+num];
			}
			localList.add(result);
		}
		result = 1;
		//선분 OS
		if ( ( icol +1 >= length ) && (irow + length <= nRow )  ) {
			for(int num = 0 ; num < length;num++){
				result*= array[irow + num][icol - num];
			}
			localList.add(result);
		}
				
		return localList;
		
	}

	/**
	 * 행렬의 가로방향에서 최대값을 구하는 메소드.
	 * @param array - 조사할 배열.
	 * @param legnth - 곱할 숫자의 갯수
	 * @param rowIndex - 배열에서 행의 인덱스
	 * @param colIndex - 배열에서 열의 인덱스
	 */
	private static int getLine(int[][] array, int legnth,int rowIndex, int colIndex ) { // X:4, Y:4
		// ARRAY[X][Y], (ARRAY[X+1][Y]  || ARRAY[X-1][Y])
		int result = 1;
		
			for(int iy = colIndex-1 ;iy-1>=0;iy--){
				int num=	array[rowIndex][iy];
				result*=num;
			}
			return result;
	}

	/**
	 * 행렬의 세로 방향에서 최대값을 구하는 메소드.
	 * @param array
	 * @param index
	 * @return 
	 */
	private static int getUpDown(int[][] array, int legnth,int rowIndex, int colIndex ) {
	
		int result = 1;
		for(int ix = rowIndex=1; ix-1>=0; ix--){
				int num = array[ix][colIndex];
				result*=num;
			}
		
		return result;
	}


	public static void print (int[][] array, PrintStream out) {
		String printresult = "";
		for(int x = 0 ; x< ARR_LENTH ; x++){
			printresult = "";
			for(int y = 0; y< ARR_LENTH;y++){
				printresult = printresult+array[x][y]+" ";
			}
			out.print(printresult+"\n");
		}
		
	}


	private static void put(String source, int[][] array) {
		Scanner sc = new Scanner(source);
//		sc.nextInt();
		for(int x = 0 ; x< ARR_LENTH ; x++){
			for(int y = 0; y< ARR_LENTH;y++){
				array[x][y] = sc.nextInt();
			}
		}
	}
}
