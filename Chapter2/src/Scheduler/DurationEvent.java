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
		return begin.compareTo(d) <= 0 && end.compareTo(d) >= 0;
	}
}


