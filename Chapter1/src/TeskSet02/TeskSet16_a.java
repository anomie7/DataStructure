package TeskSet02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeskSet16_a {
	static int n = 0;
	static String[] fileStr = new String[1000];
	
	public static void main(String[] args){
		try {
			Scanner inFile = new Scanner(new File("input2.txt"));	
			while(inFile.hasNext() ){
				fileStr[n] = inFile.next();
				n++;
			}
			
			inFile.close();
			Scanner kb = new Scanner(System.in);
			
			System.out.print("요소 수 : ");			
			int num = kb.nextInt();
			
			char[] c = new char[num];
			System.out.println(num + "개의" + "문자를 입력해주세요.");
			for(int i = 0; i < num; i++){
				c[i] = kb.next().charAt(0);
			}
			
			System.out.print("내가 입력한 문자 배열 : ");
			for(char i : c){
				System.out.print(i);
			}
			System.out.println(); 
			
			int a = 0;
			int cnt = 0;
			for(int i = 0; i <= num; i++){
				for(int j = i+1; j <= num; j++){
					char[] c2 = null;
					for(int k = i; k < j; k++){
						if(k == i){
							a = j - k;
							c2 = new char[a];							
							cnt = 0;
						}
						c2[cnt] = c[k];
						cnt++;
							}
					
					String tmp = new String(c2);
		
					for(int l = 0; l <= n; l++){
						if(tmp.equals(fileStr[l]) ) 
							System.out.println(tmp);
					}	
				}
			}
			
			kb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
