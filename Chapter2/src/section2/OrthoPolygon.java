package section2;

import Chaper1.MyPoint1;

public class OrthoPolygon {
	public int n = 0;
	public MyPoint1[] vertices;
	
	public OrthoPolygon(int k){
		vertices = new MyPoint1[k];
	}
	
	public void addVertex(int x, int y){
		vertices[n++] = new MyPoint1(x, y);
	}
	
	public int maxX(){
		int max = vertices[0].x;
		for(int i = 1; i < n; i++)
			if(vertices[i].x > max)
				max = vertices[i].x;
		return max;
	}
	
	public boolean contains(MyPoint1 p){
		OrthoLine arrow = new OrthoLine(p, new MyPoint1(maxX()+1, p.y));
		int count = 0;
		for(int i = 0; i < n; i++){
			OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1)%n]);
			if(edge.intersects(arrow))
				count++;
		}
		return count%2 != 0;
	}
	
}
