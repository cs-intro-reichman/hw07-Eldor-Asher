/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		int n = 6;   // עומק הרקורסיה
    snowFlake(n);
		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        return;
    }

    double dx = x2 - x1;
    double dy = y2 - y1;

    double xB = x1 + dx / 3;
    double yB = y1 + dy / 3;

    double xD = x1 + 2 * dx / 3;
    double yD = y1 + 2 * dy / 3;

    double angle = Math.PI / 3;
    double xC = xB + (Math.cos(angle) * (xD - xB) - Math.sin(angle) * (yD - yB));
    double yC = yB + (Math.sin(angle) * (xD - xB) + Math.cos(angle) * (yD - yB));

    curve(n - 1, x1, y1, xB, yB);
    curve(n - 1, xB, yB, xC, yC);
    curve(n - 1, xC, yC, xD, yD);
    curve(n - 1, xD, yD, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
	StdDraw.setXscale(0, 1.1);
    StdDraw.setYscale(0, 1.1);

    double x1 = 0.1, y1 = 0.2;
    double x2 = 0.9, y2 = 0.2;
    double x3 = 0.5, y3 = 0.2 + Math.sqrt(3) / 2 * 0.8;

    curve(n, x1, y1, x2, y2);
    curve(n, x2, y2, x3, y3);
    curve(n, x3, y3, x1, y1);
	}
}
