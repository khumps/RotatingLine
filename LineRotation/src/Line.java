public class Line extends Polygon {
	private final int length;

	public Line(Point start, Point end) {
		Point center = new Point((start.x + end.x) / 2,(start.y + end.y) / 2);
		super(center,start,end);
		this.length = 
	}

	@Override
	public Line rotate(double degrees) {
		Line a = this.pivot(degrees);
		line b = this.aPivot(degrees);
		return new Line(a.endPoint[0], b.endPoint[1])
	}
	
	public Line pivot(double degrees)
	{
		int startX = super.center.x;
		int startY = super.center.y;
		int distance = (int)(this.length() / 2); // length of the segment
		int endX = (int)(startX + distance * Math.cos(degrees));
		int endY = (int)(startY + distance * Math.sin(degrees));
		return new Line(new Point(start.x,start.y),new Point(end.x,end.y));
	}
	
	public Line aPivot(double degrees)
	{
		int startX = super.center.x;
		int startY = super.center.y;
		int distance = (int)(this.length() / 2); // length of the segment
		int endX = (int)(startX - distance * Math.cos(degrees));
		int endY = (int)(startY - distance * Math.sin(degrees));
		return new Line(new Point(start.x,start.y),new Point(end.x,end.y));
	}


public double length()
{
	return Math.sqrt((super.endpoints[0].x - super.endPoints[1].x) + (super.endPoints[0].y - super.endPoints[1].y));
}
}
