package Chaper1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {
	static MyRectangle1[] rects = new MyRectangle1[100];
	static int n = 0;
	public static void main(String[] args){
		try {
			Scanner source = new Scanner(new File("data.txt"));
			while(source.hasNext()) {
				rects[n++] = new MyRectangle1(source.nextInt(), source.nextInt(), 
											source.nextInt(), source.nextInt());
			}	
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
