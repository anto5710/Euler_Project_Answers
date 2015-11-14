package P0018;

public class P0018_main {
//	static String source = "75 "+
//			"95 64 "+
//			"17 47 82 "+
//			"18 35 87 10 "+
//			"20 04 82 47 65 "+
//			"19 01 23 75 03 34 "+
//			"88 02 77 73 07 63 67 "+
//			"99 65 04 28 06 16 70 92 "+
//			"41 41 26 56 83 40 80 70 33 "+
//			"41 48 72 33 47 32 37 16 94 29 "+
//			"53 71 44 65 25 43 91 52 97 51 14 "+
//			"70 11 33 28 77 73 17 78 39 68 17 57 "+
//			"91 71 52 38 17 14 91 43 58 50 27 29 48 "+
//			"63 66 04 68 89 53 67 30 73 16 69 87 40 31 "+
//			"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ";
//	static int max_row = 15;
	static String source = "   3 "
			+ " 7 4 "
			+ " 2 4 6 "
			+ "8 5 9 3";
	static int max_row = 4;
	public static void main(String []args){
//		int [][] srcArray = makeArray(source, max_row);
//		int [][] Array = new int[max_row][];
//		print(srcArray );
		
		NumTree sum_tree = new NumTree(source, max_row);
		NumTree tree = new NumTree(source, max_row);
		
		tree.printSourceTree(System.out);
		
		System.out.println("value at (0, 0) : " + tree.getValue ( 0, 0 ) );
		System.out.println("value at (2, 2) : " + tree.getValue ( 2, 2 ) );
		System.out.println("value at (2, 2) : " + tree.getValue ( 2, 2 ) );
		System.out.println("value at (2, 3) : " + tree.getValue ( 2, 3 ) );
		System.out.println("value at (1,-1) : " + tree.getValue ( 1, -1 ) );
		
		System.out.println("left parent : " + tree.leftParent(1, 1));
		System.out.println("rigfht parent : " + tree.rightParent(1, 1));

		System.out.println("left parent of(3,2) : " + tree.leftParent(3, 2));
		System.out.println("rigfht parent of(3,2): " + tree.rightParent(3, 2));
		
		System.out.println("height of tree: " + tree.getHeight());
		
//		tree.addTo(2, 2, 10);
//		System.out.println("add 10 to (2, 2):  " + tree.getValue(2, 2) );
		
		PathTree ptree = new PathTree(tree);
		for ( int irow = 0 ; irow < sum_tree.getHeight(); irow++) {
			int max_col = sum_tree.getMaxCol(irow);
			for(int icol = 0 ; icol<max_col; icol++){
				char put = 'L';
				int maxParent = sum_tree.leftParent(irow, icol);
				if(sum_tree.rightParent(irow, icol)>maxParent){
					put = 'R';
					maxParent = sum_tree.rightParent(irow, icol);
				}
				sum_tree.addTo(irow, icol, maxParent);
				ptree.setParent(irow , icol , put);
			}
		}
		tree.printSourceTree(System.out);
		System.out.println(getBiggest(tree.getNums(max_row-1)));
		ptree.printPath(System.out);
		System.out.println(ptree.getPath(3, 2));
		
	}
	/*
	private static void print(int[][] srcArray) {
		String result = "";
		for(int irow = 0 ; irow<srcArray.length ; irow++){
			
			for(int icol = 0; icol<srcArray[irow].length ;icol++){
				String num = srcArray[irow][icol]+"";
				
				result+=num + " ";
			}
			result+="\n";
		}
		System.out.println(result);
	}

	public static int[][] makeArray ( String source, int rowSize) {
		Scanner scanner =  new Scanner(source);
		int[][] array = new int[rowSize][ ];
		int col = 1;
		for(int irow = 0 ; irow<rowSize ; irow++){

			array[irow]= new int[col];
			
			for(int c = 0; c <col ;c++){
				int num = scanner.nextInt();
//				System.out.println( "is null? " + (array[irow] == null) ); 
				array[irow][c]=num;
			}
			col++;
			
		}
		return array;
	}
	*/
	
	public static int getBiggest(int[]array){
		int result = 0;
		for(int i = 0; i <array.length ; i++){
			if(array[i]>result){
				result = array[i];
			}
		}
		return result;
	}
}
