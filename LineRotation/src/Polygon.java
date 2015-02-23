public class Polygon {
	private final Point center;
	protected Point[] endPoints;
	protected Point[] tempEndPoints;
	private int orientation;
	public Polygon(Point center, Point... endPoints) {
		setOrientation(0);
		this.center = center;
		this.endPoints = endPoints;
		this.tempEndPoints = endPoints;
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
	public Point[] getEndPoints() {
		return endPoints;
	}



	public void setEndPoints(Point[] endPoints) {
		for(int i = 0; i < this.endPoints.length; i++)
			this.getEndPoints()[i] = endPoints[i];
	}



	public Point[] getTempEndPoints() {
		return tempEndPoints;
	}



	public void setTempEndPoints(Point[] tempEndPoints) {
		this.tempEndPoints = tempEndPoints;
	}



	public Point getCenter() {
		return center;
	}



	public int getOrientation() {
		return orientation;
	}



	public void setOrientation(int orientation) {
		this.orientation = orientation % 360;
	}

}
