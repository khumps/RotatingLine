public class Line extends Polygon {

	public Line(Point start, Point end) {
		//Point center = new Point((start.x + end.x) / 2,(start.y + end.y) / 2);
		super(new Point((start.x + end.x) / 2,(start.y + end.y) / 2),start,end);
		//this.length = Math.sqrt((start.x - end.x) + (start.y - end.y));
	}

	public void rotate(double degrees) {
		degrees = Math.toRadians(degrees);
		Point a = this.pivot(degrees);
		Point b = this.aPivot(degrees);
		Point[] points = {a,b};
		super.setEndPoints(points);
		System.out.println("test");
		
	}
	
	public Point pivot(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.getCenter().x;
		int startY = super.getCenter().y;
		int endX = super.getEndPoints()[1].x - startX;
		int endY = super.getEndPoints()[1].y - startY;
		int endXNew = (int)Math.ceil((endX * cos - endY * sin));
		int endYNew = (int)Math.ceil((endX * sin + endY * cos));
		endX = (int) Math.ceil(endXNew + startX);
		endY = (int)Math.ceil(endYNew + startY);
		
		return new Point(endX,endY);
	}
	
	public Point aPivot(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.getCenter().x;
		int startY = super.getCenter().y;
		int endX = super.getEndPoints()[0].x - startX;
		int endY = super.getEndPoints()[0].y - startY;
		double endXNew = (endX * cos - endY * sin);
		double endYNew = (endX * sin + endY * cos);
		endX = (int) Math.floor(endXNew + startX);
		endY = (int)Math.floor(endYNew + startY);
		
		return new Point(endX,endY);
	}


public static void main(String[] args)
{
	Line line = new Line(new Point(0,0), new Point(10,10));
	//System.out.println(line.toString());
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
