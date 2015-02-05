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
			//pivot(this.endPoints[i],degrees);
		}
	}
	
	public String toString()
	{
		String str = "";
		for(Point point:endPoints)
			str += point.toString() + ", ";
		return str;
	}
	

}
