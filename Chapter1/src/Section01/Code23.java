package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code23 {
	static String[] words = new String[100000];
	static int [] count = new int [100000];
	static int n;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(true){
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("read")) {
				String fileName = kb.next();
				makeIndex(fileName);
			}
			else if (command.equals("find")) {
				String keyword = kb.next();
				int index = findWord(keyword);
				if(index != -1){
					System.out.println("The word " + keyword + " appears " +count[index] + " times.");
				} else {
					System.out.println("The word " + keyword + " doesn't appear.");
				}
			} else if(command.equals("saveas")){
				String fileName = kb.next();
				saveAs(fileName);
			} else if(command.equals("search")){
				String word = kb.next();
				searchWord(word);
			}else if(command.equals("exit")){
				break;
			}
		}
		kb.close();
	}
	
	private static void searchWord(String word) {
		int c;
		for(int i = 0; i < n; i++){
			c = 0;
			for(int j = 0; j < word.length(); j++){
				if(word.charAt(j) == words[i].charAt(j)){
					c++;
				}
			}
			if(c == word.length()){
				System.out.println(words[i] + " " + count[i]);
			}
		}
	}

	public static String trimming(String str){
		
		if(str == null || str.length() <= 0){
			return null;
		}
		int i = 0, j = str.length()-1;
		while(i<str.length() && !Character.isLetter(str.charAt(i))){
			i++;
		}
		while(j >= 0 && !Character.isLetter(str.charAt(j))){
			j--;
		}
		if(i <= j){
			return checkString(str.substring(i, j+1));
		}else {
			return null;
		}
	}

	private static String checkString(String s) {
		// TODO Auto-generated method stub
		char[] ch = new char[s.length()];
		
		int n = 0;
		for(int i = 0; i < s.length(); i++){
			if(Character.isLetter(s.charAt(i)) || s.charAt(i) == '_' || s.charAt(i) == '-' || s.charAt(i) == '\''){
				ch[n] = s.charAt(i);
				n++;
			}
		}
		return new String(ch);
	}

	private static void saveAs(String fileName) {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			for(int i = 0; i<n; i++){
				out.println(words[i] + " " + count[i]);
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Save faild. Don't ask me why!");
		}
		
	}

	private static void makeIndex(String fileName) {
		// TODO Auto-generated method stub
		try {
			Scanner theFile = new Scanner(new File(fileName));
			while(theFile.hasNext()){
				String word = theFile.next();
				String trimmed = trimming(word);
				if( trimmed != null && trimmed.length() > 2){
					addWord(trimmed.toLowerCase().trim());
					System.out.println(trimmed);
				}
			}
			theFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not exist!");
		}
	}

	private static void addWord(String word) {
		// TODO Auto-generated method stub
		int index = findWord(word);
		if(index > -1){
			count[index]++;
		} else {
			int i = n-1;
			for(; i >=0 && words[i].compareToIgnoreCase(word)>0;i-- ){
				words[i+1] = words[i];
				count[i+1] = count[i];
			}
			words[i+1] = word;
			count[i+1] = 1;
			n++;
		}
	}
	
	private static int findWord(String keyword){
		for(int i = 0; i < n; i++){
			if(words[i].equals(keyword)){
				return i;
			}	
		}
		return -1;
	}
	

}
