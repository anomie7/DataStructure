package TeskSet01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Chaper1.MyRectangle1;

public class Ex01 {
	static MyRectangle1[] rects = new MyRectangle1[100];
	static int n = 0;
	public static void main(String[] args){
		try {
			Scanner source = new Scanner(new File("data.txt"));
			Scanner kb = new Scanner(System.in);
			
			while(source.hasNext()) {
				rects[n++] = new MyRectangle1(source.nextInt(), source.nextInt(), 
						source.nextInt(), source.nextInt());
				
			}	
				System.out.println("사각형 하나를 입력합니다.");
				System.out.print("x 좌표: ");
				int x = kb.nextInt();
				System.out.print("y 좌표: ");
				int y = kb.nextInt();
				System.out.print("밑변: ");
				int w = kb.nextInt();
				System.out.print("높이: ");
				int h = kb.nextInt();
				
				rects[n++] = new MyRectangle1(x, y, h, w);
				
				kb.close();
				source.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file exists.");
			System.exit(1);
		}
		bubbleSort();
		for(int i = 0; i < n; i++){
			System.out.println(rects[i]);
		}
	}
	private static void bubbleSort() {
		for(int i = n-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if( rects[j].calcArea() > rects[j+1].calcArea() ){
					MyRectangle1 tmp = rects[j]; 
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
}
