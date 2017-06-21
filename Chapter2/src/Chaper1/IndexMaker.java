package Chaper1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexMaker {
	static Item[] item = new Item[100000];
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
					System.out.println("The word " + keyword + " appears " + item[index].count + " times.");
				} else {
					System.out.println("The word " + keyword + "doesn't appear.");
				}
			} else if(command.equals("saveas")){
				String fileName = kb.next();
				saveAs(fileName);
			} else if(command.equals("exit")){
				break;
			}
		}
		kb.close();
		
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
			return str.substring(i, j+1);
		}else {
			return null;
		}
	}
	private static void saveAs(String fileName) {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			for(int i = 0; i<n; i++){
				out.println(item[i].word + " " + item[i].count);
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
				if( trimmed != null)
					addWord(trimmed.toLowerCase());
			}
			theFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not exist!");
		}
	}

	private static void addWord(String word) {
		// TODO Auto-generated method stub
		item[n] = new Item();
		
		int index = findWord(word);
		if(index > -1){
			item[index].count++;
		} else {
			int i = n-1;
			for(; i >=0 && item[i].word.compareToIgnoreCase(word)>0;i-- ){
				item[i+1] = item[i];
			}
			item[i+1].word = word;
			item[i+1].count = 1;
			n++;
		}
	}
	
	private static int findWord(String keyword){
		for(int i = 0; i < n; i++){
			if(item[i].word.equals(keyword)){
				return i;
			}	
		}
		return -1;
	}
	

}
