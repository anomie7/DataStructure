package MyArrayList;

public class MyArrayListTester {
	public static void main(String[] args){
		MyArrayList<String> myList = new MyArrayList<String>();
		
		myList.add("������");
		myList.add("�����");
		myList.add(0, "�̻�");
		myList.add(1, "���������");
		myList.add("����");
		myList.add("�����");
		myList.add("������");
		myList.add(0, "�����");
		myList.add(1, "������");
		myList.add("�����");
		myList.add("������");
		myList.add("�����");
		myList.add("������");
		myList.add(13, "�����");
		System.out.println(myList.size());
		
		for(int i = 0; i < myList.size(); i++){
			System.out.print(myList.get(i) + " ");
		}
		
		System.out.println(myList.indexOf("����") );
	}
}
