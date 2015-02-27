/**
 * 
 * @author Kevin Humphreys
 * A Line is a Polygon with 2 Points
 */
public class Line extends Polygon
{
	/**
	 * 
	 * @param start The starting Point of the Line
	 * @param end	The end Point of the Line
	 */
	public Line(Point start, Point end) {
		// Point center = new Point((start.x + end.x) / 2,(start.y + end.y) /
		// 2);
		super(new Point((start.x + end.x) / 2, (start.y + end.y) / 2), start,
				end);
		// this.length = Math.sqrt((start.x - end.x) + (start.y - end.y));
	}

	/**
	 * rotates the Line about super.center
	 * @param degrees the number of degrees the line will be rotated
	 * @return the new Line that results from rotating the old Line
	 */
	public Line rotate(int degrees) {
		super.setOrientation(super.getOrientation() + degrees);
		double degreesR = Math.toRadians(super.getOrientation());
		Point a = this.pivot(degreesR);
		Point b = this.aPivot(degreesR);
		Point[] points = { a, b };
		super.setTempEndPoints(points);
		return new Line(a, b);

	}

	/**
	 * pivots half of the Line about super.center
	 * @param angle the angle(in degrees) that the line segment rotates
	 * @return The new end Point of the line segment(not super.center)
	 */
	private Point pivot(double angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.getCenter().x;
		int startY = super.getCenter().y;
		int endX = super.endPoints[1].x - startX;
		int endY = super.endPoints[1].y - startY;
		int endXNew = (int) Math.round((endX * cos - endY * sin));
		int endYNew = (int) Math.round((endX * sin + endY * cos));
		endX = endXNew + startX;
		endY = endYNew + startY;

		return new Point(endX, endY);
	}

	/**
	 * pivots half of the Line about super.center
	 * @param angle the angle(in degrees) that the line segment rotates
	 * @return The new end Point of the line segment(not super.center)
	 */
	private Point aPivot(double angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.getCenter().x;
		int startY = super.getCenter().y;
		int endX = super.endPoints[0].x - startX;
		int endY = super.endPoints[0].y - startY;
		int endXNew = (int) Math.round(endX * cos - endY * sin);
		int endYNew = (int) Math.round(endX * sin + endY * cos);
		endX = endXNew + startX;
		endY = endYNew + startY;

		return new Point(endX, endY);
	}

	/**
	 * 
	 * @return The start Point of the Line
	*/
	public Point getStart() {
		return super.endPoints[0];
	}

	/**
	 * 
	 * @return The end Point of the Line
	 */
	public Point getEnd() {
		return super.endPoints[1];
	}

	public void setStart(Point start) {
		super.endPoints[0] = start;
	}

	public void setEnd(Point end) {
		super.endPoints[0] = end;
	}

	public static void main(String[] args) {
		Line line = new Line(new Point(0, 0), new Point(10, 10));
		// System.out.println(line.toString());
		System.out.println(line.getEndPoints()[0]);
		System.out.println(line.getEndPoints()[1]);
		line.rotate(1);
		System.out.println(line.getEndPoints()[0]);
		System.out.println(line.getEndPoints()[1]);
		line.rotate(1);
		System.out.println(line.getEndPoints()[0]);
		System.out.println(line.getEndPoints()[1]);

	}


}
