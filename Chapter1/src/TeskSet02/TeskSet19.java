package TeskSet02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeskSet19 {
	public static void main(String[] args){
		try {
			Scanner inFile = new Scanner(new File("input19.txt"));
			
			int n = inFile.nextInt();
			int[][] arr = new int[n][n];
			
			int r = 0, c = 0;
			while(inFile.hasNext()){
				arr[r][c] = inFile.nextInt();
				
				r++;
				c++;
			}
			inFile.close();
			
			for(int i = 1; i < n; i++){
				c = i;
				r = 0;
				for(int j = n-i; j > 0; j--){
					arr[r][c] = 
							arr[r][c-1] > arr[r+1][c] ? arr[r][c-1] - arr[r+1][c] 
														: arr[r+1][c] - arr[r][c-1];
					
					r++;
					c++;
				}
//				a++;
			}
			
			for(int i = 1; i < n; i++){
				c = 0;
				r = i;
				for(int j = n-i; j > 0; j--){
					arr[r][c] = 0;
					
					r++;
					c++;
				}
//				a++;
			}
			
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
