package P0024;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPnode {

	@Test
	public void test() {
		/*
		 *  0 : 0123
		 *      0131
		 *      0213
		 *      0231
		 *      0312
		 * 5 :  0321
		 *  
		 * 6  : 1023
		 *      1032
		 *      1203
		 *      1230
		 * 10   1302
		 * 11   1320
		 *      
		 *    : 2xxx
		 */
		Pnode root = new Pnode("", "0123", 0);
		Pnode n1302 = root.find(10);
		assertEquals ( "1302", n1302.getCurrent() + n1302.getNums());
	}
	
	@Test
	public void big_testcase() {
		Pnode root = new Pnode("", "0123456789ABDDEFGHIJKLMN", 0);
		Pnode n = root.find(100_000_000);
		System.out.println(n.getCurrent() + n.getNums());
	}

}

