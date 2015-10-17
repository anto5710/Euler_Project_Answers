package P00011;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

public class TestScanner {

	@Ignore @Test
	public void test() {
		String str = "1 2 3 4	5\n6 7 8 9 10";
		Scanner sc = new Scanner(str);
		assertEquals (1, sc.nextInt() );
		assertEquals (2, sc.nextInt() );
		assertEquals (3, sc.nextInt() );
		assertEquals (4, sc.nextInt() );
		assertEquals (5, sc.nextInt() );
		assertEquals (6, sc.nextInt() );
		assertEquals (7, sc.nextInt() );
		assertEquals (8, sc.nextInt() );
		assertEquals (9, sc.nextInt() );
		assertEquals (10, sc.nextInt() );
		assertFalse ( sc.hasNext() );
	}
	
	@Test
	public void test_getLineProductions() {
		int [][] arr  = new int[][]{
				
				{01, 02, 03, 04, 20},
				{05, 06, 07,  8, 30},
				{ 9, 10, 11, 12, 40},
				{13, 14, 15, 16, 50},
		};
		List<Integer> lines;
		lines = Greatest_Product.getLineProductions(arr, 3, 0, 0);
		assertEquals ( 3, lines.size());
		System.out.println(lines+"");
		
		lines = Greatest_Product.getLineProductions(arr, 4, 0, 1); // 02에서
		assertEquals ( 3, lines.size());
		System.out.println(lines);
		
		
		lines = Greatest_Product.getLineProductions(arr, 4, 3, 0);
		assertEquals ( 1, lines.size());
		assertEquals ( 13 * 14 * 15 * 16, lines.get(0).intValue());
		
		lines = Greatest_Product.getLineProductions(arr, 4, 0, 3); // 04
		assertEquals ( 2, lines.size());
		System.out.println(lines);
		
		
		
	}

}
