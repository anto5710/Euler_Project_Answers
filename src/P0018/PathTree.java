package P0018;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Current;

public class PathTree {
	
	private char[][]Path_array;
	private  NumTree numTree ;
	public PathTree ( NumTree nTree) {
		init(nTree.getHeight());
		this.numTree = nTree;
	}
	private void init(int height) {
		Path_array = new char[height][];
		int col = 1;
		for(int irow = 0 ; irow<height ; irow++){
			Path_array[irow]= new char[col];
			for(int c = 0; c <col ;c++){
				Path_array[irow][c]='.';
			}
			col++;
		}
		
//		Path_array[1][1] = '.';
		
	}
	public void setParent(int irow, int icol, char put) {
		if( this.Path_array.length>irow&&irow>=0 && 
				this.Path_array[irow].length>icol&&icol>=0 ){
				this.Path_array[irow][icol] = put;
			
		}
	}
	
	public void printPath ( PrintStream out ) {
		String result = "";
		for(int irow = 0 ; irow<Path_array.length ; irow++){
			
			for(int icol = 0; icol<Path_array[irow].length ;icol++){
				String num = Path_array[irow][icol]+"";
				
				result+=num + " ";
			}
			result+="\n";
		}
		out.println(result);
	}
	
	public List<Integer> getPath( int irow, int icol ) {
		List<Integer>list = new ArrayList<Integer>();
		int col = icol;
		int row = irow;
		
//		list.add(numTree.getValue(row, col));
		for(; row>=0;row--){
//			int parent = numTree.rightParent(row, col);
//			if(this.Path_array[row][col]=='L'){
//				parent = numTree.leftParent(row, col);
//				col-=1;
//			}
//			list.add(parent);

			list.add(numTree.getValue(row, col));
			char dir = this.Path_array[row][col];
			if ( dir == 'L') {
				col--;
			}
			
		}
		
		return list;
	}
	
//	public static class Index {
//		public int row, col;
//		public Index( int r, int c) {
//			row = r;
//			col = c;
//		}
//		public char getValue() {
//			return 
//			return 0;
//		}
//	}
}
