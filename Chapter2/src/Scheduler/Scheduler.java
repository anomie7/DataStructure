package Scheduler;

import java.util.Scanner;

public class Scheduler {
	int capacity = 10;
	int n = 0;
	Event[] events = new Event[capacity];
	Scanner stdIn;
	
	public void processCommand(){
		stdIn = new Scanner(System.in);
		
		while(true){
			System.out.print("$ ");
			String command = stdIn.next();
			if(command.equals("addevent")){
				handleOneDayAdd();
			}else if(command.equals("list")){
				for(int i = 0; i < n; i++){
					System.out.println(events[i]);
				}
			}else if(command.equals("show")){
				searchEvent();
			}else if(command.equals("exit")){
				break;
			}
		}
	}
	
	private void handleOneDayAdd() {
		String selEvent = stdIn.next();
		if(selEvent.equalsIgnoreCase("oneday")){
			System.out.print("when ");
			String date = stdIn.next();
			System.out.print("title ");
			String title = stdIn.next();
			MyDate tmpDate = parseDate(date);
			
			addEvent(new OneDayEvent(title, tmpDate));
		}
		
	}

	private void searchEvent() {
		String str = stdIn.next();
		MyDate d = parseDate(str);
		
		for(int i = 0; i < n; i++){
			if( events[i].equals(d) == true ){
				System.out.println(events[i]);
				break;
			}
		}
		
	}

	private void addEvent(Event oe) {
		if(capacity >=n )
			reAllocation();
		events[n++] = oe;
	}

	private void reAllocation() {
		Event[] tmpArray = new Event[capacity*2];
		for(int i = 0; i < n; i++)
			tmpArray[i] = events[i];
		
		events = tmpArray;
		capacity *= 2;
	}

	private MyDate parseDate(String date) {
		String[] tmp = date.split("/");
		
		int y = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int d = Integer.parseInt(tmp[2]);
		
		return new MyDate(y, m, d);
	}

	public static void main(String[] args){
		Scheduler sch = new Scheduler();
		sch.processCommand();
	}
}
