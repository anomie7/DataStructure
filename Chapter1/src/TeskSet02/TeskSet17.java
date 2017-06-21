//package TeskSet02;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class TeskSet17 {
//	public static void main(String[] args){
//		try {
//			Scanner Filein = new Scanner(new File("MulArray.txt"));
//			Scanner kb = new Scanner(System.in);
//			
//			int n = Filein.nextInt();
//			int[][] arr = new int[n][n];
//			
//			while(Filein.hasNext()){
//				for(int i = 0; i < n; i++){
//					for(int j = 0; j < n; j++){
//						arr[i][j] = Filein.nextInt();
//					}
//				}
//			}
//			
//			int an = 2;
//			int row = 0;
//			int col = 0;
//			boolean isequal = true;
//			
//			int j;
//			while(true){
//				
//				for(j = n-1; j > 0; j--){	
//					
//					int p = 1;
//					row = 0;	
//					col = j;
//					for(int i =j; i < an; i++){
//						if(arr[row][col] != 1) {
//							isequal = false;
//							break;
//						}
//						col += p;
//					}
//					
//					col--;
//					
//					int cnt = 0;
//					int a = 1;
//					while(an-1 > cnt){
//						for(int i = j; i < an-a && isequal; i++){
//							row += p;
//							if(arr[row][col] != 1) {
//								isequal = false;
//								break;
//							}	
//						}
//						
//						p *= -1;
//						
//						for(int i = j; i < an-a && isequal; i++){
//							col += p;
//							if(arr[row][col] != 1) {
//								isequal = false;
//								break;
//							}	
//						}
//						
//						cnt++;
//						a++;
//					}
//					if(isequal){
//						System.out.println("모든 검사값이 1");
//					} else{
//						System.out.println("false");
//					}
//					
//					
//				
//				}
//				
//				//반복문 초기값 i에 j를 assignment 하고 col에 j를 넣어준다.
//				
//			}		
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}
