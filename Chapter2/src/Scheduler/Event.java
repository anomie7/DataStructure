package Scheduler;

public abstract class Event {
	public String title;
	
	public Event(String title){
		this.title = title;
	}
	
	public String toString(){
		return title + ", ";
	}
	
	public abstract boolean equals(MyDate d);
}
