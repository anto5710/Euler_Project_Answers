package P0012;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestP0012 {

	@Test
	public void checking_getPrimes() {
		List<Integer> primes = P0012Class.getPrimeNums(2);
		// 2 , 2 ,3
		assertEquals ( 1, primes.size());
		assertEquals (Arrays.asList(2), primes);
		
		primes = P0012Class.getPrimeNums(2*3*5);
		assertEquals (3, primes.size());
		assertEquals ( Arrays.asList(2, 3, 5), primes);
	}
	
	@Test
	public void checking_countDidivers() {
//		List<Integer> primes = Arrays.asList(2, 2, 2, 3);
		int nDividers = P0012Class.countDivisors(24);
		assertEquals ( 8, nDividers); 
		
		nDividers = P0012Class.countDivisors(16);
		assertEquals ( 5, nDividers); // 1, 2, 4, 8, 16
	}

}
