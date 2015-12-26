package P00029;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ietf.jgss.Oid;

/**
 * term - 항(다향식, 단항식 
 * 
 * 2^10   = new Term(2, 10 );
 * 2  : base(밑수)
 * 10 :지수(exponent)
 * 
 * 27 = 3^3 Term(3, 3);
 * 16 = 4^2, 2^4 Term(2, 4)
 * 100 = 10^2    Term(10, 2)
 * @author anto5710
 *
 */
public class Term {
	private long base;
	private int exp ;
	
	public Term ( long base, int exp) {
		this.base = base;
		this.exp = exp;
	}
	
	/**
	 * 
	 * @param base
	 * @param exp
	 * @return
	 */
	/*
	 * 8 
	 * 1 , 2 , 4 , 8
	 * 2^3
	 * 2 )_8_
	 * 2 )_4_
	 * 2 )_2_
	 *     1
	 * 27
	 * 1 , 3 , 9 , 27
	 * 3^3
	 * 3 )_27_
	 * 3 )_9__
	 * 3 )_3__
	 *     1
	 * 100
	 * 1 , 2 , 5 , 20 , 25 , 50 , 100    
	 * 10^2
	 * 2 )_100_
	 * 2 )_50__
	 * 5 )_25__
	 *     5
	 * 100 = (2*5)^2
	 * 
	 * 216
	 * 
	 * 2 )_216_
	 * 2 )_108_
	 * 2 )_54__
	 * 3 )_27__
	 * 3 )_9___
	 *     3 
	 *
	 *(2*3)^3
	 
	 * 42
	 * 
	 *  
	 * 2 )_42_
	 * 3 )_21_
	 *     7 
	 */
	/**
	 * 
	 * 1) 소인수분해합니다. = > [2, 2, 3, 3]
	 * 2) 지수들이 모두 같은지 확인합니다.
	 * 3) 같을 경우,(소인수들의 곱)^(공통된 지수)를 반환합니다. 
	 * @param value
	 * @return
	 */
	public static Term makeTerm ( long value ) {
		List<Integer>dividers = factorizate(value);
		Map<Integer, Integer> prime_map= getExpornets(dividers);		
		if(util.Uitl.areAllSame(prime_map.values())){
			int exp = new ArrayList<>(prime_map.values()).get(0);
			int base = util.Uitl.MultiplyInteger( prime_map.keySet());
			
			return new Term(base, exp);
		}
		
		return null;
	}
	/**
	 * makeTerm ( 2, 20 );
	 * makeTerm ( 4, 10 ) ;
	 * @param base
	 * @param exp
	 * @return
	 */
	public static Term makeTerm ( long base, int exp ) {
		Term t = makeTerm( base ); // new Term(2, 2);
		
		return new Term ( t.base(), t.exp() * exp );
	}
	/*
	 * 
	 */
	public static HashMap<Integer, Integer> getExpornets(List<Integer> dividers) {
		HashMap<Integer, Integer>prime_map = new HashMap<>();
		for(Integer integer : dividers){
			int value = 0;
			if(prime_map.containsKey(integer)){
				value =prime_map.get(integer);
			}
				prime_map.put(integer, ++value);
		}
		return prime_map;
	}

	public static List<Integer> factorizate(long value){
		List<Integer>dividers = new ArrayList<Integer>();
		long num = value;
		int divider = 2;
		while(!util.Uitl.isPrime(num)){
			if(num%divider!=0){
				while(num%divider!=0){
				divider++;
				}
			}
			num/=divider;
			dividers.add(divider);
		}
		dividers.add((int) num);
		return dividers;
	}

	public long base() {
		return this.base;
	}
	public int exp() {
		return this.exp;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Term ) {
			Term other = (Term) obj; // type casting    int v = (long) longValue;
			return this.base==other.base &&
				   this.exp ==other.exp;
		} else {
			// obj는 타입이 Term이 아님. 따라서 그냥 false 리턴
			return false;
			
		}
	}
	
}
