package Scheduler;

public class DeadlinedEvent extends Event{
public MyDate deadline;
	
	public DeadlinedEvent(String title, MyDate deadline){
		super(title);
		this.deadline = deadline;
	}
	
	public String toString(){
		return super.toString() + deadline.toString();
	}

	public boolean equals(MyDate d){
		return deadline.compareTo(d) >= 0;
	}
}
