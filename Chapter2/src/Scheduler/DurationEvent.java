package Scheduler;

public class DurationEvent extends Event {
	public MyDate begin;
	public MyDate end;
	
	public DurationEvent(String title, MyDate begin, MyDate end){
		super(title);
		this.begin = begin;
		this.end = end;
	}
	
	public String toString(){
		return super.toString() + begin.toString() + " ~ " + end.toString();
	}

	public boolean equals(MyDate d){
		if( d.year > begin.year && d.year < end.year ){
			return true;
		}else if(d.year == begin.year && d.year == end.year){
			if(d.month > begin.month && d.month < end.month){
				return true;
			}else if(d.month == begin.month && d.month == end.month){
				if( (d.day > begin.day && d.day < end.day) || d.day == begin.day && d.day == end.day){
					return true;
				}
			}
		}else if(d.year == begin.year){
			if(d.month > begin.month){
				return true;
			}else if( d.month == begin.month && d.day > begin.day){
				return true;
			}else if(d.month == begin.month && d.day == begin.day){
				return true;
			}
		}else if(d.year == end.year){
			if(d.month < end.month){
				return true;
			}else if(d.month == end.month && d.day < end.day){
				return true;
			}else if(d.month == end.month && d.day == end.day){
				return true;
			}
		}	
			
		
		return false;
	}
}


