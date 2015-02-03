public class Line extends Polygon {
	private final double length;

	public Line(Point start, Point end) {
		//Point center = new Point((start.x + end.x) / 2,(start.y + end.y) / 2);
		super(new Point((start.x + end.x) / 2,(start.y + end.y) / 2),start,end);
		this.length = Math.sqrt((start.x - end.x) + (start.y - end.y));
	}

	public void rotate(double degrees) {
		Line a = this.pivot(degrees);
		Line b = this.aPivot(degrees);
		Point[] points = {a.endPoints[0],b.endPoints[1]};
		this.endPoints = points;
	}
	
	public Line pivot(double degrees)
	{
		int startX = super.center.x;
		int startY = super.center.y;
		int distance = (int)(this.length() / 2); // length of the segment
		int endX = (int)(startX + distance * Math.cos(degrees));
		int endY = (int)(startY + distance * Math.sin(degrees));
		return new Line(new Point(startX,startY),new Point(endX,endY));
	}
	
	public Line aPivot(double degrees)
	{
		int startX = super.center.x;
		int startY = super.center.y;
		int distance = (int)(this.length() / 2); // length of the segment
		int endX = (int)(startX - distance * Math.cos(degrees));
		int endY = (int)(startY - distance * Math.sin(degrees));
		return new Line(new Point(startX,startY),new Point(endX,endY));
	}


public double length()
{
	return Math.sqrt((super.endPoints[0].x - super.endPoints[1].x) + (super.endPoints[0].y - super.endPoints[1].y));
}


public static void main(String[] args)
{
	Line line = new Line(new Point(0,0), new Point(10,10));
	System.out.println(line.toString());
	line.rotate(90);
	System.out.println(line.toString());
	
}
}