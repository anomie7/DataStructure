package Shape;

public abstract class Shape implements Comparable{
	public String shapeName;
	
	public Shape(String shapeName){
		this.shapeName = shapeName;
	}
	
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	public int compareTo(Object other){
		double myArea = computeArea();
		double yourArea = ((Shape) other).computeArea();
		if(myArea < yourArea) return -1;
		else if(myArea == yourArea) return 0;
		else return 1;
	}
}
