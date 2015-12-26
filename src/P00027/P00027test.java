package P00027;

import static org.junit.Assert.*;

import org.junit.Test;

public class P00027test {

	@Test
	public void test() {
	
	int size =P00027main.countPrimes(1, 41);
	assertEquals(40, size);
	size  =P00027main.countPrimes(-79, 1601);
	assertEquals(size, 80);
	
	/*
	 * n*n -999*n - 999
	 * 
	 * n == 0, f(0) = -999 소수인가???????????????
	 */
	size  =P00027main.countPrimes(-999, -999);
	assertEquals(0,0);
	
	}
	@Test
	public void testIsPrime() {
		assertFalse ( util.Uitl.isPrime(-2));
	}

}
