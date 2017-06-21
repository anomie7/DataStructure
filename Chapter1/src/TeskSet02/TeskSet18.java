package TeskSet02;

import java.util.Random;

public class TeskSet18 {
	public static void main(String[] args){
		Random rand = new Random();
		
		int n = 5;
		int[][] arr = new int[n][n];
		
		for(int r = 0; r <n; r++)
			for(int c = 0; c < n; c++){
				arr[r][c] = rand.nextInt(9)+1;
			}	
		
		for(int r = 0; r <n; r++){
			for(int c = 0; c < n; c++){
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
//		int value;
//		for(int r = 0; r < n; r++)
//			for(int k = 0; k < arr.length; k++){
//				value = 0;
//				for(int i = k; i < arr.length; i++){
//					value = value*10 + arr[r][i];
//					isPrime(value);
//				}
//				for(int j = 0; j < k; j++){
//					value = value*10 + arr[r][j];
//					isPrime(value);
//				}			
//				
//			}
		
		int value;
		for(int c = 0; c < n; c++)
			for(int k = 0; k < n; k++){
				value = 0;
				for(int i = k; i < n; i++){
					value = value*10 + arr[i][c];
					isPrime(value);
				}
				for(int j = 0; j < k; j++){
					value = value*10 + arr[j][c];
					isPrime(value);
				}			
				
			}
		
	}
	public static void isPrime(int val){
		boolean isPrime = true;
		for(int i = 2; i <= val/2 && isPrime; i++){
			if(val%i == 0){
				isPrime = false;
			}
		}
		if(isPrime && val != 1){
			System.out.println(val + "´Â ¼Ò¼ö");
		}
	}

}
