package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
	public static void main(String[] args){
		String[] name = new String[1000];
		String[] number = new String[1000];
		int count = 0;
		
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
			
			while(inFile.hasNext()){
				name[count] = inFile.next();
				number[count] = inFile.next();
				count++;
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bubbleSort(count, name, number);
		
		for(int i = 0; i < count; i++){
			System.out.println(name[i] + "'s Phone Numer is " + number[i]);
		}
		
	}

	public static void bubbleSort(int n, String[] name, String[] number) {
		for(int i = n-1; i > 0; i-- ){
			for(int j = 0; j < i; j++){
				if(name[j].compareToIgnoreCase(name[j+1]) > 0){
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					
					tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
				}
			}
		}
		
	}

}
