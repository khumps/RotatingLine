public class Line extends Polygon {
	private final double length;

	public Line(Point start, Point end) {
		//Point center = new Point((start.x + end.x) / 2,(start.y + end.y) / 2);
		super(new Point((start.x + end.x) / 2,(start.y + end.y) / 2),start,end);
		this.length = Math.sqrt((start.x - end.x) + (start.y - end.y));
	}

	public void rotate(double degrees) {
		degrees = Math.toRadians(degrees);
		Line a = this.pivot(degrees);
		Line b = this.aPivot(degrees);
		Point[] points = {a.endPoints[1],b.endPoints[1]};
		this.endPoints = points;
	}
	
	public Line pivot(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.center.x;
		int startY = super.center.y;
		int endX = super.endPoints[1].x - startX;
		int endY = super.endPoints[1].y - startY;
		int endXNew = (int)(endX * cos - endY * sin);
		int endYNew = (int)(endX * sin + endY * cos);
		endX = endXNew + startX;
		endY = endYNew + startY;
		
		return new Line(new Point(startX,startY),new Point(endX,endY));
	}
	
	public Line aPivot(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.center.x;
		int startY = super.center.y;
		int endX = super.endPoints[0].x - startX;
		int endY = super.endPoints[0].y - startY;
		int endXNew = (int)(endX * cos - endY * sin);
		int endYNew = (int)(endX * sin + endY * cos);
		endX = endXNew + startX;
		endY = endYNew + startY;
		
		return new Line(new Point(startX,startY),new Point(endX,endY));
	}


public static void main(String[] args)
{
	Line line = new Line(new Point(0,0), new Point(10,10));
	//System.out.println(line.toString());
	System.out.println(line.endPoints[0]);
	System.out.println(line.endPoints[1]);
	line.rotate(1);
	System.out.println(line.endPoints[0]);
	System.out.println(line.endPoints[1]);
	
}
}
