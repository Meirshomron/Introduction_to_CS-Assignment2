
/*
* make a new point
*/




public class Point {

private int x,y;
	// constructor function that makes a new point with both coordinates 
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	// returns the x coordinates of a point object
	public int getX() {
		return this.x;
	}
	
	// returns the y coordinates of a point object
	public int getY() {
		return this.y;
	}
}
