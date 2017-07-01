package Section01;

public class Code17 {
	public static void main(String[] args){
		int n = 100;
		
		for(int i = 2; i <= n; i++ ){
			if(isPrime(i)){
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(int n){
		
		boolean isPrimeNum = true;
		for(int i = 2; i <= n/2; i++){
			if(n%i == 0){
				isPrimeNum = false;
				break;
			}
		}
		return isPrimeNum;
	}

}
