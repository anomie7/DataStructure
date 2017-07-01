package Section01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21_2 {
	
	static int n;
	static int[][] arr;
	public static void main(String[] args){
		
		try {
			Scanner inFile = new Scanner(new File("data.txt") );
			n = inFile.nextInt();
			arr = new int[n][n];
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					arr[i][j] = inFile.nextInt();					
				}
			}
			inFile.close();
			
			for(int x = 0; x < n; x++){
				for(int y = 0; y < n; y++){
					for(int dir = 0; dir < 8; dir++){
						for(int len = 0; len <= n; len++){
							int val = computeValue(x, y, dir, len);
							if(val != -1 && isPrime(val)){
								System.out.println(val);
							}
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static boolean isPrime(int val) {
		// TODO Auto-generated method stub
		boolean isPrimeNum = true;
		
		for(int i = 2; i < val/2; i++){
			if(val%i == 0){
				isPrimeNum = false;
				break;
			}
		}
		if(val == 0){
			isPrimeNum = false;
		}
		
		return isPrimeNum;
	}
	
	public static int computeValue(int x, int y, int dir, int len) {
		// TODO Auto-generated method stub
		int value = 0;
		for(int i = 0; i < len; i++){
			int digit = getDigit(x, y, dir, i);
			if(digit == -1){
				return -1;
			}
			value = value*10 + digit;
		}
		return value;
	}
	
	static int[] offsetX = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] offsetY = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static int getDigit(int x, int y, int dir, int k) {
		// TODO Auto-generated method stub
		int newX = x + k*offsetX[dir];
		int newY = y + k*offsetY[dir];
		if(newX < 0 || newX >= arr.length || newY < 0 || newY >= arr.length)
			return -1;
		else
			return arr[newX][newY];
	}

}
