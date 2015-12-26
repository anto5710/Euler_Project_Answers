package P00032;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.Uitl;

public class TestP00032 {

	@Test
	public void test() {
		String target = "12345678";
		int size= 1; // 4 x 3 = 12
		
		List<String> answers = new ArrayList<String>();
		P00032main.combination(answers, target, size, "");
		System.out.println("result");
		int rownum = 1;
		for ( String s : answers){
			System.out.println(s);
		}
		System.out.println("# of case : " + answers.size());
	}
	
	@Test
	public void test_util_strip() {
		String src= "123456789";
		String result = Uitl.strip(src, "2468");
		assertEquals ( "13579", result);
	}

}
