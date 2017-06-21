package TeskSet02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeskSet13 {
	
	public static void caseSort(String[] name, int[] age, int cnt) {
		// TODO Auto-generated method stub
		for(int i = cnt-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if( age[j] == age[j+1] && name[j].compareTo(name[j+1]) > 0){
					swap(age, name, j);
					
				}
			}
		}
	}
	
	public static void ageSort(String[] name, int[] age, int cnt) {
		// TODO Auto-generated method stub
		for(int i = cnt-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(age[j] > age[j+1]){
					swap(age, name, j);
				}
			}
		}
	}
	
	public static void swap(int[] age, String[] name, int j) {
		// TODO Auto-generated method stub
		int tmp = age[j];
		age[j] = age[j+1];
		age[j+1] = tmp;
		
		String tmpname = name[j];
		name[j] = name[j+1];
		name[j+1] = tmpname;
	}
	
	public static void printArray(String[] name, int[] age, int cnt) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < cnt; i++){
			System.out.println(name[i] + " " + age[i]);
			
		}
	}
	
	public static void main(String[] args){
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
			String[] name = new String[1000];
			int[] age = new int[1000];
			
			int cnt = 0;
			while(inFile.hasNext()){
				name[cnt] = inFile.next();
				age[cnt] = inFile.nextInt();
				cnt++;
			}
			
			ageSort(name, age, cnt);
			
			caseSort(name, age, cnt);
			
			printArray(name, age, cnt);
			
			inFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
