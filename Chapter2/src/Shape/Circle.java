package Shape;

public class Circle extends Shape{
	public int radius;
	
	public Circle(int radius) {
		super("Circle");
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double computePerimeter() {
		return 2.0 * Math.PI * radius;
	}
	
	@Override
	public String toString() {
		return "Circle: width is " + radius;
	}
}
