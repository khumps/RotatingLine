public class Polygon {
	private double orientation = 0; //Current rotation of the Polygon
	private final Point center;
	private final Point[] endPoints;
	private final Point[] tempEndPoints;
	public Polygon(Point center, Point... endPoints) {
		this.center = center;
		this.endPoints = endPoints;
	}
	
	public Point rotate(double degrees)
	{
		
	}
	
	public void rotatePolygon(double degrees)
	{
		for(int i = 0; i < endPoints.length; i++)
		{
			pivot(degrees)
		}
	}
	
		public Line rotate(double degrees) {
		Line a = this.pivot(degrees);
		line b = this.aPivot(degrees);
		return new Line(a.endPoint[0], b.endPoint[1])
	}
	
	private Point pivot(Point point, double degrees)
	{
		Line line = new Line(center, point)
		int centerX = center.x;
		int centerY = center.y;
		int distance = (int)(line.length()); // islength of the segment
		int endX = (int)(centerX + distance * Math.cos(degrees));
		int endY = (int)(centerY + distance * Math.sin(degrees));
		return new Point(end.x,end.y));
	}
	
	public Line aPivot(double degrees)
	{
		Line line = new Line(center, point)
		int centerX = center.x;
		int centerY = center.y;
		int distance = (int)(line.length()); // islength of the segment
		int endX = (int)(centerX + distance * Math.cos(degrees * -1));
		int endY = (int)(centerY + distance * Math.sin(de * -1));
		return new Point(end.x,end.y));
	}
	

}
