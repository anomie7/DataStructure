package MyArrayList;

public class MyArrayListTester {
	public static void main(String[] args){
		MyArrayList<String> myList = new MyArrayList<String>();
		
		myList.add("정예라");
		myList.add("사랑해");
		myList.add(0, "이쁜");
		myList.add(1, "사랑스러운");
		myList.add("정말");
		myList.add("사랑해");
		myList.add("정예라");
		myList.add(0, "사랑해");
		myList.add(1, "정예라");
		myList.add("사랑해");
		myList.add("정예라");
		myList.add("사랑해");
		myList.add("정예라");
		myList.add(13, "사랑해");
		System.out.println(myList.size());
		
		for(int i = 0; i < myList.size(); i++){
			System.out.print(myList.get(i) + " ");
		}
		
		System.out.println(myList.indexOf("정말") );
	}
}
