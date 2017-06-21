package TeskSet02;
import java.util.*;

public class TeskSet22 {
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		while(true){
			System.out.print("$ ");
			String command = stdIn.next();
			
			if(command.equals("test")){
				boolean isAnagram = compareStr(stdIn.next(), stdIn.next());
				if(isAnagram){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}else if(command.equals("exit")){
				break;
			}
			stdIn.close();
		}
	}

	private static boolean compareStr(String s1, String s2) {
		boolean isequals;
		if(s1.length() != s2.length()){
			return false;
		}else{
			TreeMap<Character, Integer> index1 =getIndex(s1);
			TreeMap<Character, Integer> index2 =getIndex(s2);
			
			isequals = compareIdx(index1, index2);
		}
		return isequals;
	}

	private static boolean compareIdx(TreeMap<Character, Integer> idx1, TreeMap<Character, Integer> idx2) {
		// TODO Auto-generated method stub
//		printIdx(idx1);
//		printIdx(idx2);
		Set<Character> k1 = idx1.keySet();
		Set<Character> k2 = idx2.keySet();
		
		if(k1.size() != k2.size()){
			return false;
		}else{
			Iterator<Character> itr1 = k1.iterator();
			Iterator<Character> itr2 = k2.iterator();
			
			while(itr1.hasNext()){
				if(itr1.next() == itr2.next()){
				
				}else{
					return false;
				}
			}
			return true;
		}
	}

	@SuppressWarnings("unused")
	private static void printIdx(TreeMap<Character, Integer> idx) {
		// TODO Auto-generated method stub
		Set<Character> keys = idx.keySet();
		Iterator<Character> itr = keys.iterator();
		while(itr.hasNext()){
			char ch = itr.next();
			System.out.print(ch + ": " + idx.get(ch) + " ");
		}
		System.out.println();
	}

	private static TreeMap<Character, Integer> getIndex(String s1) {
		TreeMap<Character, Integer> index = new TreeMap<Character, Integer>();
		
		for(int i =0; i < s1.length(); i++){
			if(index.get(s1.charAt(i)) == null ){
					index.put(s1.charAt(i), 1);
			}else{
				int c = index.get(s1.charAt(i));
				c++;
				index.put(s1.charAt(i),c);
			}
		}
		
		return index;
	}
}
