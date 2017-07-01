package Shape;

public class RtTriangle extends Shape{
	public int width, height;
	
	public RtTriangle(int width, int height) {
		super("RtTriangle");
		this.width = width;
		this.height = height;
	}

	@Override
	public double computeArea() {
		return width * height /2;
	}

	@Override
	public double computePerimeter() {
		return width + height + Math.sqrt((double) width * width + height * height) ;
	}
	
	@Override
	public String toString() {
		return "RtTriangle: width is " + width + "height is " + height;
	}
}
