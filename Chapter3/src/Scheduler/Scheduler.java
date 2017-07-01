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
				String selEvent = stdIn.next();
				if(selEvent.equalsIgnoreCase("oneday") ){
					handleOneDayAdd();
				}else if(selEvent.equalsIgnoreCase("duration")){
					handelDurationAdd();
				}else if(selEvent.equalsIgnoreCase("deadline")){
					handelDeadlineAdd();
				}
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
	
	private void handelDeadlineAdd() {
		System.out.print("until ");
		String until = stdIn.next();
		System.out.print("title ");
		String title = stdIn.next();
		
		MyDate deadline = parseDate(until);
		
		addEvent(new DeadlinedEvent(title, deadline) );
	}

	private void handelDurationAdd() {
		System.out.print("begin ");
		String begin = stdIn.next();
		System.out.print("end ");
		String end = stdIn.next();
		System.out.print("title ");
		String title = stdIn.next();
		
		MyDate beginDate = parseDate(begin);
		MyDate endDate = parseDate(end);
		
		addEvent(new DurationEvent(title, beginDate, endDate));
	}

	private void handleOneDayAdd() {
			System.out.print("when ");
			String date = stdIn.next();
			System.out.print("title ");
			String title = stdIn.next();
			MyDate tmpDate = parseDate(date);
			
			addEvent(new OneDayEvent(title, tmpDate));
	}

	private void searchEvent() {
		String str = stdIn.next();
		MyDate d = parseDate(str);
		
		for(int i = 0; i < n; i++){
			if( events[i].equals(d)){
				System.out.println(events[i]);
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
