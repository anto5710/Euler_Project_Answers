package P0026;

import java.util.ArrayList;
import java.util.List;

public class P0026main {
	public static void main(String[]args){
		int currentLength= 0;
		int currentNum = 0;
		for(int n = 3 ; n< 1000 ; n++){
			int lenght = getRecurring_Cycle(1, n).size();
			if(currentLength<lenght){
				currentLength = lenght;
				currentNum = n;
				System.out.println("순환마디 길이 : " +lenght);
			}
		}
		System.out.println(currentNum);
	}
	/**
	 * 순환소수 마디를 구해서 반환합니다.
	 * 
	 * @param n
	 * @param divider
	 * @return
	 */
	
	public static List<Integer> getRecurring_Cycle(int n , int divider){
		int N = n;
//		}
		ArrayList<Integer> Rlist = new ArrayList<>();
		ArrayList<Integer> Qlist = new ArrayList<>();
		int R = n;
		int Q = 0;
		while(R !=0){
			Q = N/divider;
			R = N%divider;
			
			if(Rlist.contains(R)){
				
				break;
			}
			Rlist.add(R);
			
			N=R*10;
			Qlist.add(Q);
		}
		int nDel = Rlist.indexOf(R); // 미리 받아둬야 합니다. 왜일까요?
		for(int index =  0; index < nDel; index++){
			Rlist.remove(0);
		}
		return Rlist;
	}
	
	
	
	
	
}
