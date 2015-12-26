package P00029;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class P00029test {

	@Test
	public void test() {
		System.out.println(Term.factorizate(36));
		System.out.println(Term.factorizate(216));
		System.out.println(Term.factorizate(100));
		System.out.println(Term.factorizate(17));
	}
	@Test
	public void test_makeTerm(){
		Term term = Term.makeTerm(36);
		System.out.println(term.base()  + "^" + term.exp());
		assertEquals(new Term(6, 2), term );
		
		term = Term.makeTerm(30);
		assertEquals ( new Term(30 , 1),term);
		
	}
	@Test
	public void test_util_areAllSame(){
		List <Integer>primes = Arrays.asList(2, 2, 2);
		assertTrue ( util.Uitl.areAllSame(primes) );
	}

}
