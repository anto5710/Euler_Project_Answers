package P00033;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class TestP00033 {

	@Ignore @Test
	public void test_find_common_num() {
		assertEquals ( Arrays.asList(2, 3), P00033main.findCommonNum(123, 332226));
		assertEquals ( Arrays.asList(3,9), P00033main.findCommonNum(394,395 ));
		
		assertEquals ( Arrays.asList(4), P00033main.findCommonNum(44, 49 ));
		assertEquals ( Arrays.asList(5), P00033main.findCommonNum(45, 95 ));
		
	}
	
	@Test
	public void  test_replace_in_String () {
//		String emptyString = ""; // not a number form!!!
		
		Fraction replaced = P00033main.replaceFraction(44, 49);
		assertEquals ( "4 / 9", replaced.toString());
		
		int a = 32425;
		int removed=P00033main.remove(a, 2);		
		assertEquals(3425, removed );
	}
	
	@Test
	public void test_Reducting(){
		Fraction f = new Fraction(22, 44);
		f.reduct();
		
		assertEquals(new Fraction(1,2), f  );
	
		f = new Fraction(13, 17);
		f.reduct();
		
		assertEquals(new Fraction(13,17), f  );
	}
	
	@Test
	public void test_mulplifcation() {
		Fraction f = new Fraction ( 1, 1) ;
		f.mutiply(new Fraction ( 2, 5));
		f.mutiply(new Fraction(3, 5));
		
		assertEquals ( new Fraction(6, 25), f);
	}
	
	
	

}
