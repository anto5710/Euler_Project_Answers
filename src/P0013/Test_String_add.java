package P0013;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_String_add {

	@Test
	public void test() {
		
		assertEquals ("100", P0013Main.add("1", "99")); 
		assertEquals ("99", P0013Main.add("20", "79")); 
		assertEquals ("123", P0013Main.add("32", "91"));
		assertEquals ("1000000", P0013Main.add("1", "999999"));
		
		assertEquals ("333", P0013Main.add("111", "222"));
		/*
		 *   111
		 *   999
		 *  1110
		 */
		assertEquals ("1111111111111111111111111111111111111111111111111111111110",
				P0013Main.add("999999999999999999999999999999999999999999999999999999999", 
						      "111111111111111111111111111111111111111111111111111111111"));
		
		assertEquals ("52", P0013Main.add("45", "7"));
		
	}
	@Test
	public void testchange() {
		String sa =   "1";
		String sb = "12345";
		
//		assertEquals ("54321", P0013Main.change(sb)); 
	}

}
