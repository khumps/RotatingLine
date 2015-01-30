public abstract class Polygon {
	private double orientation = 0; //Current rotation of the Polygon
	private final Point center;
	private final Point[] endPoints;
	public Polygon(Point center, Point... endPoints) {
		this.center = center;
		this.endPoints = endPoints;
	}
	
	public abstract void rotate(double degrees);

}
