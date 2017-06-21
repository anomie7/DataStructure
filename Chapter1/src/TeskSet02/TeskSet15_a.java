package TeskSet02;

import java.util.Random;
import java.util.Scanner;

public class TeskSet15_a {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		
		int[] arr = new int[20];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt(21)-10;
		}
		
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
		
		int cnt = 0;
		int max = 0;
		//boolean isLocalMin = false;
		int k;
		int sp = 0, ep = 0;
		for(int i = arr.length-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				
				for(k = j; k < i; k++){
					if(arr[k] > arr[k+1]){
						cnt++;
					} else{
						break;
					}
				}
				for(; k < i; k++){
					if(k != 0 && arr[k] < arr[k+1]){
						cnt++;
					} else{
						break;
					}
				}
				if( cnt > max){
					max = cnt;
					sp = j;
					ep = k;
				}
				cnt = 0;
				
			}
		}
		
		System.out.println("가장 오목한 길이는 " + (max+1) );
		System.out.print("가장 오목한 배열은 ");
		for(int i = sp; i <= ep; i++)
			System.out.print(arr[i] + " ");
		
		kb.close();
	}

}
