package TeskSet02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeskSet16_b {
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
			
			for(int i = 0; i <= num; i++){ //start point
				for(int j = i+1; j <= num; j++){ //end point
					char[] c2 = getStr(c, i, j);
					
					String tmp = new String(c2); //c2를 문자열로 바꿔준다.
					
					compareStr(tmp);
				}
			}
			kb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void compareStr(String tmp) {
		for(int l = 0; l <= n; l++){  //n은 srtFile의 구성요소 수
			if(tmp.equals(fileStr[l]) ) 
				System.out.println(tmp);
		}	
	}

	public static char[] getStr(char[] c, int i, int j) {
		
		char[] c2 = null; //c2 선언
		int a = 0;
		int cnt = 0;
		for(int k = i; k < j; k++){ // int[] getStr(int[] str, i, j);
			if(k == i){
				a = j - k;  //검색할 문자열의 길이 
				c2 = new char[a];							
				cnt = 0;
			}
			c2[cnt] = c[k];   //검색한 배열을 c2에 넣어줌
			cnt++;
				}
		return c2;
	}

}
