package P0024;

import util.Uitl;

/**
 * 순열에서 각각의 노드를 나타냅니다.
 * 
 * 
 * @author anto5710
 *
 */
public class Pnode {

	private Pnode parent ;
	
	private long offset;
	private long length;
	private String nums;
	private String current;
	

	public Pnode(String current, String nums, long offset ) {
		this.offset = offset;
		this.nums = nums.trim(); // " dd d   " -> "dd d"   space , tab, enter 
		this.current = current;
		
		int size = nums.length();
		this.length = util.Uitl.getFactorial(size);
	}

	public long getLength() {
		return this.length;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Pnode find(int index) {
		if(this.offset == index ){
			return this;
		}
		long nextLength = util.Uitl.getFactorial(nums.length()-1); // 2! x 3 
//		System.out.println("여기오냐?");
		for(int i = 0; i <nums.length();i++){
			String nextCurrent = "" + this.nums.charAt(i); // index 가 아니라 index위치의 character를 붙였어야 함.
			String nextNums= nums.replace(nextCurrent, "");
			Pnode child = new Pnode( this.current + nextCurrent, nextNums, this.offset + i * nextLength);
			if(child.offset<=index && index< (child.offset + nextLength)){
				System.out.println("다음 자식 : " + child);
				return	child.find(index);
			}
			
		}
		return null;
	}

	public String getCurrent() {
		return this.current;
	}

	@Override
	public String toString() {
		return String.format("[%d:%d, cur:%s, nums:%s]", offset, length, current , nums);
	}

	public String getNums() {
		return nums;
	}
	
	
}
