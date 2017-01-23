package hue03.task1.src;

public class Hole {
	private int _top, _left, _width, _height;

	public Hole(int top, int left, int width, int height) throws HoleException {
		if (top < 0 || left < 0 || width < 0 || height < 0)
			throw new HoleException("one or more values are < 0");

		_top = top;
		_left = left;
		_width = width;
		_height = height;
	}

	public Hole(int top, int left) throws HoleException {
		this(top, left, 0, 0);
	}

	public void increaseWidth() {
		_width++;
	}

	public void increaseHeight() {
		_height++;
	}

	public int getTop() {
		return _top;
	}

	public int getLeft() {
		return _left;
	}

	public int getHeight() {
		return _height;
	}

	public int getWidth() {
		return _width;
	}
}
