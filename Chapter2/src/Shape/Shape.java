package Shape;

public abstract class Shape {
	public String shapeName;
	
	public Shape(String shapeName){
		this.shapeName = shapeName;
	}
	
	public abstract double computeArea();
	public abstract double computePerimeter();
}
