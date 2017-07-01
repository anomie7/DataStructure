package TeskSet02;
import java.io.*;
import java.util.*;

public class TeskSet23 {
	static String[] name = new String[1000];
	static String[] number = new String[1000];
	static int n = 0;
	@SuppressWarnings("resource")
	public static void main(String[] args){
		try {
			Scanner inFile = new Scanner(new File("PhoneBook.txt"));
			while(inFile.hasNextLine()){
				String tmp = inFile.nextLine();
				separate(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}
	}
	private static void separate(String tmp) {
		tmp = getName(tmp);
		System.out.println(" " + tmp);
	}
	
	private static String getName(String tmp) {
		int i = 0;
		ArrayList<Character> chList =  new ArrayList<Character>();
		while(tmp.charAt(i) != '|'){
			chList.add(tmp.charAt(i));
			i++;
		}
		
		StringBuilder str = new StringBuilder(chList.size());
		for( Character c : chList){
			str.append(c);
		}
		name[n] = str.toString();
		name[n] = name[n].trim();
		System.out.print(name[n]);
		n++;
		
		return tmp.substring(i,tmp.length());
	}
}
