/**
 * 
 * @author Kevin Humphreys
 * A Polygon is a set of points
 */
public class Polygon {
	/**
	 * <b>Data</b>
	 * @param center the geometric center of the Polygon
	 * @param endPoints The starting endpoints of the Polygon
	 * @param tempEndpoints The endpoints that change as the Polygon is rotated
	 * @param orientation How much the Polygon is rotated
	 */
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
	
	
/*	public void rotatePolygon(double degrees) 				Didnt get this to work
	{
		for(int i = 0; i < endPoints.length; i++)
		{
			//pivot(this.endPoints[i],degrees);
		}
	}*/
	
	/**
	 * 
	 * @return String representation of all the endpoints in the Polygon
	 */
	public String toString()
	{
		String str = "";
		for(Point point:endPoints)
			str += point.toString() + ", ";
		return str;
	}
	
	/**
	 * 
	 * @return An array of the endpoints of the Polygon
	 */
	public Point[] getEndPoints() {
		return endPoints;
	}
/*	public void setEndPoints(Point[] endPoints) {
		for(int i = 0; i < this.endPoints.length; i++)
			this.getEndPoints()[i] = endPoints[i];
	}*/



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
