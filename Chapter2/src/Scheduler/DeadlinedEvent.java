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
		if(deadline.year > d.year){
			return true;	
		}else if(deadline.year == d.year){
			if(deadline.month > d.month){
				return true;
			}else if(deadline.month == d.month && deadline.day > d.day ){
				return true;
			}else if(deadline.month == d.month && deadline.day == d.day ){
				return true;
			}
		}
		return false;
	}
}
