package MyArrayList;

import java.util.Arrays;

public class MyArrayList<T> {
	private static final int INITIAL_CAPACITY = 10;
	private T[] theData;
	private int size;
	private int capacity;
	
	public int size() {
		return size;
	}
	
	public int indexOf(T anEntry){
		
		for(int i = 0; i < size; i++){
			if( theData[i].equals(anEntry))
				return i;
		}
		return -1;
	}

	public MyArrayList(){
		size = 0;
		capacity = INITIAL_CAPACITY;
		theData = (T[]) new Object[capacity];
	}
	
	public void add(T data){
		if(size >= capacity)
			reallocation();
		theData[size++] = data;
	}
	
	public void add(int index, T data){
		if(index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException(index);
		if(size >= capacity)
			reallocation();
		
		for(int i = size; i > index; i--){
			theData[i] = theData[i-1];
		}
		theData[index] = data;
		size++;
	}
	
	public T get(int index){
		return theData[index];
	}
	
	public T remove(int index){
		T rmvData = theData[index];
		for(int i = index; i < size-1; i++){
			theData[i] = theData[i+1];
		}
		size--;
		return rmvData;
	}
	
	public T set(int index, T data){
		T rmvData = theData[index];
		
		theData[index] = data;
		
		return rmvData;
	}
	
	private void reallocation() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
	}
	
}
