package P0018;

import java.io.PrintStream;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

/**
 * 
 * 
 *      A
 *     B C
 *    D E F
 *   G H I J
 *   
 *  위와 같은 모양의 숫자 트리를 나타내는 클래스입니다.
 * @author anto5710
 *
 */
public class NumTree {

	private int [][] srcArray ;
	
	
	public NumTree ( String src, int rowSize ) {
		init ( src, rowSize) ;
	}
	
	public void printSourceTree ( PrintStream out) {
		String result = "";
		for(int irow = 0 ; irow<srcArray.length ; irow++){
			
			for(int icol = 0; icol<srcArray[irow].length ;icol++){
				String num = srcArray[irow][icol]+"";
				
				result+=num + " ";
			}
			result+="\n";
		}
		out.println(result);
	}


	private void init(String src, int rowSize) {
		Scanner scanner =  new Scanner(src);
		int[][] array = new int[rowSize][ ];
		int col = 1;
		for(int irow = 0 ; irow<rowSize ; irow++){
			array[irow]= new int[col];
			for(int c = 0; c <col ;c++){
				int num = scanner.nextInt();
				array[irow][c]=num;
			}
			col++;
		}
		this.srcArray = array;
		scanner.close();
	}

	public int getValue(int irow, int icol) {
		int result  = 0;
		if( this.srcArray.length>irow&&irow>=0 && 
				this.srcArray[irow].length>icol&&icol>=0 ){
			result = this.srcArray[irow][icol];
		}
		return result;
	}
	
	/**
	 * 주어진 위치(irow, icol)에 값을 누적해서 더해줍니다.
	 * @param irow
	 * @param icol
	 * @param value
	 */
	public void addTo(int irow, int icol, int value) {
		if( this.srcArray.length>irow&&irow>=0 && 
				this.srcArray[irow].length>icol&&icol>=0 ){
			srcArray[irow][icol]= srcArray[irow][icol]+value;
		}
	}
	
	public void setValueof(int irow , int icol , int value){
		if( this.srcArray.length>irow&&irow>=0 && 
				this.srcArray[irow].length>icol&&icol>=0 ){
			this.srcArray[irow][icol]= value;
		}
	}
	public int[] getNums(int irow){
		if( this.srcArray.length>irow&&irow>=0 ){
			return this.srcArray[irow];
		}
		return null;
	}
	
	/**
	 * 주어진 위치의 왼쪽 부모 값 반환합니다.
	 * @param irow
	 * @param icol
	 * @return
	 */
	public int leftParent(int irow, int icol) {
		return getValue(irow-1, icol-1);
	}
	/**
	 * 주어진 위치의 오른쪽 부모의 값을 반환합니다.
	 * @param irow
	 * @param icol
	 * @return
	 */
	public int rightParent(int irow, int icol) {
		return getValue(irow-1, icol);
	}

	/**
	 * 숫자 트리의 높이를 반홯납니다.
	 * @return
	 */
	public int getHeight() {
		return this.srcArray.length;
	}
	public int getMaxCol(int irow){
		return this.srcArray[irow].length;
	}

}
