/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(9);
		sierpinski(10, 0.0, 1.0, 0.5, 0.0, 0.0, 0.866);

	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

	double[] xVertex = { 0.0, 1.0, 0.5 };
	double[] yVertex = { 0.0, 0.0, 0.866 };
	double x = 0.0, y = 0.0;
	for (int i = 0; i < n; i++) {
		// Chooses a random index from (0, 1, 2),
		// and draws the midpoint
		int r = (int) (Math.random() * 3);
		x = (x + xVertex[r]) / 2.0;
		y = (y + yVertex[r]) / 2.0;
		StdDraw.point(x, y);
	}
}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
        return;
    }

    
    double mx12 = (x1 + x2) / 2;
    double my12 = (y1 + y2) / 2;

    double mx23 = (x2 + x3) / 2;
    double my23 = (y2 + y3) / 2;

    double mx13 = (x1 + x3) / 2;
    double my13 = (y1 + y3) / 2;

    
    sierpinski(n - 1, x1, mx12, mx13, y1, my12, my13); 
    sierpinski(n - 1, mx12, x2, mx23, my12, y2, my23); 
    sierpinski(n - 1, mx13, mx23, x3, my13, my23, y3); 
}
											
		
											
	}

