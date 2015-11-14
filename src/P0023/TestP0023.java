package P0023;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestP0023 {

	@Test
	public void test_getting_divisors() {
		List<Integer> divisors = P0023main.getProper_Divisors(12);
		assertEquals ( 5, divisors.size()); // 1, 2, 3, 4,  6
		assertEquals ( Arrays.asList(1, 2, 3, 4, 6), divisors);
	}
	
	@Test
	public void test_ab_checker() {
		assertTrue ( P0023main.isAbundant_number(12) );
		assertTrue ( P0023main.isAbundant_number(18) ); // 1, 2, 3, 6, 9 = 21
		assertTrue ( P0023main.isAbundant_number(20) );
		assertTrue ( P0023main.isAbundant_number(24) );
	}
	
	@Test
	public void test_sum_checker() {
		P0023main.abundant_numbers = P0023main.getabundant_numbers(P0023main.upper_limit);
		assertTrue ( P0023main.is_SumOf_Abundant_number(24) );
		assertTrue ( P0023main.is_SumOf_Abundant_number(40) );
		assertTrue ( P0023main.is_SumOf_Abundant_number(216 + 220) );
	}
	
	@Test
	public void test_asList() {
		List<Integer> values = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		values.add(100);
		
	}

}
 