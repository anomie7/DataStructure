package Scheduler;

public class Event {
	public String title;
	
	public Event(String title){
		this.title = title;
	}
	
	public String toString(){
		return title + ", ";
	}
	
	public boolean equals(MyDate d){
		return false;
	}
}
