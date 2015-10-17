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
 *         1
 *     1---1---1---1
 * 	   |   |   |   |    
   1   1-- 2---3---4
 * 	   |   |   |   |
 * 1   1---3---6---10 END
 *    
 *    
 *    routes ( [r0, r1], [c0, c1, c2] ) ----- T0
 *        routes([r1], [c0, c1, c2] )   ----- T01
 *          	routes( [], [c0 ,c1 ,c2]);--- T010
 *                  routes(xxxxx)
 *                  routes([], [c1, c2])  --- T0101
 *    		    routes([r1] , [c1 c2]);  ---  T011
 *              
 *        routes([r0 ,r1], [ c1 , c2 ]) ------T02
 *             routes([r1], [c1, c2])   ------T020
 *             routes([r0, r1], [c2])    -----T021
 *        
 *        
 *        routes( [], [c0 , c1 ,c2])
 *    
 *     routes ( 2, 3)   --- T0
 *          routes(1, 3)
 *          routes(2, 2)
 *    
 *  [c0 c1 c2 r0 r1]
 *  [r0 r1 c0 c2 c2]
 *  
 *   [a, b, c]
 *   
 *   abc
 *   acb
 *   bac
 *   bca
 *   cab
 *   cba
 * @author anto5710
 *
 */
public class P0015main {
	/**
	 * 한 번 계산한 [ R..][C..]의 경로값을 맵에 저장해둡니다.
	 * 그러면 다음번에 또 동일한 경로를 방문했을때 다시 경로를 계산하러 재귀호출을 할 필요가 없습니다.
	 * (memoization - 메모해두기 )
	 * 
	 */
	HashMap<String, Integer> memoMap =new HashMap<>();
	static int Count = 1;
	public static void main (String []args){
		
		routes(Count,2, 2);
		System.out.println("2x2 = " +Count);
		
//		routes(Count, 2, 3)
//		System.out.println("2x3 = " + ); // 6
	}
	public static void routes(int count,int R , int C){
		/*
	 	 *         [ r  ,r] , [c , c ]
		 *          V	1	V1
		 *       
 		  [r ]1 . [c , c]       [ r , r] [c ]
		 * V         V            V
		 * [r][c]   [][c , c]             [r, r] []
		 *                                        [r,r] [-1]
		 *                                             [r,r] [-2]
		 *                                                 [r,r] [-3]
		 *                                                 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 *     [r , r ] [c , c ]           
		 *    1                 1
		 *   [r, r][ c ]        [r ][c , c]
		 *    1       1             1      1
		 *[r,r][]  [r][c]     [][c,c]   [r][c]
		 *  1           1         1         1
		                  
 		 */
		if(R == 0 || C == 0){
			return ;
		}else{
			routes(Count++, R, C-1);
//^
			routes(Count++, R-1, C);
		}

	}
}
