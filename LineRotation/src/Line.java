public class Line extends Polygon {

	public Line(Point start, Point end) {
		//Point center = new Point((start.x + end.x) / 2,(start.y + end.y) / 2);
		super(new Point((start.x + end.x) / 2,(start.y + end.y) / 2),start,end);
		//this.length = Math.sqrt((start.x - end.x) + (start.y - end.y));
	}

	public Line rotate(int degrees) {
		super.setOrientation(super.getOrientation() + degrees);
		double degreesR = Math.toRadians(degrees);
		Point a = this.pivot(degreesR);
		Point b = this.aPivot(degreesR);
		Point[] points = {a,b};
		super.setEndPoints(points);
		return new Line(a,b);
		
	}
	
	public Line rotatecc(int degrees) {
		super.setOrientation(super.getOrientation() + degrees);
		double degreesR = Math.toRadians(degrees);
		Point a = this.pivot(-1 * degreesR);
		Point b = this.aPivot(-1 * degreesR);
		Point[] points = {a,b};
		super.setEndPoints(points);
		return new Line(a,b);
		
	}
	public Point pivot(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.getCenter().x;
		int startY = super.getCenter().y;
		int endX = super.endPoints[1].x - startX;
		int endY = super.endPoints[1].y - startY;
		int endXNew = (int)Math.round((endX * cos - endY * sin));
		int endYNew = (int)Math.round((endX * sin + endY * cos));
		endX = endXNew + startX;
		endY = endYNew + startY;
		
		return new Point(endX,endY);
	}
	
	public Point aPivot(double angle)
	{
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		int startX = super.getCenter().x;
		int startY = super.getCenter().y;
		int endX = super.endPoints[0].x - startX;
		int endY = super.endPoints[0].y - startY;
		int endXNew = (int)Math.round(endX * cos - endY * sin);
		int endYNew = (int)Math.round(endX * sin + endY * cos);
		endX = endXNew + startX;
		endY = endYNew + startY;
		
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

public Point getStart()
{
	return super.endPoints[0];
}

public Point getEnd()
{
	return super.endPoints[1];
}

public void setStart(Point start)
{
	super.endPoints[0] = start;
}

public void setEnd(Point end)
{
	super.endPoints[0] = end;
}
}
