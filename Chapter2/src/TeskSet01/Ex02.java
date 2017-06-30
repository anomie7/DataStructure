package TeskSet01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex02 {
		static phoneBook[] person = new phoneBook[100];
		static int n = 0;
	public static void main(String[] args){
		try {
			Scanner inFile = new Scanner(new File("PhoneBook.txt"));
			Scanner kb = new Scanner(System.in);
			while(inFile.hasNext()){
				person[n] = new phoneBook();
				person[n].name = inFile.next();
				person[n++].number = inFile.next();
			}
			while(true){
				System.out.print("$ ");
				String command = kb.next();
				if(command.equals("find")){
					int idx = find(kb.next());
					if(idx > -1){
						System.out.println(person[idx].number);						
					}else{
						System.out.println("찾지 못했습니다.");
					}
				}else if(command.equals("add")){
					person[n] = new phoneBook();
					person[n].name = kb.next();
					person[n++].number = kb.next();
				}else if(command.equals("remove")){
					int idx = find(kb.next());
					remove(idx);
				}else if(command.equals("list")){
					for(int i = 0; i < n; i++){
						System.out.println(person[i].name + " " + person[i].number);
					}
				}else if(command.equals("exit")){
					break;
				}				
			}
			kb.close();
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			System.exit(0);
		}
	}
	private static void remove(int idx) {
		for(int i = idx; i < n;i++){
//			if(i == n-1){
//				person[n++] = new phoneBook();
//			}
			person[i] = person[i+1];
			n--;
		}
	}
	private static int find(String s) {
		for(int i = 0; i < n; i++){
			if(s.equals(person[i].name)){
				return i;
			}
		}
		return -1;
	}

}

class phoneBook{
	String name;
	String number;
}