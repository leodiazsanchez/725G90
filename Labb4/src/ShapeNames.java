
public enum ShapeNames {
	CIRCLE(new MyCircle()), SQUARE(new MySquare()), TRIANGLE(new MyTriangle());

	final Shape shape;

	ShapeNames(Shape shape) {
		this.shape = shape;
	}

}
