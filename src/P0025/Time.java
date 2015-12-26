package P0025;


public class Time  {
	int msec;
	int sec;
	int min;
	int hour;
	public Time(){
		msec = 0;
		sec = 0;
		min = 0;
		hour = 0;
	}
	public Time(int hour , int min , int sec , int msec){
		this.msec = msec;
		this.sec = 0;
		this.min = 0;
		this.hour = 0;
	}
	public  void add(int hour ,int min, int sec, int msec){
		this.msec+=msec;
		if(msec>1000){
			this.sec+=this.msec/1000;
			this.msec=this.msec%1000;
		}
		this.sec+=sec;
		if(sec>60){
			this.min+=this.sec/60;
			this.sec=this.sec%60;
		}
		this.min+=min;
		if(min>60){
			this.hour+=this.min/60;
			this.min=this.min%60;
		}
		this.hour+=hour;
		if(hour>=24){
			this.hour=this.hour%24;
		}
	}
	public int getMsec(){
		return msec;
	}
	
	public int getSec() {
		return sec;
	}

	public int getMin() {
		return min;
	}

	public int getHour() {
		return hour;
	}
	
	public Time clone(){
		Time time = new Time(this.getHour() , this.getMin() , this.getSec(), this.getMsec());
		return time;
	}
	@Override
	public String toString() {
		return hour+"H : "+min+"M : "+sec+"S";
	}
	
	
}
