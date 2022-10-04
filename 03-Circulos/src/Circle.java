
public class Circle {
	private double x, y, r, perimeter, area;
	
	public Circle(double a, double b, double c) {
		x=a;y=b;r=c;
		}
	
	public double getPerimeter() {
		return 2*Math.PI*r;
	}
	
	public double getArea() {
		return Math.PI*r*r;
	}
	
	public double distanceToCenter(double a, double b) {
		return Math.sqrt((a-x)*(a-x)+(b-y)*(b-y)) ;
	}
	
	public boolean containsPoint(double a, double b) {
		return distanceToCenter(a,b)<=r;
	}
	
	public boolean containsCircle(Circle other) {
		return distanceToCenter(other.x,other.y) <= this.r-other.r;
	}
	
	public boolean intersectsCircle(Circle other) {
		return distanceToCenter(other.x,other.y) <= this.r+other.r;
	}
}
