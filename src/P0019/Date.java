package P0019;

public class Date extends Object {
	int Year;
	int Month;
	int date;
	
	public Date(int year, int month, int date ) {
		super();
		Year = year;
		Month = month;
		this.date = date;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Date nextDate() {
		return Date.getNextDay(this);
	}

	public static Date getNextDay(Date Date){
		int year = Date.getYear();
		int month = Date.getMonth();
		int date = Date.getDate()+1;
		int daysInMonth = getDaysOfMonth(year, month);
		if(date>daysInMonth){
			date-=daysInMonth;
			month++;
			if(month>12){
				month-=12;
				year++;
			}
		}
		
		
		return new Date(year, month, date);
	}
	/**
	 * leap year - 윤년을 고려해야 합니다.
	 * 
	 * 1 - 31
	 * 2 - 28 / 29
	 * 3 - 31 
	 * 4 - 30
	 * 5 - 31
	 * 6 - 30
	 * 7 - 31
	 * 8 - 31
	 * 9 - 30
	 * 10 - 31
	 * 11 - 30
	 * 12 - 31
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth ( int year, int month ) {
	int[]days_of_Months =new int[]{31 , 28 , 31 , 30 ,31 ,30 , 31 ,31 , 30 ,31 ,30 ,31};
	int DaysOfMonth = days_of_Months[month-1];
		if(month==2){
			DaysOfMonth = 28;
			boolean is_Leap_Year = ((year%4==0&&year%100!=0)||(year%400==0));
			if(is_Leap_Year){
				DaysOfMonth++;
			}
			return DaysOfMonth;
		}
		return DaysOfMonth;
	}

	@Override
	public String toString() {
		return "Date [" + Year + "-" + Month + "-" + date+ "]";
	}

	public Date nextDate(int day) {
		Date date = this;
		for(int c = 0 ; c< day ; c++){
			date=	date.nextDate();
		}
		return date;
	}
	
	
}
