package Section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {
	
	static Person[] member = new Person[100];
	static int cnt = 0;
	
	public static void main(String[] args) {
		try {
			Scanner inFile = new Scanner(new File("input.txt"));
			
			while(inFile.hasNext()){
				String nm = inFile.next();
				String nb = inFile.next();
				
				member[cnt] = new Person(nm, nb);
				cnt++;
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("has not file");
		}
		
		bubbleSort();
		
		for(int i = 0; i < cnt; i++){
			System.out.println(member[i].getName() + " " + member[i].getNumber() );
		}
		
		
	}

	private static void bubbleSort() {

		for(int i = cnt - 1; i > 0; i-- ){
			for(int j = 0; j < i; j++){
				if(member[j].getName().compareToIgnoreCase(member[j+1].getName()) > 0 ){
					Person tmp = member[j];
					member[j] = member[j+1];
					member[j+1] = tmp;
				}
			}
		}
		
	}

}
