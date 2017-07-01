package Section01;

import java.util.Scanner;

public class Code18 {
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++){
			arr[i] = stdIn.nextInt();
		}
		
		stdIn.close();
		
		bubbleSort(n, arr);
		
		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
		}
		
	}
	
	public static void bubbleSort(int n, int[] arr){
		
		for(int i = n-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}

}
