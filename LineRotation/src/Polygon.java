public class Polygon {
	private double orientation = 0; //Current rotation of the Polygon
	protected final Point center;
	protected Point[] endPoints;
	private Point[] tempEndPoints;
	public Polygon(Point center, Point... endPoints) {
		this.center = center;
		this.endPoints = endPoints;
	}
	
	/*public Point rotate(double degrees)
	{
		
	}*/
	
	public void rotatePolygon(double degrees)
	{
		for(int i = 0; i < endPoints.length; i++)
		{
			pivot(this.endPoints[i],degrees);
		}
	}
	
	private Point pivot(Point point, double degrees)
	{
		Line line = new Line(center, point);
		int centerX = center.x;
		int centerY = center.y;
		int distance = (int)(line.length()); // islength of the segment
		int endX = (int)(centerX + distance * Math.cos(degrees));
		int endY = (int)(centerY + distance * Math.sin(degrees));
		return new Point(endX,endY);
	}
	
	public Point aPivot(Point point, double degrees)
	{
		Line line = new Line(center, point);
		int centerX = center.x;
		int centerY = center.y;
		int distance = (int)(line.length()); // islength of the segment
		int endX = (int)(centerX + distance * Math.cos(degrees * -1));
		int endY = (int)(centerY + distance * Math.sin(degrees * -1));
		return new Point(endX,endY);
	}
	
	public String toString()
	{
		String str = "";
		for(Point point:endPoints)
			str += point.toString() + ", ";
		return str;
	}
	

}
