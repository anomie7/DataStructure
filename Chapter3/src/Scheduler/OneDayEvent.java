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
		return this.date.compareTo(d ) == 0;
	}
	
}
