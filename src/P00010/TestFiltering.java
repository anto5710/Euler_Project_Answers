package P00010;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestFiltering {

	@Test
	public void test() {
		ArrayList<Integer> nums = new ArrayList<>();
		for ( int i = 2; i <= 10000 ; i++ ) {
			nums.add(i);
		}
		assertEquals ( 9, nums.size());
		System.out.println(nums);
		assertEquals ( 5, nums.size());
	}

}
