package P005;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class TestP005 {

	@Test
	public void test_getPrime() {
		List<Integer> primes = 
				dohyun.getprime(12); // 2 * 2 * 3
		assertNotNull (primes );
//		System.out.println(primes);
		assertEquals ( 3, primes.size());
		
		assertEquals ( 2, primes.get(0).intValue());
		assertEquals ( 2, primes.get(1).intValue());
		assertEquals ( 3, primes.get(2).intValue());
	}
	
	@Test
	public void test_isPrime() {
		assertFalse ( dohyun.isPrime(1) );
		assertTrue ( dohyun.isPrime(2) );
		assertTrue ( dohyun.isPrime(3));
		assertFalse ( dohyun.isPrime(4));
		assertFalse ( dohyun.isPrime(10));
		
		
	}
	
	@Test
	public void test_substract() {
		List<Integer> l0 = new ArrayList<>(Arrays.asList(2, 3, 2));
		List<Integer> l1 = new ArrayList<>(Arrays.asList(3, 5));
		List<Integer> remaining = dohyun.substract(l0, l1); // [2, 3, 2] - [3, 5] -> [2, 2]
		assertEquals ( 2, remaining.get(0).intValue());
		assertEquals ( 2, remaining.get(1).intValue());
		assertEquals ( 2, remaining.size());
		
		// [2, 2, 3, 5, 7, 7] - [ 3, 3, 5, 7] =  [2,2,7]   /[2,2]
		l0 = new ArrayList<>(Arrays.asList(2, 2, 3, 5, 7, 7));
		l1 = new ArrayList<>(Arrays.asList(3, 3, 5, 7));
		remaining= dohyun.substract(l0, l1);
		System.out.println(remaining);
		assertEquals ( 3, remaining.size());
		assertEquals ( Arrays.asList(2, 2, 7), remaining);
		
	}
	

}
