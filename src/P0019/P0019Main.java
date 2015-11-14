package P0019;
/**
 
 * @author anto5710
 *
 */
public class P0019Main {
	public static void main(String []args){
		
		int nSundayBy2000 = getCountOfSundays(2000);
		int nSundayBy1900 = getCountOfSundays(1900);
		System.out.println(nSundayBy2000 - nSundayBy1900);
//		
//		Date today = new Date(2015, 10, 31);
//		today.nextDate(7);
//		Date nov01 = today.nextDate();
//		System.out.println(nov01.toString());
//		Date nom30 = null;
//		nov01 = nov01.nextDate();
//		System.out.println(nov01.toString());
//	
//		for ( int i = 0 ; i < 28 ; i++) {
//			nov01 = nov01.nextDate();
//		}
//		
//		nov01 = nov01.nextDate();
//		System.out.println(nov01);
//		
//		Date d20040227 = new Date(2004, 2, 27);
//		d20040227  = Date.getNextDay(d20040227);
//		d20040227  = Date.getNextDay(d20040227);
//		d20040227  = Date.getNextDay(d20040227);
////		Date d = new Date(1998, 11, 12);
////		Date d2 = d.getNextDay();
//		System.out.println(d20040227);
//		
//		Date d = new Date(2015, 1, 1);
//		for ( int i = 0 ; i < 365 ; i++) {
//			System.out.println(d);
//			d = d.nextDate();
//		}
//		
	}
	
	
	
	
	public static int getCountOfSundays(int year  ){
		int count = 0;
		Date sunday = new Date(1899,12 , 31);
		while(sunday.getYear()<=year){
			sunday = sunday.nextDate(7);
			if(sunday.getDate()==1){
				count++;
			}
			
		}
	
		
		return count ;
	}
}
