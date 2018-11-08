import java.awt.Color;
public class SeamCarver {
	Picture picture;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.picture = picture;
	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {
		return picture.width();
		//return 0;
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if(y == picture.height() - 1 || y == 0 || x == 0 || x == picture.width() - 1) {
			return 1000;
		}
		Color color = picture.get(x, y);
		Color right = picture.get(x + 1, y);
		Color left = picture.get(x-1, y);
		Color upper = picture.get(x , y - 1);
		Color lower = picture.get(x , y + 1);
		int redXG = right.getRed() - left.getRed();
		int greenXG = right.getGreen() - left.getGreen();
		int blueXG = right.getBlue() - left.getBlue();
		int xG = redXG * redXG + greenXG * greenXG + blueXG * blueXG;
		int redYG = lower.getRed() - upper.getRed();
		int greenYG = lower.getGreen() - upper.getGreen();
		int blueYG = lower.getBlue() - upper.getBlue();
		int yG = redYG * redYG + greenYG * greenYG + blueYG * blueYG;
		double energy = Math.sqrt(xG+yG);
		return energy;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}