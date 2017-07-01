package Section01;

import java.util.Scanner;

public class Code16 {
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		System.out.println("Please enter two integers and press Enter");
		
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		
		int result = power(a, b);
		System.out.println("The result is " + result);
		stdIn.close();
	}
	
	public static int power(int n, int m){
		int result = 1;
		for(int i = 0; i<m; i++){
			result *= n;
		}
		return result;
	}

}
