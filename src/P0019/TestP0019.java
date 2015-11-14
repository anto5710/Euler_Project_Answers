package P0019;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestP0019 {

	@Test
	public void test_forwarding_7days() {
		Date d = new Date(1899, 12, 31);
		d = d.nextDate(7); // 요일
//		d.getDate() ==1 ;
		System.out.println(d); // 토요일
	}

}
