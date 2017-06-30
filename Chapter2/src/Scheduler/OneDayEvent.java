package Scheduler;

public class OneDayEvent extends Event{
	public MyDate date;
	
	public OneDayEvent(String title, MyDate date){
		super(title);
		this.date = date;
	}
	
	public String toString(){
		return super.toString() + date.toString();
	}

	public boolean equals(MyDate d){
		if(date.year == d.year && date.month == d.month && date.day == d.day)
			return true;
		return false;
	}
	
}
