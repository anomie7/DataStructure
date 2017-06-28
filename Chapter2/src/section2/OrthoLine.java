package section2;

import Chaper1.MyPoint1;

public class OrthoLine {
	public MyPoint1 u;
	public MyPoint1 v;
	
	public OrthoLine(MyPoint1 p, MyPoint1 q){
		u = p;
		v = q;
		if(p.x > q.x || p.x == q.x && p.y > q.y)
			swap();
	}
	
	private void swap(){
		MyPoint1 tmp = u;
		u = v;
		v = tmp;
	}
	
	public boolean isVertical(){
		return u.x == v.x;
	}
	
	public boolean intersects(OrthoLine other){
		if(isVertical() && !other.isVertical())
			return (other.u.x < u.x && other.v.x > v.x && other.u.y > u.y && other.v.y < v.y );
		else if(!isVertical() && other.isVertical())
			return (other.u.y < u.y && other.v.y > v.y && other.u.x > u.x && other.v.x < v.x);
		else
			return false;
	}
}
