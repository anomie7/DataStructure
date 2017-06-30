package Chaper1;

public class MyRectangle1 {
	public MyPoint1 lu;
	public int width;
	public int height;
	
	public MyRectangle1(int x, int y, int h, int w){
		lu = new MyPoint1(x, y);
		height = h;
		width = w;
	}
	
	public int calcArea(){
		return width * height;
	}
	
	public String toString(){
		return "(" + lu.x + " , " + lu.y + ") " + "πÿ∫Ø : " + width + " ≥Ù¿Ã: " + height;
	}
	
	
}
