public class Line extends Polygon {
	private int length;
	private Point end1;
	private Point end2;

	public Line(PolarCoord center, int length) {
		super(center);
		this.length = length;
	}

	@Override
	public void rotate(double degrees) {
		
	}

}
