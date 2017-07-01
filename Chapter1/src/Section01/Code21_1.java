package Section01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Code21_1 {
	static int n;
	static int[][] arr;
	
	public static void main(String[] args){
		
		try{
			Scanner inFile = new Scanner(new File("data.txt") );
			n = inFile.nextInt();
			arr = new int[n][n];
			for( int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					arr[i][j] = inFile.nextInt();
				}
			}
			inFile.close();
		
		for(int x = 0; x < n; x++){
			for(int y = 0; y < n; y++){
				for(int dir=0; dir < 8; dir++){
					for(int length = 1; length <= n; length++){
						int value = computeValue(x, y, dir, length);
						if(value != -1 && isPrime(value)){
							System.out.println(value);
						}
					}
				}
			}
		}
		
		 } catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	}

	public static boolean isPrime(int n) {
		// TODO Auto-generated method stub
		boolean isPrimeNum = true;
		
		for(int i = 2; i < n/2; i++){
			if(n%i == 0){
				isPrimeNum = false;
				break;
			}
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
			value = value*10+digit;
		}
		return value;
	}

	public static int getDigit(int x, int y, int dir, int k) {
		// TODO Auto-generated method stub
		int newX = x, newY = y;
		switch(dir) {
			case 0: 
				newY -= k; 
				break;
			case 1:
				newX += k;
				newY -= k;
				break;
			case 2:
				newX += k;
				break;
			case 3:
				newX += k;
				newY += k;
				break;
			case 4:
				newY += k;
			case 5:
				newX -= k;
				newY += k;
				break;
			case 6:
				newX -= k;
				break;
			case 7:
				newX -= k;
				newY -= k;
				break;
		}
		if(newX < 0 || newX >= n || newY < 0 || newY >= n){
			return -1;
		}
		return arr[newY][newX];
	}

}
