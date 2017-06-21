package TeskSet02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TeskSet14 {
	static int n;
	static int[] arr;
	static int sel;
	static int max = 0;

	public static void main(String[] args) {
		try {
			Scanner inFile = new Scanner(new File("Array.txt"));
			Scanner stdIn = new Scanner(System.in);
			n = inFile.nextInt();

			arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = inFile.nextInt();
			}

			inFile.close();

			int max1 = 0, max2 = 0;
			while (true) {
				max = 0;
				System.out.print("(0)--- 내림차순  (1) --- 오름차순 (2) --- exit");
				sel = stdIn.nextInt();
				if (sel == 0) {
					max1 = getLongLength();
					System.out.println("가장 긴 내림차순 수열 : " + max1);
				} else if (sel == 1) {
					max2 = getLongLength();
					System.out.println("가장 긴 오름차순 수열 : " + max2);
				} else {
					break;
				}

			}
			
			stdIn.close();

			System.out.print("가장 긴 수열: ");
			System.out.println((max1 > max2 ? max1 : max2));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getLongLength() {
		int len = 0, longLen = 0;
		for (int i = 0; i < n; i++) {
			len = getLength(i);

			longLen = compareCending(len);
		}

		return longLen;

	}

	public static int getLength(int i) {

		int length = 0;

		for (int j = i; j < n - 1; j++) {
			if(selCending(j) == -1){
				return length += 0;
			}
			
			length += selCending(j);
		}
		return length;
	}

	public static int selCending(int j) {
		if (arr[j] > arr[j + 1] && sel == 0) {
			return 1;
		} else if (arr[j] < arr[j + 1] && sel == 1) {
			return 1;
		}
		return -1;
	}

	public static int compareCending(int len) {
		if (len > max) {
			max = len;
		}
		return max;
	}
}
