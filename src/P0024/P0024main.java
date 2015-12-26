package P0024;

import java.util.ArrayList;
import java.util.Arrays;

public class P0024main {
	static int endAt = 1000000;
	public static void main(String []args){
		ArrayList<String>list = new ArrayList<>();
		ArrayList<Integer>nums = new ArrayList<>(Arrays.asList(0 , 1, 2 , 3 , 4 , 5 , 6, 7, 8, 9));
		/**
		 * 일단 전부 다 구해놓고나서 찾는 방식입니다.
		 */
		permutate(list,"", nums );
		
		System.out.println("[Size]: "+list.size());
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param answers
	 * @param nums
	 */
	public static ArrayList<String> permutate(ArrayList<String>answers, String current,ArrayList<Integer>nums ){
		
		if(nums.isEmpty()){
			
			answers.add(current);
			if(answers.size()-1==endAt){
				System.out.println(answers.get(endAt-1));
				
			}
		}
		
		for(int index = 0; index < nums.size() ; index++){
			
			ArrayList<Integer>clone =new ArrayList<>(nums);
			clone.remove(index);
			
			String string = current+nums.get(index);                
			
			permutate(answers, string ,clone);
			
		}
		return answers;
		
	}
}
